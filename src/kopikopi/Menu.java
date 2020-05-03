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


/**
 *
 * @author Byatriasa
 */
public class Menu implements DB {
    private int id;
    private String name;
    private int price;
    
    public Menu(String name, int price){
        this.id = -1; // default id for Menu that doesn't exist in DB
        this.name = name;
        this.price = price;
    }
    
    private Menu(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPrice(){
        return price;
    }

    // Database 
    public void saveMenu() {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "INSERT INTO menu(name, price) VALUES (?,?)";

        try {
            conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
            stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, this.name);
            stmt.setInt(2, this.price);

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            System.out.println(rs);
          
            if(rs.next()) {
                this.id = rs.getInt(1);                
            }
            
            rs.close();
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
    }
    
      public void removeMenu() {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "DELETE FROM menu WHERE id = ?";

        try {
            conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
            stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, this.id);

            if (stmt.executeUpdate() > 0) {
                this.id = -1;
            }
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
    }
    
    
    
    public static List<Menu> getList() {
        System.out.println("FINDING LOVE :*");
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "SELECT * FROM menu";
        
        List<Menu> listMenu = new ArrayList<Menu>();
        
        try {
            conn = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
            stmt = conn.prepareStatement(query);
           
            ResultSet rs = stmt.executeQuery();

            System.out.println("GETTING LOVE :*");
            while(rs.next()) {
                listMenu.add(new Menu(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price")
                ));
            }
        } catch (SQLException e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if(conn != null) conn.close();
                if(stmt != null) stmt.close();                
            } catch (Exception e) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
            }
            return listMenu;
        }
    }
}