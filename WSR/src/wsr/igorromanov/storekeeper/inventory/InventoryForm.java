/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsr.igorromanov.storekeeper.inventory;

import java.awt.Color;
import java.awt.Container;
import wsr.igorromanov.storekeeper.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/**
 *
 * @author Admin
 */
public class InventoryForm extends javax.swing.JFrame {

  private static final String FILE_EXTENSION = ".xml";
  private static final String[] COLUMN_NAME_FABRIC = {"Название","Цвет","Состав","Длина(м.)","Рулон(ов)","Изоброжение"};
  private static final String[] COLUMN_NAME_FITTINGS = {"Название","Тип","Вес(кг.)","Количество(шт.)","Партий(шт.)","Изоброжение"};
  public static int PanelID;
  private static final int DEFAULT_PANEL = 0;
  private static final int FABRIC_PANEL = 1;
  private static final int FITTINGS_PANEL = 2;
 
    public InventoryForm() {
        super("Инветоризация");
        initComponents();
        settings();
       // storageFabric();
        storageFittings();
        storageFittings();
    }

    private void settings(){
       //setResizable(false);
        setLocationRelativeTo(null);
          Container a = this.getContentPane();
          a.setBackground(Color.white);
     
    }
    
    private void storageFabric() {
            Storage storage = new Storage();
            storage.createTable(tb_StorageFabric, COLUMN_NAME_FABRIC, storage.getFabricList());
    }

    private void storageFittings() {
          Storage storage = new Storage();
          storage.createTable(tb_StorageFittings, COLUMN_NAME_FITTINGS, storage.getFittingsList());
    }
    
    private void menuSave(){
      Storage storage = new Storage();
        if (PanelID != DEFAULT_PANEL) {
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {// если нажата клавиша OK или YES
                File selectedFile = fileChooser.getSelectedFile();
                String URL = selectedFile.getPath() + FILE_EXTENSION;
            if(PanelID == FABRIC_PANEL){
                FileXML.fabricModel(storage.getFabricList(),URL);
            }
             if(PanelID == FITTINGS_PANEL){
                 FileXML.fittingsModel(storage.getFittingsList(),URL);

            }
                
            }
        }else {JOptionPane.showMessageDialog(null,"<html><h3>Выберите таблицу");}
    }
    
    private void mainMenu(){
       this.dispose();
       StoreKeeperForm keeper = new StoreKeeperForm();
       keeper.setVisible(true);
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        lb_mainMenu = new javax.swing.JLabel();
        lb_exportXML = new javax.swing.JLabel();
        lb_fabric = new javax.swing.JLabel();
        lb_firrings = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        defolt = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fabric = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_StorageFabric = new javax.swing.JTable();
        fittings = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_StorageFittings = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        sidePanel.setBackground(new java.awt.Color(255, 255, 255));
        sidePanel.setLayout(new java.awt.GridBagLayout());

        lb_mainMenu.setBackground(new java.awt.Color(51, 51, 255));
        lb_mainMenu.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lb_mainMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_mainMenu.setText("Главная");
        lb_mainMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_mainMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lb_mainMenuMouseMoved(evt);
            }
        });
        lb_mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_mainMenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_mainMenuMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 22, 7, 39);
        sidePanel.add(lb_mainMenu, gridBagConstraints);

        lb_exportXML.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lb_exportXML.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_exportXML.setText("Загрузить в файл(.xml)");
        lb_exportXML.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_exportXML.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lb_exportXMLMouseMoved(evt);
            }
        });
        lb_exportXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_exportXMLMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_exportXMLMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 16, 29, 9);
        sidePanel.add(lb_exportXML, gridBagConstraints);

        lb_fabric.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lb_fabric.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_fabric.setText("Таблица ткани");
        lb_fabric.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_fabric.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lb_fabricMouseMoved(evt);
            }
        });
        lb_fabric.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_fabricMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_fabricMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 18, 26, 0);
        sidePanel.add(lb_fabric, gridBagConstraints);

        lb_firrings.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lb_firrings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_firrings.setText("Таблица Фурнитуры");
        lb_firrings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_firrings.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lb_firringsMouseMoved(evt);
            }
        });
        lb_firrings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_firringsMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_firringsMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 29, 16);
        sidePanel.add(lb_firrings, gridBagConstraints);

        jPanel1.add(sidePanel);

        Parent.setBackground(new java.awt.Color(255, 255, 255));
        Parent.setLayout(new java.awt.CardLayout());

        defolt.setBackground(new java.awt.Color(255, 255, 255));
        defolt.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Upward_Arrow_104px.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(81, 352, 0, 12);
        defolt.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Выберите таблицу");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 266, 217, 249);
        defolt.add(jLabel2, gridBagConstraints);

        Parent.add(defolt, "card4");

        tb_StorageFabric.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tb_StorageFabric.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_StorageFabric.setFocusable(false);
        tb_StorageFabric.setGridColor(new java.awt.Color(255, 255, 255));
        tb_StorageFabric.setName("Fabric"); // NOI18N
        tb_StorageFabric.setRowHeight(20);
        tb_StorageFabric.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tb_StorageFabric.getTableHeader().setReorderingAllowed(false);
        tb_StorageFabric.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_StorageFabricKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_StorageFabric);

        javax.swing.GroupLayout fabricLayout = new javax.swing.GroupLayout(fabric);
        fabric.setLayout(fabricLayout);
        fabricLayout.setHorizontalGroup(
            fabricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
            .addGroup(fabricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))
        );
        fabricLayout.setVerticalGroup(
            fabricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
            .addGroup(fabricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );

        Parent.add(fabric, "card2");

        tb_StorageFittings.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tb_StorageFittings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_StorageFittings.setFocusable(false);
        tb_StorageFittings.setGridColor(new java.awt.Color(255, 255, 255));
        tb_StorageFittings.setName("Fittings"); // NOI18N
        tb_StorageFittings.setRowHeight(20);
        tb_StorageFittings.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tb_StorageFittings.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tb_StorageFittings);

        javax.swing.GroupLayout fittingsLayout = new javax.swing.GroupLayout(fittings);
        fittings.setLayout(fittingsLayout);
        fittingsLayout.setHorizontalGroup(
            fittingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
            .addGroup(fittingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))
        );
        fittingsLayout.setVerticalGroup(
            fittingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
            .addGroup(fittingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );

        Parent.add(fittings, "card3");

        jPanel1.add(Parent);

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

    private void tb_StorageFabricKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_StorageFabricKeyReleased

    }//GEN-LAST:event_tb_StorageFabricKeyReleased

    private void lb_mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_mainMenuMouseClicked
         mainMenu();
    }//GEN-LAST:event_lb_mainMenuMouseClicked

    private void lb_exportXMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exportXMLMouseClicked
        menuSave();
    }//GEN-LAST:event_lb_exportXMLMouseClicked

    private void lb_fabricMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_fabricMouseClicked
        Parent.removeAll();
        Parent.add(fabric, "1");
        Parent.repaint();
        Parent.revalidate();
        int cardshow = 1;
        PanelID = cardshow;
        storageFabric();
    }//GEN-LAST:event_lb_fabricMouseClicked

    private void lb_firringsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_firringsMouseClicked
        Parent.removeAll();
        Parent.add(fittings, "2");
        Parent.repaint();
        Parent.revalidate();
        int cardshow = 2;
        PanelID = cardshow;
    }//GEN-LAST:event_lb_firringsMouseClicked

    private void lb_mainMenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_mainMenuMouseMoved
        lb_mainMenu.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lb_mainMenuMouseMoved

    private void lb_mainMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_mainMenuMouseExited
       lb_mainMenu.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_mainMenuMouseExited

    private void lb_exportXMLMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exportXMLMouseMoved
       lb_exportXML.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lb_exportXMLMouseMoved

    private void lb_exportXMLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exportXMLMouseExited
        lb_exportXML.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_exportXMLMouseExited

    private void lb_fabricMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_fabricMouseMoved
        lb_fabric.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lb_fabricMouseMoved

    private void lb_fabricMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_fabricMouseExited
        lb_fabric.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_fabricMouseExited

    private void lb_firringsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_firringsMouseMoved
        lb_firrings.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lb_firringsMouseMoved

    private void lb_firringsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_firringsMouseExited
        lb_firrings.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_firringsMouseExited

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
            java.util.logging.Logger.getLogger(InventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Parent;
    private javax.swing.JPanel defolt;
    private javax.swing.JPanel fabric;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JPanel fittings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_exportXML;
    private javax.swing.JLabel lb_fabric;
    private javax.swing.JLabel lb_firrings;
    private javax.swing.JLabel lb_mainMenu;
    private javax.swing.JPanel sidePanel;
    protected javax.swing.JTable tb_StorageFabric;
    private javax.swing.JTable tb_StorageFittings;
    // End of variables declaration//GEN-END:variables
}
