/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsr.igorromanov.storekeeper.insertstock;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import wsr.igorromanov.utils.CheckValidate;
import wsr.igorromanov.utils.ConnectionMySQL;
import wsr.igorromanov.utils.FileUtils;
import wsr.igorromanov.utils.FilterFile;

/**
 *
 * @author Студент
 */
public class NewFabric extends javax.swing.JFrame {

    private static final String FILE_EXTENSION_JPG = "jpg";
    private static final String FILE_EXTENSION_PNG = "png";
    private static final String DESCRIPTION = "Использовать формат";
    private final FilterFile filterJPG = new FilterFile(FILE_EXTENSION_JPG, DESCRIPTION);
    private final FilterFile filterPNG = new FilterFile(FILE_EXTENSION_PNG, DESCRIPTION);
    private final Parametr parametr = new Parametr();
    private String path;
  
    public NewFabric() {
        super("Новая ткань");
        initComponents();
        settings();
    }
    
    private void settings(){
        setLocation(700, 200);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
    private void checkInputDate(){
       
        String name = txt_nameFabric.getText();
        String color = txt_colorFabric.getText();
        String consist = txt_consistFabric.getText();
        String length = txt_lengthFabric.getText();
        String width = txt_widthFabric.getText();
        String vendor = txt_vendorCodeFabric.getText();
        String cost = txt_costFabric.getText();
       
        if (CheckValidate.isString(name) && CheckValidate.isString(color) && CheckValidate.isString(consist)) {
           
            if (CheckValidate.isFloat(length) && CheckValidate.isFloat(width) && CheckValidate.isString(vendor)) {
                
                if ( CheckValidate.isFloat(cost) && CheckValidate.isString(path)) {
                    
                    parametr.setName(name);
                    parametr.setColor(color);
                    parametr.setConsist(consist);
                    parametr.setPath(path);
                    parametr.setWidth(Float.parseFloat(width));
                    parametr.setLength(Float.parseFloat(length));
                    parametr.setVendor(vendor);
                    parametr.setCost(Integer.parseInt(cost));
                    
                    insertNewFabric();
                     
                }else{
                    JOptionPane.showMessageDialog(null, "<html><h3>Неверный формат(Проверьте поля)");
                }
            }else{
                JOptionPane.showMessageDialog(null, "<html><h3>Неверный формат(Проверьте поля)");
            }
        }else{
            JOptionPane.showMessageDialog(null, "<html><h3>Неверный формат(Проверьте поля)");
        } 

    }
 
    private void insertNewFabric() {
        
        Connection con = ConnectionMySQL.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO fabric (name,colour,consist,length,width,vendor_code_fabric,cost,image) values (?,?,?,?,?,?,?,?)";
        InputStream img = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, parametr.getName());
            ps.setString(2, parametr.getColor());
            ps.setString(3, parametr.getConsist());
            ps.setFloat(4, parametr.getLength());
            ps.setFloat(5, parametr.getWidth());
            ps.setString(6, parametr.getVendor());
            ps.setFloat(7, parametr.getCost());
            
            try {

                img = new FileInputStream(new File(parametr.getPath()));
                ps.setBlob(8, img);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ткань добавлена");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewFabric.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                try {
                    if (img != null) {
                        img.close();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(NewFabric.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(NewFabric.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NewFabric.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public  void importImage(){
        
       FileUtils.addFileFilter(fileChooser, filterJPG);
       FileUtils.addFileFilter(fileChooser, filterPNG);

        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            
            File selectedFile = fileChooser.getSelectedFile();
            
            path = selectedFile.getAbsolutePath();
            
            ImageIcon image = new ImageIcon(path);
            lbl_imageFabric.setIcon(new ImageIcon(image.getImage().getScaledInstance(175, 277, Image.SCALE_SMOOTH)));
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        lbl_newFabric = new javax.swing.JLabel();
        txt_nameFabric = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_colorFabric = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_consistFabric = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_lengthFabric = new javax.swing.JTextField();
        txt_widthFabric = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_vendorCodeFabric = new javax.swing.JTextField();
        lbl_imageFabric = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_costFabric = new javax.swing.JTextField();
        btn_selectImage = new javax.swing.JButton();
        btn_insertFabric = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_newFabric.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_newFabric.setText("Регистрация новой тани");

        txt_nameFabric.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Название:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Цвет:");

        txt_colorFabric.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Состав:");

        txt_consistFabric.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Длина:");

        txt_lengthFabric.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txt_widthFabric.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Ширина:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Артикул:");

        txt_vendorCodeFabric.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lbl_imageFabric.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_imageFabric.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_imageFabric.setText("Изоброжение");
        lbl_imageFabric.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Цена:");

        txt_costFabric.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btn_selectImage.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_selectImage.setText("Выбрать изоброжение");
        btn_selectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectImageActionPerformed(evt);
            }
        });

        btn_insertFabric.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_insertFabric.setText("Добавить");
        btn_insertFabric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertFabricActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(lbl_newFabric))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(txt_nameFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(txt_colorFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(txt_consistFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(txt_lengthFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addComponent(txt_widthFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(txt_vendorCodeFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_selectImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(txt_costFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_imageFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_insertFabric, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbl_newFabric)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lbl_imageFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btn_insertFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(txt_nameFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(txt_colorFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(txt_consistFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(txt_lengthFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5))
                            .addComponent(txt_widthFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(txt_vendorCodeFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8))
                            .addComponent(txt_costFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_selectImage)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_selectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectImageActionPerformed
        importImage();
    }//GEN-LAST:event_btn_selectImageActionPerformed

    private void btn_insertFabricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertFabricActionPerformed
       checkInputDate();
    }//GEN-LAST:event_btn_insertFabricActionPerformed

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
            java.util.logging.Logger.getLogger(NewFabric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewFabric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewFabric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewFabric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new NewFabric().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_insertFabric;
    private javax.swing.JButton btn_selectImage;
    public javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_imageFabric;
    private javax.swing.JLabel lbl_newFabric;
    private javax.swing.JTextField txt_colorFabric;
    private javax.swing.JTextField txt_consistFabric;
    private javax.swing.JTextField txt_costFabric;
    private javax.swing.JTextField txt_lengthFabric;
    private javax.swing.JTextField txt_nameFabric;
    private javax.swing.JTextField txt_vendorCodeFabric;
    private javax.swing.JTextField txt_widthFabric;
    // End of variables declaration//GEN-END:variables
}
