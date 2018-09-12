package jtableimage;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyQuery {
   static Connection con;
    
    public Connection getConnection (){
       try {
           con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","18lulego123");
           System.out.println("все гууд");
       } catch (SQLException ex) {
           Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
       return con;
    }
    public ArrayList<Film> getFilmList(){
        Connection con = getConnection();
        
        ArrayList<Film> filmlist = new ArrayList<Film>();
        String QueryFilm = "SELECT NameFilmID, NameFilm, budget,s.NameStud,DateFilm,PictureFilm,f.NameStudID,c.Sign FROM films f LEFT JOIN studia s ON f.NameStudID=s.NameStudID LEFT JOIN Currency c ON f.CurrencyID = c.CurrencyID";
        Statement st;
        ResultSet rs;
        
       try {
           st = con.createStatement();
           rs = st.executeQuery(QueryFilm);
           
           while (rs.next()){
               Film film = new Film(rs.getString("DateFilm"),
                                    rs.getInt("Budget"),
                                    rs.getString("NameFilm"),
                                    rs.getBytes("PictureFilm"),  
                                    rs.getString("NameStud"));
               filmlist.add(film);
           }
       } catch (SQLException ex) {
           Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
       }
       return filmlist;
    }
    

}
