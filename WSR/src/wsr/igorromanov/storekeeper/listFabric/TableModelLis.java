package wsr.igorromanov.storekeeper.listFabric;


import wsr.igorromanov.utils.TheModel;


public class TableModelLis extends TheModel{
    

    public TableModelLis() {
    }

    public TableModelLis(Object[][] data, String[] columnName) {    
        super(data, columnName);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 5){
            return Float.class;
        }else {
            return getValueAt(0, columnIndex).getClass();
        }
    }
    
    

}
