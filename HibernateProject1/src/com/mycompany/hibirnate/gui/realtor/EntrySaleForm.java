/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.gui.realtor;

import com.mycompany.hibirnate.gui.MainWindow;
import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.model.Region;
import com.mycompany.hibirnate.servise.RealtorService;
import com.mycompany.hibirnate.servise.UserService;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Admin
 */
public class EntrySaleForm extends javax.swing.JFrame {

    private static final int COLOUMN_ID = 7;
    private static final int HIDE = 0;
    private static UserService service = new UserService();
    private static RealtorService realtorService = new RealtorService();
    private static List<Realty> realtys;

    public EntrySaleForm() {
        initComponents();
        setLocationRelativeTo(null);
        TableRealtorEnrty();
        getAllRegions();
        hideColoumnId();
    }

    private void getAllCitybyRegion() {
        List<Region> regions = service.getAllRegions();
        for (Region region : regions) {
            if (region.getRegionName().equals(cmb_region.getSelectedItem())) {
                for (int i = 0; i < region.getCityList().size(); i++) {
                    cmb_city.addItem(region.getCityList().get(i).getCityname());
                }

            }
        }

    }

    private void hideColoumnId() {
        tb_entry.getColumnModel().getColumn(COLOUMN_ID).setMinWidth(HIDE);
        tb_entry.getColumnModel().getColumn(COLOUMN_ID).setMaxWidth(HIDE);
    }

    private void getAllRegions() {
        List<Region> regions = service.getAllRegions();
        for (Region region : regions) {
            cmb_region.addItem(region.getRegionName());
        }
    }

    private void TableRealtorEnrty() {
        List<Realty> list = realtorService.getAllRealty();
        tb_entry.setModel(new ModelEntryForm(list));
        settingsTable(tb_entry);
    }

    private void settingsTable(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Float.class, centerRenderer);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Aria", Font.BOLD, 18));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_entry = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_back1 = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        cmb_region = new javax.swing.JComboBox<>();
        cmb_city = new javax.swing.JComboBox<>();
        cmb_realty = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 800));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel2.setPreferredSize(new java.awt.Dimension(1194, 1000));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(453, 600));

        tb_entry.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tb_entry.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_entry.setRowHeight(80);
        tb_entry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_entryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_entry);

        jPanel2.add(jScrollPane2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btn_back1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_back1.setText("Назад");
        btn_back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back1ActionPerformed(evt);
            }
        });

        btn_logout.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        cmb_region.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmb_region.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Регион" }));
        cmb_region.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_regionActionPerformed(evt);
            }
        });

        cmb_city.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmb_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Город" }));

        cmb_realty.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmb_realty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Недвижимость", "Квартира", "Дом", "Земельный участок" }));

        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("Найти");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btn_back1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(cmb_region, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmb_city, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmb_realty, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_back1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_city, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_region, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_realty, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        MainWindow mainWindow = MainWindow.Window;
        this.dispose();
        mainWindow.setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back1ActionPerformed
        RealtorForm form = RealtorForm.realtorForm;
        this.dispose();
        form.setVisible(true);
    }//GEN-LAST:event_btn_back1ActionPerformed

    private void cmb_regionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_regionActionPerformed
        cmb_city.removeAllItems();
        cmb_city.addItem("Город");

        if (!cmb_region.getSelectedItem().equals("Регион")) {

            getAllCitybyRegion();
        }
    }//GEN-LAST:event_cmb_regionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String realtyName = String.valueOf(cmb_realty.getSelectedItem());
        String cityNsme = String.valueOf(cmb_city.getSelectedItem());

        realtys = realtorService.getRealtyByType(realtyName, cityNsme);

        tb_entry.setModel(new ModelEntryForm(realtys));
        hideColoumnId();
        ((ModelEntryForm) tb_entry.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tb_entryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_entryMouseClicked

        InformationForm informationForm = new InformationForm();
        int row = tb_entry.getSelectedRow();
        int culoumn = COLOUMN_ID;
        Object entryId = tb_entry.getValueAt(row, culoumn);
        Entry entry = realtorService.getEntryById((Integer) entryId);
        setDataOnFace(entry, informationForm);
        informationForm.setVisible(true);


    }//GEN-LAST:event_tb_entryMouseClicked

    private void setDataOnFace(Entry entry, InformationForm informationForm) {
        informationForm.txt_info.setText(entry.getRealty().getInfo());
        informationForm.lbl_adres.setText(entry.getAdress());
        informationForm.lbl_amountF.setText(String.valueOf(entry.getRealty().getNumberFloors()));
        informationForm.lbl_amountroom.setText(String.valueOf(entry.getRealty().getRooms()));
        informationForm.lbl_area.setText(String.valueOf(entry.getRealty().getArea()));
        informationForm.lbl_city.setText(entry.getRealty().getCity().getCityname());
        informationForm.lbl_cost.setText(String.valueOf(entry.getCost()) + " " + "руб");
        informationForm.lbl_email.setText(entry.getUser1().getEmail());
        informationForm.lbl_namefull.setText(entry.getFullname());
        informationForm.lbl_phone.setText(entry.getPhone());
        informationForm.lbl_typeRealty.setText(entry.getRealty().getTypeRealty());
        ImageIcon icon = new ImageIcon(entry.getRealty().getImage());
        informationForm.lbl_image.setIcon(new ImageIcon(icon.getImage().getScaledInstance(informationForm.lbl_image.getWidth(), informationForm.lbl_image.getHeight(), Image.SCALE_SMOOTH)));
    }

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
            java.util.logging.Logger.getLogger(EntrySaleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntrySaleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntrySaleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntrySaleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntrySaleForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back1;
    private javax.swing.JButton btn_logout;
    private javax.swing.JComboBox<String> cmb_city;
    private javax.swing.JComboBox<String> cmb_realty;
    private javax.swing.JComboBox<String> cmb_region;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_entry;
    // End of variables declaration//GEN-END:variables
}
