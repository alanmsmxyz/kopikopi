/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kopikopi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Azka
 */
public class ControllerManageOrder extends MouseAdapter implements ActionListener {
    private ViewManageOrder view;
    private List<Menu> listMenu;
    private Map<Integer, Menu> mapMenu;
    private List<Order> listOrder;
            
    public ControllerManageOrder() {
        view = new ViewManageOrder();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        
        listMenu = Menu.getList();
        mapMenu = new HashMap<Integer,Menu>();
        for (int i = 0; i < listMenu.size(); i++) {
            mapMenu.put(listMenu.get(i).getId(), listMenu.get(i));
        }
        
        listOrder = new ArrayList<Order>();

        this.updateListOrdersView();
    }
    
    // ActionEvent handler
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnFinishOrder())) {
            this.btnFinishOrderActionPerformed();
        } else if (source.equals(view.getBtnUpdateOrders())) {
            this.btnUpdateOrdersActionPerformed();
        }
    }
    
    public void btnFinishOrderActionPerformed() {
        if(view.getSelectedOrder() != -1) {
            listOrder.get(view.getSelectedOrder()).finishOrder();
            
            if (listOrder.get(view.getSelectedOrder()).isFinished()) {
                listOrder.remove(view.getSelectedOrder());                
                updateListOrdersView();
                view.showPopup("Order telah diselesaikan.", "Informasi", 1);
            } else {
                view.showPopup("Gagal menyelesaikan order.", "Kesalahan Sistem", 0);
            }
        } else {
            view.showPopup("Pastikan sudah memilih order terlebih dahulu.", "Kesalahan Input", 0);
        }
    }
    
    public void btnUpdateOrdersActionPerformed() {
        updateListOrdersView();
    }
    
    // MouseEvent handler
    @Override
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if (source.equals(view.getListOrders())) {
            int index = view.getSelectedOrder();
            List<Order.Item> items = listOrder.get(index).getItems();
            Object[][] o = new Object[items.size()][4];
            
            System.out.println("YOOOOYOOOO");
            System.out.println(items);
            for(int i = 0; i < items.size(); i++) {
                o[i] = new Object[] {
                    items.get(i).getMenu().getName(),
                    items.get(i).getQty(),
                    String.format("%,d", items.get(i).getMenu().getPrice()),
                    String.format("%,d", items.get(i).getPrice())
                };
            }
            
            view.updateItemsTable(o);
        }
    }
    
    // Reusable methods for view manipulations
    private void updateListOrdersView() {
        // Always update listOrder to get latest order data
        listOrder = Order.getList(mapMenu);

        String[] s = new String[listOrder.size()];
        for(int i = 0; i< this.listOrder.size(); i++) {
            s[i] = this.listOrder.get(i).toString();
        }
        
        view.updateListOrders(s);
        view.resetItemsTable();
    }
}
