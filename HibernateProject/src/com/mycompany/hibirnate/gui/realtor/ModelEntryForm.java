package com.mycompany.hibirnate.gui.realtor;

import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realty;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class ModelEntryForm extends AbstractTableModel {

    private static final int COLUMN_COUNT = 7;
    private List<Entry> entrys;

    public ModelEntryForm(List<Entry> realtys) {
        this.entrys = realtys;
    }

    @Override
    public int getRowCount() {
        return entrys.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Entry enrty = entrys.get(rowIndex);

        switch (columnIndex) {
            case 0:
                ImageIcon image = new ImageIcon(enrty.getRealty().getImage());
                ImageIcon picture = new ImageIcon(image.getImage().getScaledInstance(260, 150, Image.SCALE_SMOOTH));
                return picture;
            case 1:
                return enrty.getRealty().getTypeRealty();
            case 2:
                return enrty.getRealty().getArea();
            case 3:
                return enrty.getRealty().getCity().getCityname();
            case 4:
                return enrty.getAdress();
            case 5:
                return enrty.getFullname();
            case 6:

                return enrty.getPhone();

        }

        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Icon.class;
        } else {
            return getValueAt(0, columnIndex).getClass();
        }
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Изоброжение";
            case 1:
                return "Тип недвижимости";
            case 2:
                return "Площадь(м.)";
            case 3:
                return "Город";
            case 4:
                return "Адрес";
            case 5:
                return "Имя продовца";
            case 6:
                return "Телефон";

        }

        return "";
    }

}
