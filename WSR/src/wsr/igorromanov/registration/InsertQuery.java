package wsr.igorromanov.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wsr.igorromanov.WindowInput.ConnectionMySQL;

public class InsertQuery {

    Connection con = ConnectionMySQL.getConnection();
    FieldRegistration field;

    public InsertQuery(FieldRegistration field) {
        this.field = field;
    }

    private boolean checkRole() {
        if (field.getRole().equals("Роль")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkName() {
        if (field.getName().equals("")) { //it is better to use regular expressions
            return false;
        } else {
            return true;
        }
    }

    private boolean checkLogin() {
        if (field.getLogin().equals("")) { //it is better to use regular expressions
            return false;
        } else {
            return true;
        }
    }

    private boolean checkPassword() {
        if (field.getPassword().equals("")) { //it is better to use regular expressions
            return false;
        } else {
            return true;
        }
    }

    public void insertDB() {
        if (checkRole() && checkLogin() && checkName() && checkPassword()) {
            try {
                String sql = "INSERT INTO user (name,login,password,role) VALUES (?,?,?,?)";
                PreparedStatement registr = con.prepareStatement(sql);
                registr.setString(1, field.getName());
                registr.setString(2, field.getLogin());
                registr.setString(3, field.getPassword());
                registr.setString(4, field.getRole());
                registr.executeUpdate();
                JOptionPane.showMessageDialog(null, "Регистрация завершена");
                registr.close();

            } catch (SQLException ex) {
                Logger.getLogger(InsertQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Проверьте заполнили поля регистрации и выборали роль");
        }

    }

}
