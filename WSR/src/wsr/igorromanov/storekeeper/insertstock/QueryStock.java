package wsr.igorromanov.storekeeper.insertstock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wsr.igorromanov.utils.ConnectionMySQL;


public class QueryStock {

//    public static int roll;
//    public static int party;
//    private static int ID;
//
//    public static void selectQuery(Object nameFabric) {
//        Connection con = ConnectionMySQL.getConnection();
//        String fabric = "SELECT roll,storage_fabric_id FROM storage_fabric s \n"
//                + "inner join fabric f \n"
//                + "on f.vendor_code_fb_id = s.vendor_code_fb_fk \n"
//                + "where name ='" + nameFabric + "'";
//        
//        
//        String fittings = "SELECT f.vendor_code_fi_id,party \n"
//                + "from fittings f\n"
//                + "inner join storage_fittings s \n"
//                + "on f.vendor_code_fi_id = s.vendor_code_fi_id \n"
//                +"where name = '"+nameFabric+"'";
//        
//        ResultSet rs;
//        Statement st = null;
//        try {
//            st = con.createStatement();
//            rs = st.executeQuery(fabric);
//            if (rs.next()) {
//                roll = rs.getInt("roll");
//                System.out.println(roll);
//                ID = rs.getInt("storage_fabric_id"); 
//            }else {
//                rs = st.executeQuery(fittings);
//                 while (rs.next()){
//                     party = rs.getInt("party");
//                     System.out.println(party);
//                     ID = rs.getInt("vendor_code_fi_id");
//                 }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(QueryStock.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            if (st != null){
//                try {
//                    st.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(QueryStock.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        
//    }
    
    public static void updateRoll(int roll, int ID){
        PreparedStatement update = null;
        Connection con = ConnectionMySQL.getConnection();
        String sql = "UPDATE storage_fabric set roll = ? \n"
                + "WHERE storage_fabric_id = ?";
        
        try {
            update = con.prepareStatement(sql);
            update.setInt(1, roll);
            update.setInt(2,ID);
            update.executeUpdate();
            JOptionPane.showMessageDialog(null,"Данные обновились");

        } catch (SQLException ex) {
            Logger.getLogger(QueryStock.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (update != null){
                try {
                    update.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QueryStock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
       public static void updateParty(int party, int ID){
        PreparedStatement update = null;
        Connection con = ConnectionMySQL.getConnection();
        String sql = "UPDATE storage_fittings set party = ? \n"
                + "WHERE storage_fittings_id = ?";
        
        try {
            update = con.prepareStatement(sql);
            update.setInt(1, party);
            update.setInt(2,ID);
            update.executeUpdate();
            JOptionPane.showMessageDialog(null,"Данные обновились");

        } catch (SQLException ex) {
            Logger.getLogger(QueryStock.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (update != null){
                try {
                    update.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QueryStock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}
