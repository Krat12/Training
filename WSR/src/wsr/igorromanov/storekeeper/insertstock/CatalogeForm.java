/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsr.igorromanov.storekeeper.insertstock;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import wsr.igorromanov.storekeeper.FieldStorage;
import wsr.igorromanov.storekeeper.Storage;
import wsr.igorromanov.storekeeper.StoreKeeperForm;

/**
 *
 * @author Admin
 */
public class CatalogeForm extends javax.swing.JFrame {

    private  String amount;
   
    public CatalogeForm() {
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
            amount = JOptionPane.showInputDialog(CatalogeForm.this,
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
            JOptionPane.showMessageDialog(CatalogeForm.this,
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
        btn_newFabric = new javax.swing.JLabel();
        btn_newFittings = new javax.swing.JLabel();

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

        btn_newFabric.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_newFabric.setText("Добавить новую ткань");
        btn_newFabric.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_newFabric.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_newFabricMouseMoved(evt);
            }
        });
        btn_newFabric.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_newFabricMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_newFabricMouseExited(evt);
            }
        });

        btn_newFittings.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_newFittings.setText("Добавить новую фурнитуру");
        btn_newFittings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_newFittings.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_newFittingsMouseMoved(evt);
            }
        });
        btn_newFittings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_newFittingsMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_newFittingsMouseExited(evt);
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
                    .addComponent(btn_newFabric, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_listFittings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_listFabric)
                    .addComponent(btn_backmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_newFittings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
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
                .addGap(12, 12, 12)
                .addComponent(btn_newFabric)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_newFittings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_backmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
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

    private void btn_backmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backmenuActionPerformed
        this.dispose();
        StoreKeeperForm store = new StoreKeeperForm();
        store.setVisible(true);
    }//GEN-LAST:event_btn_backmenuActionPerformed

    private void cb_listFittingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_listFittingsActionPerformed
        cmb_Cataloge.removeAllItems();
        Cataloge();
    }//GEN-LAST:event_cb_listFittingsActionPerformed

    private void cb_listFabricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_listFabricActionPerformed
        cmb_Cataloge.removeAllItems();
        Cataloge();
    }//GEN-LAST:event_cb_listFabricActionPerformed

    private void cmb_CatalogeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_CatalogeActionPerformed
        if (cmb_Cataloge.getSelectedItem()!= null){
            Calculation();
        }
    }//GEN-LAST:event_cmb_CatalogeActionPerformed

    private void btn_newFabricMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newFabricMouseClicked
        NewFabric fabric = new NewFabric();
        fabric.setVisible(true);
    }//GEN-LAST:event_btn_newFabricMouseClicked

    private void btn_newFittingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newFittingsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_newFittingsMouseClicked

    private void btn_newFabricMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newFabricMouseMoved
        btn_newFabric.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btn_newFabricMouseMoved

    private void btn_newFabricMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newFabricMouseExited
        btn_newFabric.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_newFabricMouseExited

    private void btn_newFittingsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newFittingsMouseMoved
        btn_newFittings.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btn_newFittingsMouseMoved

    private void btn_newFittingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newFittingsMouseExited
         btn_newFittings.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_newFittingsMouseExited

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
            java.util.logging.Logger.getLogger(CatalogeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatalogeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatalogeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatalogeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_backmenu;
    private javax.swing.JLabel btn_newFabric;
    private javax.swing.JLabel btn_newFittings;
    private javax.swing.JCheckBox cb_listFabric;
    private javax.swing.JCheckBox cb_listFittings;
    private javax.swing.JComboBox<String> cmb_Cataloge;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
