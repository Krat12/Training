/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsr.igorromanov.WindowInput;

import java.awt.Color;
import wsr.igorromanov.utils.ConnectionMySQL;
import java.sql.Connection;
import wsr.igorromanov.registration.RegistrationForm;

/**
 *
 * @author Admin
 */
public class WindowInput extends javax.swing.JFrame {

    public static WindowInput window; 
    
    public WindowInput() {
        super("Авторизация");
        initComponents();
        window = this;
        Settings();
       
    }
    private void Settings(){
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private  void windowRegisrtration(){
        ConnectionMySQL.getConnection();
        RegistrationForm registr = new RegistrationForm();
        registr.setVisible(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_password = new javax.swing.JLabel();
        lbl_login = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        lb_input = new javax.swing.JLabel();
        lb_registration = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_password.setText("Пороль:");

        lbl_login.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_login.setText("Логин:");

        txt_login.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo-03.jpg"))); // NOI18N

        lb_input.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_input.setText("Войти\n");
        lb_input.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_input.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lb_inputMouseMoved(evt);
            }
        });
        lb_input.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_inputMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_inputMouseExited(evt);
            }
        });

        lb_registration.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_registration.setText("Регистрация");
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
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lbl_login)
                .addGap(5, 5, 5)
                .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lbl_password)
                .addGap(4, 4, 4)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lb_input)
                .addGap(24, 24, 24)
                .addComponent(lb_registration))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_login)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_input)
                    .addComponent(lb_registration)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb_inputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_inputMouseClicked
        SelectQuery query = new SelectQuery(new FieldAuthorization(txt_login.getText(),String.valueOf(txt_password.getPassword())));
        query.selectDB();
    }//GEN-LAST:event_lb_inputMouseClicked

    private void lb_registrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrationMouseClicked
        windowRegisrtration();
    }//GEN-LAST:event_lb_registrationMouseClicked

    private void lb_registrationMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrationMouseMoved
        lb_registration.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lb_registrationMouseMoved

    private void lb_registrationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrationMouseExited
       lb_registration.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_registrationMouseExited

    private void lb_inputMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_inputMouseMoved
        lb_input.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lb_inputMouseMoved

    private void lb_inputMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_inputMouseExited
        lb_input.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_inputMouseExited

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
            java.util.logging.Logger.getLogger(WindowInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowInput().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_input;
    private javax.swing.JLabel lb_registration;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JTextField txt_login;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
