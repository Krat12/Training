package wsr.igorromanov.utils;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;


public class TheModel extends AbstractTableModel {
    
    private String[] columnName;
    private Object[][] rows;
    
    public TheModel(){}
    
    public TheModel(Object[][] data, String[] columnName){
        this.rows = data;
        this.columnName = columnName;
    }

    @Override
    public int getRowCount() {
       return this.rows.length;
    }

    @Override
    public int getColumnCount() {
        return this.columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column]; 
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 5){
            return Icon.class;
        }else {
            return getValueAt(0, columnIndex).getClass();
        }
    }
    
    
    

}
