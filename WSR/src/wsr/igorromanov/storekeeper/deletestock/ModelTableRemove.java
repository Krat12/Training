/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsr.igorromanov.storekeeper.deletestock;

import javax.swing.Icon;
import wsr.igorromanov.utils.TheModel;

/**
 *
 * @author Студент
 */
public class ModelTableRemove extends TheModel{

    public ModelTableRemove(Object[][] data, String[] columnName) {
        super(data, columnName);
    }
    
    
        @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3){
            return Icon.class;
        }else {
            return getValueAt(0, columnIndex).getClass();
        }
    }
    
}
