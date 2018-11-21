package com.mycompany.hibirnate.gui.realtor;

import com.mycompany.hibirnate.model.Realty;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class ModelEntryForm extends AbstractTableModel {

    private static final int COLUMN_COUNT = 7;
    private List<Realty> realtys;

    public ModelEntryForm(List<Realty> realtys) {
        this.realtys = realtys;
    }

    @Override
    public int getRowCount() {
        return realtys.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Realty realty = realtys.get(rowIndex);

        switch (columnIndex) {
            case 0:
                ImageIcon image = new ImageIcon(realty.getImage());
                ImageIcon picture = new ImageIcon(image.getImage().getScaledInstance(260, 150, Image.SCALE_SMOOTH));
                return picture;
            case 1:

                return realty.getTypeRealty();

            case 2:
                return realty.getArea();
            case 3:
                return realty.getCity().getCityname();
            case 4:
                return realty.getEntryList().get(0).getAdress();
            case 5:
                return realty.getEntryList().get(0).getFullname();
            case 6:

                return realty.getEntryList().get(0).getPhone();

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
