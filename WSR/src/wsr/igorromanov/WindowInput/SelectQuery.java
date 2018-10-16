package wsr.igorromanov.WindowInput;


import wsr.igorromanov.utils.ConnectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wsr.igorromanov.customer.CustomerForm;
import wsr.igorromanov.director.DirectorForm;
import wsr.igorromanov.manager.ManagerForm;
import wsr.igorromanov.storekeeper.StoreKeeperForm;


public class SelectQuery {
    Connection con = ConnectionMySQL.getConnection();
    WindowInput window = WindowInput.window;
    private FieldAuthorization field;
    private String status;
    ResultSet rs;
    
    public SelectQuery(FieldAuthorization field) {
        this.field = field;
    }
      
    public void selectDB() {

        PreparedStatement pst;
        if (checkVoidField()) {
            try {
                pst = con.prepareStatement("SELECT role FROM user WHERE login = ? and password = ?");
                pst.setString(1, field.getLogin());
                pst.setString(2, field.getPassword());
                rs = pst.executeQuery();

                if (rs.next()) {
                    status = rs.getString("role");
                    storeKeeper();
                    manager();
                    director();
                    customer();
                } else {
                    JOptionPane.showMessageDialog(null, "Неверный логин или пароль");
                }

            } catch (SQLException ex) {
                Logger.getLogger(SelectQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Заполните все поля");
        }

    }

    private void storeKeeper() {
        if (status.equals("Кладовщик")) {
            window.dispose();
            StoreKeeperForm keeper = new StoreKeeperForm();
            keeper.setVisible(true);
        }
    }

    private void manager() {
        if (status.equals("Менеджер")) {
            window.dispose();
            ManagerForm manager = new ManagerForm();
            manager.setVisible(true);
        }
    }

    private void customer() {
        if (status.equals("Заказчик")) {
            window.dispose();
            CustomerForm customer = new CustomerForm();
            customer.setVisible(true);
        }
    }
    
    private void director() {
        if (status.equals("Руководитель")) {
            window.dispose();
            DirectorForm director = new DirectorForm();
            director.setVisible(true);
        }
    }

    private boolean checkVoidField() {
        return !(field.getLogin().equals("") || field.getPassword().equals(""));
    }

}
