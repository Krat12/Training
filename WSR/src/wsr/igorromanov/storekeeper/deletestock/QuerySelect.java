/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsr.igorromanov.storekeeper.deletestock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import wsr.igorromanov.storekeeper.FieldStorage;
import wsr.igorromanov.storekeeper.Storage;
import wsr.igorromanov.utils.ConnectionMySQL;

/**
 *
 * @author Студент
 */
public class QuerySelect {
    
    private final ArrayList<FieldStorage> listStorageFabric = new ArrayList<FieldStorage>();
    
        public ArrayList<FieldStorage> RemoveStorageFabric()  {

        Connection con = ConnectionMySQL.getConnection();
        Statement st = null;
        ResultSet rs;
            String sql = "SELECT name,vendor_code_fabric,s.length,image FROM fabric f \n"
                    + "left join storage_fabric s \n"
                    + "on f.vendor_code_fb_id = s.vendor_code_fb_fk \n"
                    + "where s.length < 0.5; ";
                
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                
                FieldStorage field = new FieldStorage(rs.getString("name"),
                        rs.getString("vendor_code_fabric"),
                        rs.getFloat("lengtn"),
                        rs.getBytes("image"));
                
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
    
}
