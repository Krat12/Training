/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.gui.user;

import com.mycompany.hibirnate.filters.DigitFilter;
import com.mycompany.hibirnate.gui.Authorization;
import com.mycompany.hibirnate.gui.MainWindow;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.model.Region;
import com.mycompany.hibirnate.servise.UserService;
import com.mycompany.hibirnate.filters.PhoneFilter;
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
    private static final String CODE_COUNTRY ="+7-";
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
        documentPhone.setDocumentFilter(new PhoneFilter(13));
        PlainDocument documentArea = (PlainDocument) txt_area.getDocument();
        documentArea.setDocumentFilter(new DigitFilter(6));
        PlainDocument documentFloor = (PlainDocument) txt_floor.getDocument();
        documentFloor.setDocumentFilter(new DigitFilter(3));
        PlainDocument documentCost = (PlainDocument) txt_cost.getDocument();
        documentCost.setDocumentFilter(new DigitFilter(9));
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
        entry.setPhone(CODE_COUNTRY.concat(txt_phone.getText()));
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
        jLabel12 = new javax.swing.JLabel();
        txt_fullname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Подача объявления на продажу недвижимости");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Описание объявления");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Email:");

        email.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setText("  ");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Имя:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("+7");

        txt_phone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_phone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Например: 9515778352");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Местоположение объекта");

        cmb_region.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmb_region.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Регион" }));
        cmb_region.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_regionActionPerformed(evt);
            }
        });

        cmb_city.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmb_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Город" }));

        txt_adres.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_adres.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Адрес:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Расскажите о квартире или доме и инфроструктури");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("Контактная информация");

        cmb_realty.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmb_realty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Квартира", "Дом", "Земельный участок" }));
        cmb_realty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_realtyActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setText("Параметры");

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel16.setText("Количество этажей");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel17.setText("Количество комнат");

        txt_floor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_floor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel18.setText("Общая площадь");

        txt_area.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_area.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txt_info.setColumns(20);
        txt_info.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_info.setLineWrap(true);
        txt_info.setRows(5);
        txt_info.setWrapStyleWord(true);
        txt_info.setAutoscrolls(false);
        txt_info.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane1.setViewportView(txt_info);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setText("Тип недвижимости");

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setText("Например: ул, Ленина,23");

        jButton1.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jButton1.setText("Подать заявку ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbl_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_selectimage.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_selectimage.setText("Выбрать изоброжение");
        lbl_selectimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_selectimageActionPerformed(evt);
            }
        });

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

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel21.setText("Цена");

        txt_cost.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_cost.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel12.setText("Телефон:");

        txt_fullname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_fullname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_back1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1)
                        .addGap(213, 213, 213)
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel9)
                        .addGap(359, 359, 359)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel11)
                        .addGap(447, 447, 447)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_adres, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cmb_region, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(cmb_city, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel7)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel12)
                                                .addComponent(txt_phone)
                                                .addComponent(jLabel5)
                                                .addComponent(txt_fullname, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(163, 163, 163))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_selectimage, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(183, 183, 183))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel17))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(panel_one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(panel_too, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(panel_tree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel16)
                                            .addComponent(txt_floor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(panel_foo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel18)
                                                    .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(txt_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(80, 80, 80)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(331, 331, 331)
                                        .addComponent(cmb_realty, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_back1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel9))
                    .addComponent(jLabel19))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_realty, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(email))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_region, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_city, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(txt_adres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_selectimage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_too, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_tree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16)
                        .addGap(9, 9, 9)
                        .addComponent(txt_floor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(panel_foo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel18)
                        .addGap(9, 9, 9)
                        .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel21)
                        .addGap(9, 9, 9)
                        .addComponent(txt_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
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
        if (isEmptyField()) {
            if (room != 0 && cmb_realty.getSelectedItem().equals("Квартира")) {
                setEntry(getRealty());

            } else if (cmb_realty.getSelectedItem().equals("Дом")) {
                setEntry(getRealty());

            } else if (cmb_realty.getSelectedItem().equals("Земельный участок")) {
                setEntry(getRealty());
            } else {
                JOptionPane.showMessageDialog(null, "Не все поля заполнены");
            }

        }


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
                if ("Windows".equals(info.getName())) {
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
    private javax.swing.JLabel jLabel12;
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
    public javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
