/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kopikopi;

/**
 *
 * @author Azka
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ControllerCreateOrder extends MouseAdapter implements ActionListener {
    private ViewCreateOrder view;
    private List<Menu> listMenu;
    private Order order;

    public ControllerCreateOrder() {
        view = new ViewCreateOrder();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);

        listMenu = Menu.getList();

        setMenuSelectionView();
        order = new Order();
    }

    // ActionEvent handling
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnAddItem())) {
            btnAddItemActionPerformed();
        } else if (source.equals(view.getBtnConfirmOrder())) {
            btnConfirmOrderActionPerformed();
        }
    }

    public void btnAddItemActionPerformed() {
        if (view.getSelectedMenu() != -1 && view.getSelectedMenuQty() != 0) {
            order.addItem(
                    listMenu.get(view.getSelectedMenu()),
                    view.getSelectedMenuQty()
            );

            updateItemsTableView();
            view.resetItemInput();
        } else {
            view.showPopup("Pastikan menu sudah dipilih dan jumlah kopi sudah diisi dengan benar.", "Kesalahan Input", 0);
        }
    }

    public void btnConfirmOrderActionPerformed() {
        if (!order.getItems().isEmpty()) {
            order.saveOrder();

            if(order.getId() != -1) {
                order = new Order();
                view.resetItemInput();
                view.resetItemsTable();
                view.resetTotalPrice();   
                view.showPopup("Berhasil menyimpan order.", "Informasi", 1);
            } else {
                view.showPopup("Gagal menyimpan order.", "Kesalahan Sistem", 0);
            }
        } else {
            view.showPopup("Pastikan minimal sudah ada 1 menu yang dipilih.", "Kesalahan Input", 0);
        }
    }

    // MouseEvent handling
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getTableItems())) {
            order.removeItem(view.getSelectedItem());
            updateItemsTableView();
        }
    }

    // Reusable methods for view manipulations
    public void setMenuSelectionView() {
        String[] menu = new String[listMenu.size()];
        for (int i = 0; i < listMenu.size(); i++) {
            menu[i] = listMenu.get(i).getName();
        }

        view.setMenuSelection(menu);
    }

    public void updateItemsTableView() {
        Object[][] o = new Object[order.getItems().size()][4];
        for (int i = 0; i < order.getItems().size(); i++) {
            o[i] = new Object[]{
                order.getItems().get(i).getMenu().getName(),
                order.getItems().get(i).getQty(),
                String.format("%,d",order.getItems().get(i).getMenu().getPrice()),
                String.format("%,d",order.getItems().get(i).getPrice())
            };
        }

        view.updateItemsTable(o);
        view.updateTotalPrice(String.format("%,d",order.getTotalPrice()));
    }
}
