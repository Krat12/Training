/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsr.igorromanov.storekeeper.insertstock;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import wsr.igorromanov.storekeeper.FieldStorage;
import wsr.igorromanov.storekeeper.Storage;
import wsr.igorromanov.storekeeper.StoreKeeperForm;

/**
 *
 * @author Admin
 */
public class InsertStockForm extends javax.swing.JFrame {

    private  String amount;
   
    public InsertStockForm() {
        super("Поступление материалов");
        initComponents();
        settings();
        Cataloge();
      
    }

    private void settings(){
       //setResizable(false);
        setLocationRelativeTo(null);
    }
    
    
    // Добовляем данные в ComboBox из ArrayList
    private void Cataloge() {

        cmb_Cataloge.addItem("Каталог");
        Storage list = new Storage();
        ArrayList<FieldStorage> listFabric = list.getFabricList();
        ArrayList<FieldStorage> listFittings = list.getFittingsList();
        if (cb_listFabric.isSelected()) {

            for (int i = 0; i < listFabric.size(); i++) {
                String data = listFabric.get(i).getNameFabric();
                cmb_Cataloge.addItem(data);
            }
        }
        if (cb_listFittings.isSelected()) {
            for (int i = 0; i < listFittings.size(); i++) {
                String data = listFittings.get(i).getNameFittings();
                cmb_Cataloge.addItem(data);
            }
        }
    }

    // Локальный main метод (происходит все расчеты и добовляются данные в бд)
    private void Calculation() {
        if (!cmb_Cataloge.getSelectedItem().equals("Каталог")) {
            amount = JOptionPane.showInputDialog(InsertStockForm.this,
                    "<html><h2>Введите количество рулонов/партий");

            if (amount != null) {
                searchFabric();
                searchFittings();
            }
        }

    }
    // Поиск нужного рулона и его ID
    private void searchFabric (){
        Storage storage = new Storage();
        ArrayList<FieldStorage> listFabric = storage.getFabricList();
        for (FieldStorage field : listFabric) {
            if (field.getNameFabric().equals(cmb_Cataloge.getSelectedItem())) {
                int roll = field.getRoll();
                int ID = field.getFabricID();
                outputDataFabric(roll, ID);
            }
        }
    
    }
    //Перерасчет количество рулонов на складе
    private void outputDataFabric(int roll, int ID) {
        if (isDigit(amount)) {
            int recalculation = Integer.parseInt(amount) + roll;
            QueryStock.updateRoll(recalculation,ID);
        } 
    }
    
    // Поиск нужной партии и его ID
        private void searchFittings(){
        Storage storage = new Storage();
        ArrayList<FieldStorage> listFittings = storage.getFittingsList();
        for (FieldStorage field : listFittings) {
            if (field.getNameFittings().equals(cmb_Cataloge.getSelectedItem())) {
                int party = field.getParty();
                int ID = field.getFittingsID();
                outputDataFittings(party, ID);
            }
        }
    
    }
  // Перерасчет количетсво партий на складе
    private void outputDataFittings(int party, int ID) {
        if (isDigit(amount)) {
            int recalculation = Integer.parseInt(amount) + party;
           QueryStock.updateParty(recalculation,ID);
        } 
    }

    // Проверка правильности ввода данных пользователем 
    private boolean isDigit(String data) throws NumberFormatException {
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(InsertStockForm.this,
                                       "<html><h3>Неверный формат");
            return false;
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        cmb_Cataloge = new javax.swing.JComboBox<>();
        cb_listFabric = new javax.swing.JCheckBox();
        cb_listFittings = new javax.swing.JCheckBox();
        btn_backmenu = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cmb_Cataloge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmb_Cataloge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_CatalogeActionPerformed(evt);
            }
        });

        cb_listFabric.setBackground(new java.awt.Color(255, 255, 255));
        cb_listFabric.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_listFabric.setSelected(true);
        cb_listFabric.setText("Выбрать спиок тканей");
        cb_listFabric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_listFabricActionPerformed(evt);
            }
        });

        cb_listFittings.setBackground(new java.awt.Color(255, 255, 255));
        cb_listFittings.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_listFittings.setSelected(true);
        cb_listFittings.setText("Выбрать список фурнитур");
        cb_listFittings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_listFittingsActionPerformed(evt);
            }
        });

        btn_backmenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_backmenu.setText("Вернуться в главное меню");
        btn_backmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(cmb_Cataloge, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_listFittings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_listFabric)
                    .addComponent(btn_backmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Cataloge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_listFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_listFittings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_backmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
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

    private void cb_listFabricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_listFabricActionPerformed
        cmb_Cataloge.removeAllItems();
        Cataloge(); 
    }//GEN-LAST:event_cb_listFabricActionPerformed

    private void cmb_CatalogeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_CatalogeActionPerformed
        if (cmb_Cataloge.getSelectedItem()!= null){
            Calculation();
        }
    }//GEN-LAST:event_cmb_CatalogeActionPerformed

    private void btn_backmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backmenuActionPerformed
       this.dispose();
        StoreKeeperForm store = new StoreKeeperForm();
        store.setVisible(true);
    }//GEN-LAST:event_btn_backmenuActionPerformed

    private void cb_listFittingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_listFittingsActionPerformed
        cmb_Cataloge.removeAllItems();
        Cataloge(); 
    }//GEN-LAST:event_cb_listFittingsActionPerformed

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
            java.util.logging.Logger.getLogger(InsertStockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertStockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertStockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertStockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertStockForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_backmenu;
    private javax.swing.JCheckBox cb_listFabric;
    private javax.swing.JCheckBox cb_listFittings;
    private javax.swing.JComboBox<String> cmb_Cataloge;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
