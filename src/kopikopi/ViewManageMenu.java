/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kopikopi;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author alanmsmxyz
 */
public class ViewManageMenu extends javax.swing.JFrame {
    DefaultTableCellRenderer alignCenter = new DefaultTableCellRenderer();
    DefaultTableCellRenderer alignRight = new DefaultTableCellRenderer();
    DefaultTableCellRenderer alignLeft = new DefaultTableCellRenderer();
    
    DefaultTableModel tableMenusModel;
    
    /**
     * Creates new form CustomerView
     */
    public ViewManageMenu() {
        initComponents();
        
        alignCenter.setHorizontalAlignment(JLabel.CENTER);
        alignRight.setHorizontalAlignment(JLabel.RIGHT);
        alignLeft.setHorizontalAlignment(JLabel.LEFT);
       
        // tableMenus's cells text alignment
        tableMenus.getTableHeader().setDefaultRenderer(alignCenter);
        tableMenus.getColumnModel().getColumn(0).setCellRenderer(alignCenter);
        tableMenus.getColumnModel().getColumn(1).setCellRenderer(alignLeft);        
        tableMenus.getColumnModel().getColumn(2).setCellRenderer(alignRight);
        
        // cast tableMenus table model as DefaultTableModel
        tableMenusModel = (DefaultTableModel) tableMenus.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdmin = new javax.swing.JPanel();
        labelMenuName = new javax.swing.JLabel();
        inputMenuName = new javax.swing.JTextField();
        labelMenuPrice = new javax.swing.JLabel();
        inputMenuPrice = new javax.swing.JTextField();
        btnAddMenu = new javax.swing.JButton();
        containerTableMenuList = new javax.swing.JScrollPane();
        tableMenus = new javax.swing.JTable();
        labelRemoveMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMenuName.setText("Nama Menu");

        labelMenuPrice.setText("Harga");

        inputMenuPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMenuPriceActionPerformed(evt);
            }
        });

        btnAddMenu.setText("Tambahkan Menu");
        btnAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMenuActionPerformed(evt);
            }
        });

        tableMenus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Menu", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMenus.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableMenus.setGridColor(new java.awt.Color(0, 0, 0));
        tableMenus.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMenus.setShowGrid(true);
        tableMenus.getTableHeader().setResizingAllowed(false);
        tableMenus.getTableHeader().setReorderingAllowed(false);
        containerTableMenuList.setViewportView(tableMenus);
        if (tableMenus.getColumnModel().getColumnCount() > 0) {
            tableMenus.getColumnModel().getColumn(0).setResizable(false);
            tableMenus.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableMenus.getColumnModel().getColumn(1).setResizable(false);
            tableMenus.getColumnModel().getColumn(1).setPreferredWidth(220);
            tableMenus.getColumnModel().getColumn(2).setResizable(false);
            tableMenus.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        labelRemoveMenu.setText("* klik menu pada tabel untuk menghapus menu");

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRemoveMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(containerTableMenuList, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAdminLayout.createSequentialGroup()
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMenuName)
                            .addComponent(labelMenuPrice))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputMenuName, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(inputMenuPrice)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMenuName)
                    .addComponent(inputMenuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMenuPrice)
                    .addComponent(inputMenuPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerTableMenuList, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRemoveMenu)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputMenuPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMenuPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMenuPriceActionPerformed

    private void btnAddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewManageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewManageMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMenu;
    private javax.swing.JScrollPane containerTableMenuList;
    private javax.swing.JTextField inputMenuName;
    private javax.swing.JTextField inputMenuPrice;
    private javax.swing.JLabel labelMenuName;
    private javax.swing.JLabel labelMenuPrice;
    private javax.swing.JLabel labelRemoveMenu;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JTable tableMenus;
    // End of variables declaration//GEN-END:variables

    // Show popup mesage
    public void showPopup(String message, String title, int type){
        JOptionPane.showMessageDialog(null, message, title, type);
    }
    
    
    // User Inputs
    public String getMenuName() {
        return inputMenuName.getText();
    }
    
    public int getMenuPrice() {
        try {
            return Integer.parseInt(inputMenuPrice.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public void updateMenuInput(String name, int price) {
        inputMenuName.setText(name);
        inputMenuPrice.setText(String.valueOf(price));
    }
    
    public void resetMenuInput() {
        inputMenuName.setText("");
        inputMenuPrice.setText("");
    }
   
    // Order items table
    public int getSelectedMenu() {
        return tableMenus.getSelectedRow();
    }
    
    public void updateTableMenus(Object[][] rows) {
        tableMenusModel.getDataVector().clear();
        for(Object[] row : rows) tableMenusModel.addRow(row);
        tableMenusModel.fireTableDataChanged();
    }
     
    // Returning possible action sources
    public JButton getBtnAddMenu() {
        return btnAddMenu;
    }
    
    public JTable getMenusTable() {
        return tableMenus;
    }
    
    // Binding ActionListener & MouseListener
    public void addActionListener(ActionListener e) {
        btnAddMenu.addActionListener(e);
    }

    public void addMouseAdapter(MouseListener e) {
        tableMenus.addMouseListener(e);
    }
}
