package wsr.igorromanov.storekeeper;

import java.awt.Font;
import wsr.igorromanov.utils.TheModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import wsr.igorromanov.utils.ConnectionMySQL;


public class Storage {
    
private final ArrayList<FieldStorage> listStorageFabric = new ArrayList<FieldStorage>();
private final ArrayList<FieldStorage> listStorageFittings = new ArrayList<FieldStorage>();
private Object[][] rows;
    
    private ArrayList<FieldStorage> StorageFabric()  {

        Connection con = ConnectionMySQL.getConnection();
        Statement st = null;
        ResultSet rs;
        String sql = "SELECT name,vendor_code_fabric,roll,colour,consist,width,s.length,cost,image,storage_fabric_id \n"
                + "FROM fabric f\n"
                + "LEFT JOIN storage_fabric s \n"
                + "ON f.vendor_code_fb_id = s.vendor_code_fb_fk";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                FieldStorage field = new FieldStorage(rs.getString("name"),
                        rs.getString("vendor_code_fabric"),
                        rs.getString("colour"),
                        rs.getString("consist"),
                        rs.getInt("roll"),
                        rs.getString("width"),
                        rs.getInt("length"),
                        rs.getInt("cost"),
                        rs.getBytes("image"),
                        rs.getInt("storage_fabric_id"));
                listStorageFabric.add(field);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return listStorageFabric;
    }

    
private ArrayList<FieldStorage>StorageFittings(){
    Connection con = ConnectionMySQL.getConnection();
        Statement st = null;
        ResultSet rs = null;
    try {
        
        String sql = "SELECT name,type,heft,image,f.vendor_code_fi_id,cost,width,length,party,amount \n"
                + "from fittings f\n"
                + "left join storage_fittings s \n"
                + "on f.vendor_code_fi_id = s.vendor_code_fi_id";

        st = con.createStatement();
        rs = st.executeQuery(sql);
        
        while (rs.next()){
            FieldStorage field = new FieldStorage(rs.getString("type"),
                                                  rs.getFloat("heft"),
                                                  rs.getInt("party"),
                                                  rs.getInt("amount"),
                                                  rs.getString("name"),
                                                  rs.getBytes("image"),
                                                  rs.getInt("vendor_code_fi_id"),
                                                  rs.getFloat("length"),
                                                  rs.getFloat("cost"),
                                                  rs.getFloat("width"));
          listStorageFittings.add(field);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        if(st != null){
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    return listStorageFittings;
}


public ArrayList<FieldStorage> getFabricList(){
    if (!listStorageFabric.isEmpty()){
        return listStorageFabric;
    } else {
        return StorageFabric();
    }
}

public ArrayList<FieldStorage> getFittingsList(){
    if (!listStorageFittings.isEmpty()){
        return listStorageFittings;
    } else {
        return StorageFittings();
    }
}

    public  void createTable(JTable table,String[] columnName,ArrayList<FieldStorage> listField) {
        rows = new Object[listField.size()][];
        for (int i = 0; i < rows.length; i++) {
            if (table.getName().equals("Fabric")) {
                rows[i] = (Object[]) listField.get(i).getRowFabric();
            }
            if (table.getName().equals("Fittings")) {
                rows[i] = listField.get(i).getRowFittings();
            }
        }
        TheModel model = new TheModel(rows, columnName);
        table.setModel(model);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Float.class, centerRenderer);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 16));
        
     }

}
