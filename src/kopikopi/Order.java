/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kopikopi;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.time.*;

/**
 *
 * @author Byatriasa
 */
public class Order implements DB{
    private int id;
    private LocalDateTime date;
    private List<Item> items;
    private boolean isFinished;

    public Order() {
        this.id = -1;  // default id for Order that doesn't exist in DB
        this.date = LocalDateTime.now();
        this.items = new ArrayList<Item>();
        this.isFinished = false;
    }
    
    private Order(int id, LocalDateTime date, boolean isFinished) {
        this.id = id;
        this.date = date;
        this.isFinished = isFinished;
        
        this.items = new ArrayList<Item>();
    }

    public int getId() {
        return this.id;
    }
    
    public boolean isFinished() {
        return this.isFinished;
    }
       
    
    public int getTotalPrice() {
        int totalprice = 0;
        for (Item i : items) {
            totalprice += i.getPrice();
        }
        
        return totalprice;
    }
    // Item Subclass
    public List<Item> getItems() {
        return this.items;
    }

    public void addItem(Menu menu, int qty) {
        items.add(new Item(menu, qty));
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public class Item {
        private Menu menu;
        private int qty;

        public Item(Menu menu, int qty) {
            this.menu = menu;
            this.qty = qty;
        }

        public Menu getMenu() {
            return menu;
        }

        public int getQty() {
            return qty;
        }

        public int getPrice() {
            return menu.getPrice() * qty;
        }
    }
    
    // DB 
    public boolean finishOrder() {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "UPDATE order_data SET is_finished = true WHERE id = ?";

        try {
            conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, this.id);

            int rows = stmt.executeUpdate();
            if (rows > 0) this.isFinished = true;
        } catch (SQLException e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if(conn != null) conn.close();
                if(stmt != null) stmt.close();
            } catch (Exception e) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return isFinished;
    }

    public void saveOrder() {
        Connection conn = null;
        PreparedStatement stmtOrder = null;
        PreparedStatement stmtItem = null;
        String queryOrder = "INSERT INTO order_data (date, is_finished) VALUES (?,?)";
        String queryItem = "INSERT INTO order_item (order_id, menu_id, qty) VALUES (?,?,?)";
        int generatedId = -1;
        
        try {
            conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
            conn.setAutoCommit(false);
            
            stmtOrder = conn.prepareStatement(queryOrder, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtOrder.setObject(1, this.date);
            stmtOrder.setBoolean(2, this.isFinished);
            
            stmtOrder.executeUpdate();
            ResultSet rs = stmtOrder.getGeneratedKeys();
            
            if(rs.next()) {
                generatedId = rs.getInt(1);                
            }
            
            if (generatedId != -1) {
                stmtItem = conn.prepareStatement(queryItem);
                for (int i = 0; i < this.items.size(); i++) {
                    stmtItem.setInt(1, generatedId);
                    stmtItem.setInt(2, this.items.get(i).getMenu().getId());
                    stmtItem.setInt(3, this.items.get(i).getQty());                    
                    stmtItem.addBatch();
                }
                int[] rows = stmtItem.executeBatch();

                if (rows.length == this.items.size()) {
                    conn.commit();
                    this.id = generatedId;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if(conn != null) conn.close();
                if(stmtOrder != null) stmtOrder.close();
                if(stmtItem != null) stmtItem.close();
            } catch (Exception e) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
  
    public static List<Order> getList(Map<Integer, Menu> mapMenu){
        Connection conn = null;
        PreparedStatement stmtOrder = null;
        PreparedStatement stmtItem = null;
        String queryOrder = "SELECT * FROM order_data WHERE is_finished = false ORDER BY id ASC";
        String queryItem = "SELECT menu_id, qty FROM order_item WHERE order_id = ?";
        
        List<Order> listOrder = new ArrayList<Order>();

        try {
            conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
            stmtOrder = conn.prepareStatement(queryOrder);
            ResultSet rsOrder = stmtOrder.executeQuery();

            while(rsOrder.next()) {
                listOrder.add( new Order(
                        rsOrder.getInt("id"),
                        rsOrder.getTimestamp("date").toLocalDateTime(),
                        rsOrder.getBoolean("is_finished")
                ));
            }
            rsOrder.close();

            stmtItem = conn.prepareStatement(queryItem);

            for(Order order : listOrder) {
                stmtItem.setInt(1, order.getId());
                ResultSet rsItem = stmtItem.executeQuery();
                while(rsItem.next()) {
                    order.addItem(mapMenu.get(rsItem.getInt("menu_id")), rsItem.getInt("qty"));
                }

                rsItem.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.close();
                if(stmtOrder != null) stmtOrder.close();
                if(stmtItem != null) stmtItem.close();                
            } catch (Exception e) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
            }
            return listOrder;
        }
    }
    
    // Misc
    @Override
    public String toString() {
        return "Order #" + this.id;
    }
}
