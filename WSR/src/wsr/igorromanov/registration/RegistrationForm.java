/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsr.igorromanov.registration;

import java.awt.Color;
import wsr.igorromanov.WindowInput.WindowInput;

/**
 *
 * @author Admin
 */
public class RegistrationForm extends javax.swing.JFrame {
   
    public static RegistrationForm registr;
    
    public RegistrationForm() {
        super("Регистрация");
        initComponents();
        registr = this;
        settings();
        
    }
    
    
    
    private void settings() {
        setLocationRelativeTo(null);
        setResizable(false);
    }
   




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_name = new javax.swing.JTextField();
        txt_passwordR = new javax.swing.JPasswordField();
        lbl_login = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_loginR = new javax.swing.JTextField();
        cb_rol = new javax.swing.JComboBox<>();
        btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_registration = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txt_passwordR.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lbl_login.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_login.setText("Логин:");

        lbl_password.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_password.setText("Пароль:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Имя:");

        txt_loginR.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cb_rol.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cb_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Роль", "Кладовщик", "Менеджер", "Руководитель", "Заказчик" }));
        cb_rol.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_back.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_back.setText("Назад");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo-04.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Регистрация\n");

        lb_registration.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_registration.setText("Зарегистрироваться");
        lb_registration.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_registration.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lb_registrationMouseMoved(evt);
            }
        });
        lb_registration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_registrationMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_registrationMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(lbl_password)
                            .addComponent(lbl_login)
                            .addComponent(txt_passwordR)
                            .addComponent(txt_loginR)
                            .addComponent(lb_registration))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_back)
                            .addComponent(jLabel3))
                        .addGap(61, 61, 61)
                        .addComponent(cb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_login)
                        .addGap(5, 5, 5)
                        .addComponent(txt_loginR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_password)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_passwordR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lb_registration))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
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

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        WindowInput win = new WindowInput();
        win.setVisible(true);
        dispose();   
    }//GEN-LAST:event_btn_backActionPerformed

    private void lb_registrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrationMouseClicked
        InsertQuery query = new InsertQuery(new FieldRegistration(txt_name.getText(),
        txt_loginR.getText(),
        String.valueOf(txt_passwordR.getPassword()),
        cb_rol.getSelectedItem().toString()));
        query.insertDB();
    }//GEN-LAST:event_lb_registrationMouseClicked

    private void lb_registrationMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrationMouseMoved
        lb_registration.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lb_registrationMouseMoved

    private void lb_registrationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrationMouseExited
        lb_registration.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_registrationMouseExited

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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    protected javax.swing.JComboBox<String> cb_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_registration;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JTextField txt_loginR;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_passwordR;
    // End of variables declaration//GEN-END:variables
}
