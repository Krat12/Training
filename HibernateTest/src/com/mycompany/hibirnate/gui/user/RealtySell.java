/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.gui.user;

import com.mycompany.hibirnate.gui.Authorization;
import com.mycompany.hibirnate.gui.MainWindow;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.model.Region;
import com.mycompany.hibirnate.servise.UserService;
import com.mycompany.hibirnate.utill.DigitFilter;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Admin
 */
public class RealtySell extends javax.swing.JFrame {

    private static int room;
    private static final String FULL_NAME = Authorization.user.getFirstName() + " " + Authorization.user.getLastName();
    private static final String EMAIL = Authorization.user.getEmail();
    private static String path;
    private static UserService service = new UserService();

    public RealtySell() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        email.setText(EMAIL);
        txt_fullname.setText(FULL_NAME);
        digitTextField();
        getAllRegions();

    }

    private boolean isEmptyField() {
        if (txt_fullname.getText().equals("") || txt_phone.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Поля 'Имя' и 'Телефон' должеы быть заполнены");
            return false;
        }
        if (txt_adres.getText().equals("") || txt_area.getText().equals("") || txt_cost.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Не все поля заполнены");
            return false;
        }
        if (cmb_region.getSelectedItem().equals("Регион") || cmb_city.getSelectedItem().equals("Город")) {
            JOptionPane.showMessageDialog(null, "Выберите город и регион");
            return false;
        }
        if (txt_info.getText().equals("") || lbl_img.getIcon() == null) {
            JOptionPane.showMessageDialog(null, "Проверьте изоброжение и описание объявления");
            return false;
        }
        return true;
    }

    private void setEnableFalse() {
        lbl_one.setEnabled(false);
        lbl_one3.setEnabled(false);
        lbl_one1.setEnabled(false);
        lbl_one2.setEnabled(false);
    }

    private void setEnableTrue() {
        lbl_one.setEnabled(true);
        lbl_one3.setEnabled(true);
        lbl_one1.setEnabled(true);
        lbl_one2.setEnabled(true);

    }

    private void digitTextField() {
        PlainDocument documentPhone = (PlainDocument) txt_phone.getDocument();
        documentPhone.setDocumentFilter(new DigitFilter());
        PlainDocument documentArea = (PlainDocument) txt_area.getDocument();
        documentArea.setDocumentFilter(new DigitFilter());
        PlainDocument documentFloor = (PlainDocument) txt_floor.getDocument();
        documentFloor.setDocumentFilter(new DigitFilter());
        PlainDocument documentCost = (PlainDocument) txt_cost.getDocument();
        documentCost.setDocumentFilter(new DigitFilter());
    }

    private void getAllRegions() {
        List<Region> regions = service.getAllRegions();
        for (Region region : regions) {
            cmb_region.addItem(region.getRegionName());
        }
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

    private void setEntry(Realty realty) {

        Entry entry = new Entry();
        entry.setUser1(Authorization.user);
        entry.setRealty(realty);
        entry.setAdress(txt_adres.getText());
        entry.setFullname(txt_fullname.getText());
        entry.setPhone(txt_phone.getText());
        entry.setCost(Long.valueOf(txt_cost.getText()));
        entry.setStatusEntry("На обработки");
        entry.setTypeEntry("Продажа");
        service.saveEntry(entry);
        JOptionPane.showMessageDialog(null, "Заявка добавлена");
    }

    private Realty getRealty() {
        Realty realty = new Realty();

        realty.setArea(Float.valueOf(txt_area.getText()));
        realty.setTypeRealty(String.valueOf(cmb_realty.getSelectedItem()));
        realty.setInfo(txt_info.getText());
        City city = service.getCityByName(String.valueOf(cmb_city.getSelectedItem()));
        realty.setCity(city);
        realty.setImage(service.getImage(path));
        if (cmb_realty.getSelectedItem().equals("Квартира")) {
            realty.setRooms(room);
        }
        if (cmb_realty.getSelectedItem().equals("Дом")) {
            realty.setNumberFloors(Integer.valueOf(txt_floor.getText()));
        }
        service.saveRealty(realty);
        return realty;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_back1 = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        txt_fullname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmb_region = new javax.swing.JComboBox<>();
        cmb_city = new javax.swing.JComboBox<>();
        txt_adres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_realty = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_floor = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_area = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_info = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbl_img = new javax.swing.JLabel();
        lbl_selectimage = new javax.swing.JButton();
        panel_one = new javax.swing.JPanel();
        lbl_one = new javax.swing.JLabel();
        panel_too = new javax.swing.JPanel();
        lbl_one1 = new javax.swing.JLabel();
        panel_tree = new javax.swing.JPanel();
        lbl_one2 = new javax.swing.JLabel();
        panel_foo = new javax.swing.JPanel();
        lbl_one3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_cost = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_back1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_back1.setText("Назад");
        btn_back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, 98, 42));

        btn_logout.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jPanel1.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 98, 42));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Подача объявления на продажу недвижимости");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Описание объявления");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 620, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Email:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 171, -1, -1));

        email.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        email.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 171, 260, 24));

        txt_fullname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_fullname.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txt_fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 213, 261, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Имя:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 215, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel10.setText("Телефон");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 263, -1, -1));

        txt_phone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_phone.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 261, 263, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Например: 79515778352");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 297, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Местоположение объекта");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 370, -1, -1));

        cmb_region.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmb_region.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Регион" }));
        cmb_region.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_regionActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_region, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 430, 210, 36));

        cmb_city.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmb_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Город" }));
        jPanel1.add(cmb_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 430, 186, 36));

        txt_adres.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_adres.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txt_adres, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 515, 424, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Адрес:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 487, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Расскажите о квартире или доме и инфроструктури");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 860, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("Контактная информация");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 115, -1, -1));

        cmb_realty.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmb_realty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Квартира", "Дом", "Земельный участок" }));
        cmb_realty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_realtyActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_realty, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 186, 36));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setText("Параметры");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 618, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel16.setText("Количество этажей");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 750, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel17.setText("Количество комнат");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 659, -1, -1));

        txt_floor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_floor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txt_floor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 780, 150, 40));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel18.setText("Общая площадь");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 750, -1, -1));

        txt_area.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_area.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txt_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 780, 150, 40));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txt_info.setColumns(20);
        txt_info.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_info.setLineWrap(true);
        txt_info.setRows(5);
        txt_info.setWrapStyleWord(true);
        txt_info.setAutoscrolls(false);
        jScrollPane1.setViewportView(txt_info);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 660, 500, 190));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setText("Тип недвижимости");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setText("Например: ул, Ленина,23");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 551, -1, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jButton1.setText("Подать заявку ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 860, 210, 50));

        lbl_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 280, 270));

        lbl_selectimage.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_selectimage.setText("Выбрать изоброжение");
        lbl_selectimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_selectimageActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_selectimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, 230, 40));

        panel_one.setBackground(new java.awt.Color(255, 255, 255));
        panel_one.setForeground(new java.awt.Color(255, 255, 255));

        lbl_one.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_one.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_one.setText("1");
        lbl_one.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_one.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_one.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_oneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_oneLayout = new javax.swing.GroupLayout(panel_one);
        panel_one.setLayout(panel_oneLayout);
        panel_oneLayout.setHorizontalGroup(
            panel_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_one, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        panel_oneLayout.setVerticalGroup(
            panel_oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_one, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(panel_one, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 690, 40, 40));

        panel_too.setBackground(new java.awt.Color(255, 255, 255));
        panel_too.setForeground(new java.awt.Color(255, 255, 255));

        lbl_one1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_one1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_one1.setText("2");
        lbl_one1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_one1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_one1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_one1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_tooLayout = new javax.swing.GroupLayout(panel_too);
        panel_too.setLayout(panel_tooLayout);
        panel_tooLayout.setHorizontalGroup(
            panel_tooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(panel_tooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_tooLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_one1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel_tooLayout.setVerticalGroup(
            panel_tooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(panel_tooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_tooLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_one1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(panel_too, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 690, -1, -1));

        panel_tree.setBackground(new java.awt.Color(255, 255, 255));
        panel_tree.setForeground(new java.awt.Color(255, 255, 255));

        lbl_one2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_one2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_one2.setText("3");
        lbl_one2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_one2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_one2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_one2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_treeLayout = new javax.swing.GroupLayout(panel_tree);
        panel_tree.setLayout(panel_treeLayout);
        panel_treeLayout.setHorizontalGroup(
            panel_treeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_one2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        panel_treeLayout.setVerticalGroup(
            panel_treeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_one2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(panel_tree, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 690, -1, -1));

        panel_foo.setBackground(new java.awt.Color(255, 255, 255));
        panel_foo.setForeground(new java.awt.Color(255, 255, 255));

        lbl_one3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_one3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_one3.setText("4+");
        lbl_one3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_one3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_one3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_one3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_fooLayout = new javax.swing.GroupLayout(panel_foo);
        panel_foo.setLayout(panel_fooLayout);
        panel_fooLayout.setHorizontalGroup(
            panel_fooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_one3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        panel_fooLayout.setVerticalGroup(
            panel_fooLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_one3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(panel_foo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 690, -1, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel21.setText("Цена");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 750, -1, -1));

        txt_cost.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_cost.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txt_cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 780, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back1ActionPerformed
        UserForm form = UserForm.userForm;
        this.dispose();
        form.setVisible(true);
    }//GEN-LAST:event_btn_back1ActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        MainWindow mainWindow = MainWindow.Window;
        this.dispose();
        mainWindow.setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void lbl_oneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_oneMouseClicked
        if (cmb_realty.getSelectedItem().equals("Квартира")) {
            panel_one.setBackground(new Color(0, 191, 255));
            panel_too.setBackground(new Color(255, 255, 255));
            panel_tree.setBackground(new Color(255, 255, 255));
            panel_foo.setBackground(new Color(255, 255, 255));
            room = 1;
        }

    }//GEN-LAST:event_lbl_oneMouseClicked

    private void lbl_one1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_one1MouseClicked
        if (cmb_realty.getSelectedItem().equals("Квартира")) {
            panel_too.setBackground(new Color(0, 191, 255));
            panel_tree.setBackground(new Color(255, 255, 255));
            panel_foo.setBackground(new Color(255, 255, 255));
            panel_one.setBackground(new Color(255, 255, 255));
            room = 2;
        }
    }//GEN-LAST:event_lbl_one1MouseClicked

    private void lbl_one2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_one2MouseClicked
        if (cmb_realty.getSelectedItem().equals("Квартира")) {
            panel_tree.setBackground(new Color(0, 191, 255));
            panel_one.setBackground(new Color(255, 255, 255));
            panel_too.setBackground(new Color(255, 255, 255));
            panel_foo.setBackground(new Color(255, 255, 255));
            room = 3;
        }
    }//GEN-LAST:event_lbl_one2MouseClicked

    private void lbl_one3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_one3MouseClicked
        if (cmb_realty.getSelectedItem().equals("Квартира")) {
            panel_foo.setBackground(new Color(0, 191, 255));
            panel_too.setBackground(new Color(255, 255, 255));
            panel_one.setBackground(new Color(255, 255, 255));
            panel_tree.setBackground(new Color(255, 255, 255));
            room = 4;
        }
    }//GEN-LAST:event_lbl_one3MouseClicked

    private void cmb_realtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_realtyActionPerformed
        if (cmb_realty.getSelectedItem().equals("Дом")) {
            setEnableFalse();
            room = 0;
            panel_foo.setBackground(new Color(255, 255, 255));
            panel_too.setBackground(new Color(255, 255, 255));
            panel_one.setBackground(new Color(255, 255, 255));
            panel_tree.setBackground(new Color(255, 255, 255));
            txt_floor.setEditable(true);

        }
        if (cmb_realty.getSelectedItem().equals("Квартира")) {
            setEnableTrue();
            txt_floor.setEditable(true);
        }
        if (cmb_realty.getSelectedItem().equals("Земельный участок")) {
            setEnableFalse();
            room = 0;
            panel_foo.setBackground(new Color(255, 255, 255));
            panel_too.setBackground(new Color(255, 255, 255));
            panel_one.setBackground(new Color(255, 255, 255));
            panel_tree.setBackground(new Color(255, 255, 255));
            txt_floor.setEditable(false);
        }


    }//GEN-LAST:event_cmb_realtyActionPerformed

    private void lbl_selectimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_selectimageActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.setFileFilter(filter);
        int result = file.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = file.getSelectedFile();
            String nameFile = selectedFile.getName();
            System.out.println(nameFile);
            path = selectedFile.getAbsolutePath();
            ImageIcon icon = new ImageIcon(path);
            lbl_img.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH)));

        }
    }//GEN-LAST:event_lbl_selectimageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(UserService.checkCharser(txt_phone.getText()));
      //  if (isEmptyField()) {
            if (room != 0 && cmb_realty.getSelectedItem().equals("Квартира")) {
                setEntry(getRealty());

            } else if (cmb_realty.getSelectedItem().equals("Дом")) {
                setEntry(getRealty());

            } else if (cmb_realty.getSelectedItem().equals("Земельный участок")) {
                setEntry(getRealty());
            } else {
                JOptionPane.showMessageDialog(null, "Не все поля заполнены");
            }

        //}


    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmb_regionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_regionActionPerformed
        cmb_city.removeAllItems();
        cmb_city.addItem("Город");
        if (!cmb_region.getSelectedItem().equals("Регион")) {
            getAllCitybyRegion();
        }
    }//GEN-LAST:event_cmb_regionActionPerformed

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
            java.util.logging.Logger.getLogger(RealtySell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealtySell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealtySell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealtySell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RealtySell().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back1;
    private javax.swing.JButton btn_logout;
    private javax.swing.JComboBox<String> cmb_city;
    private javax.swing.JComboBox<String> cmb_realty;
    private javax.swing.JComboBox<String> cmb_region;
    private javax.swing.JLabel email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_one;
    private javax.swing.JLabel lbl_one1;
    private javax.swing.JLabel lbl_one2;
    private javax.swing.JLabel lbl_one3;
    private javax.swing.JButton lbl_selectimage;
    private javax.swing.JPanel panel_foo;
    private javax.swing.JPanel panel_one;
    private javax.swing.JPanel panel_too;
    private javax.swing.JPanel panel_tree;
    private javax.swing.JTextField txt_adres;
    private javax.swing.JTextField txt_area;
    private javax.swing.JTextField txt_cost;
    private javax.swing.JTextField txt_floor;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JTextArea txt_info;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
