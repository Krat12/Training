package wsr.igorromanov.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectionMySQL {
    private static Connection con;
    
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/wsr";
        String user = "root";
        String password = "1234";
       
        if (con == null){ 
            try {
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Ошибка подключение к БД " + ex);
            }
            
        }
       
        return con; 
    }

}
