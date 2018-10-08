/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.worldskils.bmicalculate;

import java.awt.Color;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CalculateForm extends javax.swing.JFrame {
    private float BMI;
  
    public CalculateForm() {
        super("Marahon Skils 2015 - BMI calculator");
        initComponents();
         settings();
         sliderTest();
    }

    public void settings() {
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(880, 800);

    }

    public void calculate() throws NumberFormatException {
        try {
            float heft = Float.parseFloat(txt_heft.getText());
            float grow = Float.parseFloat(txt_grow.getText()) / 100;

            BMI = heft / (grow * grow);
            String formattedDouble = String.format("%.2f", BMI);
            lbl_kfc.setText(formattedDouble);
            
            smallHeft();
            normalHeft();
            overWeight();
            adiposity();

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "NumberFormatException");
        }
    }

    private void smallHeft() {
        
        if (BMI < 18.5) {
            ImageIcon image = new ImageIcon("src\\image\\Слой 5.png");
            lbl_imageIBM.setIcon(new ImageIcon(image.getImage().getScaledInstance(65,
                    200, Image.SCALE_SMOOTH)));
            txt_normal.setText("Недостаточный вес");
        }
    }

    private void normalHeft() {
        
        if ((BMI <= 24.9) && (BMI > 18.5)) {
            ImageIcon image = new ImageIcon("src\\image\\Слой 4.png");
            lbl_imageIBM.setIcon(new ImageIcon(image.getImage().getScaledInstance(65,
                    200, Image.SCALE_SMOOTH)));
            txt_normal.setText("Здоровый");
        }
    }
    
    private void overWeight(){
        
    if ( (BMI >= 25) && (BMI <= 29.9)) {
                ImageIcon image = new ImageIcon("src\\image\\Слой 6.png");
                lbl_imageIBM.setIcon(new ImageIcon(image.getImage().getScaledInstance(103,
                200, Image.SCALE_SMOOTH)));
                txt_normal.setText("Излишний вес");
        }
    }
    
    private void adiposity() {
        if (BMI > 29.9) {
            ImageIcon image = new ImageIcon("src\\image\\Слой 7.png");
            lbl_imageIBM.setIcon(new ImageIcon(image.getImage().getScaledInstance(102,
                    200, Image.SCALE_SMOOTH)));
            txt_normal.setText("Излишний вес");
        }
    }
    
    private void sliderTest(){
        Dictionary <Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
        labels.put(new Integer(6), new JLabel("<html><font color=orange size=4> Недостаточный"));
        labels.put(new Integer(18), new JLabel("<html><font color=green size=4>Здоровый"));
        labels.put(new Integer(27), new JLabel("<html><font color=orange size=4>Излишний"));
        labels.put(new Integer(36), new JLabel("<html><font color=red size=4>Ожирение"));
        BoundedRangeModel model = new DefaultBoundedRangeModel(0,0, 0, 37);
        jSlider1.setLabelTable(labels);
        jSlider1.setModel(model);
        jSlider1.setPaintLabels(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(0);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_grow = new javax.swing.JTextField();
        txt_heft = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txt_normal = new javax.swing.JLabel();
        lbl_imageIBM = new javax.swing.JLabel();
        lbl_kfc = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(880, 670));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("BMI калькулятор");

        jPanel2.setBackground(new java.awt.Color(80, 80, 80));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Назад");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(false);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MARATHON SKILS 2016");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Информация о том что такое BMI и");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("как работает калькулятор");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(null);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Мужской");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 150, 167, 30);

        jLabel6.setBackground(new java.awt.Color(180, 180, 180));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Слой 1.png"))); // NOI18N
        jLabel6.setToolTipText("");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6);
        jLabel6.setBounds(0, 0, 170, 180);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Женский");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(0, 150, 167, 30);

        jLabel10.setBackground(new java.awt.Color(180, 180, 180));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Слой 2.png"))); // NOI18N
        jLabel10.setToolTipText("");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel10);
        jLabel10.setBounds(0, 0, 170, 180);

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Расчитать");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Отмена");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setOpaque(false);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Рост:");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Вес:");

        txt_grow.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_grow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_grow.setOpaque(false);
        txt_grow.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txt_grow.setSelectionColor(new java.awt.Color(255, 255, 255));

        txt_heft.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_heft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_heft.setOpaque(false);
        txt_heft.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        txt_heft.setSelectionColor(new java.awt.Color(102, 102, 102));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("кг");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("см");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        txt_normal.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txt_normal.setForeground(new java.awt.Color(102, 102, 102));
        txt_normal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_normal.setText("Здоровый");
        jPanel5.add(txt_normal);
        txt_normal.setBounds(10, 290, 240, 24);

        lbl_imageIBM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_imageIBM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Слой 4.png"))); // NOI18N
        lbl_imageIBM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(lbl_imageIBM);
        lbl_imageIBM.setBounds(10, 10, 240, 330);

        lbl_kfc.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jSlider1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_grow)
                                    .addComponent(txt_heft, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_kfc, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(320, 320, 320))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_heft, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(47, 47, 47)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txt_grow, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addGap(51, 51, 51)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_kfc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       jPanel3.setBackground(Color.LIGHT_GRAY);
       jLabel6.setBorder(null);
       jPanel4.setBackground(Color.WHITE);
       jLabel10.setBorder(BorderFactory.createLineBorder(Color.black, 1));
      
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
       
       jPanel4.setBackground(Color.LIGHT_GRAY);
       jLabel10.setBorder(null);
       jPanel3.setBackground(Color.WHITE);
       jLabel6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
       
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if ((jPanel4.getBackground().equals(Color.LIGHT_GRAY)) || jPanel3.getBackground().equals(Color.LIGHT_GRAY)) {
            lbl_kfc.setText("");
            calculate();
            jSlider1.setValue(Math.round(BMI));
        } else {
            JOptionPane.showMessageDialog(this, "Выбери пол");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CalculateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculateForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lbl_imageIBM;
    private javax.swing.JLabel lbl_kfc;
    private javax.swing.JTextField txt_grow;
    private javax.swing.JTextField txt_heft;
    private javax.swing.JLabel txt_normal;
    // End of variables declaration//GEN-END:variables
}
