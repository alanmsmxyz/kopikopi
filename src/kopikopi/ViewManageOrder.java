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
public class ViewManageOrder extends javax.swing.JFrame {
    DefaultTableCellRenderer alignCenter = new DefaultTableCellRenderer();
    DefaultTableCellRenderer alignRight = new DefaultTableCellRenderer();
    DefaultTableCellRenderer alignLeft = new DefaultTableCellRenderer();

    DefaultTableModel tableItemsModel;

    /**
     * Creates new form serverView
     */
    public ViewManageOrder() {
        initComponents();
        
        // Initiate custom renderer for table cell alignments
        alignCenter.setHorizontalAlignment(JLabel.CENTER);
        alignRight.setHorizontalAlignment(JLabel.RIGHT);
        alignLeft.setHorizontalAlignment(JLabel.LEFT);

        // tableItems's cells text alignment
        tableItems.getTableHeader().setDefaultRenderer(alignCenter);
        tableItems.getColumnModel().getColumn(1).setCellRenderer(alignLeft);
        tableItems.getColumnModel().getColumn(1).setCellRenderer(alignCenter);
        tableItems.getColumnModel().getColumn(2).setCellRenderer(alignRight);
        tableItems.getColumnModel().getColumn(3).setCellRenderer(alignRight);

        // cast tableItems table model as DefaultTableModel
        tableItemsModel = (DefaultTableModel) tableItems.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerOrderSelector = new javax.swing.JPanel();
        labelOrderSelector = new javax.swing.JLabel();
        containerListOrders = new javax.swing.JScrollPane();
        listOrders = new javax.swing.JList<>();
        containerOrderDetails = new javax.swing.JPanel();
        labelOrderDetails = new javax.swing.JLabel();
        containerTableOrderItems = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        btnFinishOrder = new javax.swing.JButton();
        btnUpdateOrders = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelOrderSelector.setText("Pilih Order");

        listOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        containerListOrders.setViewportView(listOrders);

        labelOrderDetails.setText("Detail Order");

        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kopi", "Jumlah", "Harga", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItems.getTableHeader().setReorderingAllowed(false);
        containerTableOrderItems.setViewportView(tableItems);
        if (tableItems.getColumnModel().getColumnCount() > 0) {
            tableItems.getColumnModel().getColumn(0).setResizable(false);
            tableItems.getColumnModel().getColumn(0).setPreferredWidth(150);
            tableItems.getColumnModel().getColumn(1).setResizable(false);
            tableItems.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableItems.getColumnModel().getColumn(2).setResizable(false);
            tableItems.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableItems.getColumnModel().getColumn(3).setResizable(false);
            tableItems.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btnFinishOrder.setText("Selesaikan Order");
        btnFinishOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerOrderDetailsLayout = new javax.swing.GroupLayout(containerOrderDetails);
        containerOrderDetails.setLayout(containerOrderDetailsLayout);
        containerOrderDetailsLayout.setHorizontalGroup(
            containerOrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFinishOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelOrderDetails)
            .addComponent(containerTableOrderItems, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        containerOrderDetailsLayout.setVerticalGroup(
            containerOrderDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerOrderDetailsLayout.createSequentialGroup()
                .addComponent(labelOrderDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerTableOrderItems, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnFinishOrder))
        );

        btnUpdateOrders.setText("Perbarui Order");
        btnUpdateOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrdersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerOrderSelectorLayout = new javax.swing.GroupLayout(containerOrderSelector);
        containerOrderSelector.setLayout(containerOrderSelectorLayout);
        containerOrderSelectorLayout.setHorizontalGroup(
            containerOrderSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerOrderSelectorLayout.createSequentialGroup()
                .addGroup(containerOrderSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelOrderSelector)
                    .addComponent(btnUpdateOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(containerListOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        containerOrderSelectorLayout.setVerticalGroup(
            containerOrderSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerOrderSelectorLayout.createSequentialGroup()
                .addComponent(labelOrderSelector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(containerListOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateOrders)
                .addGap(142, 142, 142))
            .addGroup(containerOrderSelectorLayout.createSequentialGroup()
                .addComponent(containerOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(containerOrderSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(containerOrderSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinishOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinishOrderActionPerformed

    private void btnUpdateOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOrdersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateOrdersActionPerformed

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
            java.util.logging.Logger.getLogger(ViewManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinishOrder;
    private javax.swing.JButton btnUpdateOrders;
    private javax.swing.JScrollPane containerListOrders;
    private javax.swing.JPanel containerOrderDetails;
    private javax.swing.JPanel containerOrderSelector;
    private javax.swing.JScrollPane containerTableOrderItems;
    private javax.swing.JLabel labelOrderDetails;
    private javax.swing.JLabel labelOrderSelector;
    private javax.swing.JList<String> listOrders;
    private javax.swing.JTable tableItems;
    // End of variables declaration//GEN-END:variables

    // Show popup mesage
    public void showPopup(String message, String title, int type){
        JOptionPane.showMessageDialog(null, message, title, type);
    }
    
    // update orders list
    public void updateListOrders(String[] s) {
        listOrders.setListData(s);
    }
    
    // Order table details, controling content of the table
    public void resetItemsTable() {
        tableItemsModel.getDataVector().clear();
        tableItemsModel.fireTableDataChanged();
    }

    public void updateItemsTable(Object[][] rows) {
        tableItemsModel.getDataVector().clear();
        for(Object[] row : rows) tableItemsModel.addRow(row);
        tableItemsModel.fireTableDataChanged();
    }
    
    // Methods to retreive data from view
    public int getSelectedOrder() {
        return listOrders.getSelectedIndex();
    }

    // Method to identify action source in handler classes
    public JButton getBtnFinishOrder() {
        return btnFinishOrder;
    }
    
    public JButton getBtnUpdateOrders() {
        return btnUpdateOrders;
    }
    
    
    public JList getListOrders() {
        return listOrders;
    }
    
    // Binding ActionListener & MouseListener
    public void addActionListener(ActionListener e) {
        btnFinishOrder.addActionListener(e);
        btnUpdateOrders.addActionListener(e);

    }
    
    public void addMouseAdapter(MouseAdapter e) {
        listOrders.addMouseListener(e);
    }
}
