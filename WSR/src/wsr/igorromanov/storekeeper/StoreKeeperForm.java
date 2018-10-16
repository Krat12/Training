/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsr.igorromanov.storekeeper;

import wsr.igorromanov.storekeeper.deletestock.RemoveMaterialFrom;
import wsr.igorromanov.storekeeper.insertstock.CatalogeForm;
import wsr.igorromanov.storekeeper.inventory.InventoryForm;
import static wsr.igorromanov.storekeeper.inventory.InventoryForm.PanelID;
import wsr.igorromanov.storekeeper.listFabric.ListFabric;

/**
 *
 * @author Admin
 */
public class StoreKeeperForm extends javax.swing.JFrame {


    public StoreKeeperForm() {
        super("Кладовщик");
        initComponents();
        settings();
    }


    private void settings(){
       //setResizable(false);
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_inventar = new javax.swing.JButton();
        btn_fabric = new javax.swing.JButton();
        btn_fittings = new javax.swing.JButton();
        btn_insertStock = new javax.swing.JButton();
        btn_deleteStock = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_inventar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_inventar.setText("Инвентаризация");
        btn_inventar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inventarActionPerformed(evt);
            }
        });

        btn_fabric.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_fabric.setText("Список тканей");
        btn_fabric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fabricActionPerformed(evt);
            }
        });

        btn_fittings.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_fittings.setText("Список форнитуры");
        btn_fittings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fittingsActionPerformed(evt);
            }
        });

        btn_insertStock.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_insertStock.setText("Поступление материалов");
        btn_insertStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertStockActionPerformed(evt);
            }
        });

        btn_deleteStock.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_deleteStock.setText("Снятие материалов");
        btn_deleteStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteStockActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Меню");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_inventar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_fabric, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_fittings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_insertStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deleteStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(btn_inventar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_fabric, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_fittings, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_insertStock, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_deleteStock, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inventarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inventarActionPerformed
        this.dispose();
        PanelID = 0;
        InventoryForm inventory = new InventoryForm();
        inventory.setVisible(true);
    }//GEN-LAST:event_btn_inventarActionPerformed

    private void btn_fabricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fabricActionPerformed
        this.dispose();
        ListFabric form = new ListFabric();
        form.setVisible(true);
    }//GEN-LAST:event_btn_fabricActionPerformed

    private void btn_fittingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fittingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_fittingsActionPerformed

    private void btn_insertStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertStockActionPerformed
        this.dispose();
        CatalogeForm stock = new CatalogeForm();
        stock.setVisible(true);
    }//GEN-LAST:event_btn_insertStockActionPerformed

    private void btn_deleteStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteStockActionPerformed
        this.dispose();
        RemoveMaterialFrom removeMaterialFrom = new RemoveMaterialFrom();
        removeMaterialFrom.setVisible(true);
    }//GEN-LAST:event_btn_deleteStockActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
   
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StoreKeeperForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreKeeperForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreKeeperForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreKeeperForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//</editor-fold>

/* Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new StoreKeeperForm().setVisible(true);
    }
});
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deleteStock;
    private javax.swing.JButton btn_fabric;
    private javax.swing.JButton btn_fittings;
    private javax.swing.JButton btn_insertStock;
    private javax.swing.JButton btn_inventar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
