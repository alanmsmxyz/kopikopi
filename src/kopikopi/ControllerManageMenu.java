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

public class ControllerManageMenu extends MouseAdapter implements ActionListener {

    private ViewManageMenu view;
    private List<Menu> listMenu;

    public ControllerManageMenu() {
        view = new ViewManageMenu();
        view.addActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);

        listMenu = Menu.getList();
        
        updateTableMenusView();
    }

    // ActionEvent handler
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnAddMenu())) {
            btnAddMenuActionPerformed();
        }
    }

    public void btnAddMenuActionPerformed() {
        if (view.getMenuName() != "" && view.getMenuPrice() != 0) {
            Menu menu = new Menu(view.getMenuName(), view.getMenuPrice());
            menu.saveMenu();
            
            if (menu.getId() != -1) {
                listMenu.add(menu);
                updateTableMenusView();
                view.resetMenuInput();
                view.showPopup("Berhasil menambahkan menu ke database.", "Informasi", 1);
            } else {
                view.showPopup("Gagal menambahkan menu ke database.", "Kesalahan Sistem", 0);
            }

        } else {
            view.showPopup("Pastikan nama dan harga menu sudah diisi dengan benar.", "Kesalahan Input", 0);
        }
    }

    // MouseEvent Handler
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getMenusTable())) {
            int index = view.getSelectedMenu();
            
            listMenu.get(index).removeMenu();
            
            if (listMenu.get(index).getId() == -1) {
                listMenu.remove(index);
                updateTableMenusView();
                view.showPopup("Berhasil menghapus menu dari database.", "Informasi", 1);
            } else {
                view.showPopup("Gagal menghapus menu dari database.", "Kesalahan Sistem", 0);
            }
        }
    }

    // Reusable methods for view manipulations
    public void updateTableMenusView() {
        Object[][] o = new Object[listMenu.size()][3];
        for (int i = 0; i < listMenu.size(); i++) {
            o[i] = new Object[]{
                listMenu.get(i).getId(),
                listMenu.get(i).getName(),
                String.format("%,d", listMenu.get(i).getPrice())
            };
        }

        view.updateTableMenus(o);
    }
}
