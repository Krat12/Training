package com.mycompany.hibirnate.servise;

import com.mycompany.hibirnate.dao.interfaces.ObjectDAO;
import com.mycompany.hibirnate.dao.mysql.CityDB;
import com.mycompany.hibirnate.dao.mysql.EntryDB;
import com.mycompany.hibirnate.dao.mysql.UserDB;
import com.mycompany.hibirnate.dao.mysql.RegionDB;
import com.mycompany.hibirnate.dao.mysql.RoleDB;
import com.mycompany.hibirnate.dao.interfaces.UserDAO;
import com.mycompany.hibirnate.dao.mysql.RealtyDB;
import com.mycompany.hibirnate.gui.user.RealtySell;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.model.Region;
import com.mycompany.hibirnate.model.Role;
import com.mycompany.hibirnate.model.User;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class UserService {

    private UserDAO userDAO = UserDB.getInstance();
    private ObjectDAO entryDAO = EntryDB.getInstance();
    private static List<Region> regions;

    public UserService() {

    }

    public String getUserRole(User user) {
        String role = user.getRole().getRoleId();
        return role;
    }

    public boolean saveUser(User user) {
        if (getUserByEmail(user.getEmail()) == null) {
            userDAO.insert(user);
            return true;
        }
        return false;
    }

    public boolean updateUser(User user) {
        if (user != null) {
            userDAO.update(user);
            return true;
        }
        return false;
    }

    public User getUserByEmail(String email) {

        return (User) userDAO.getObjectByID(email, User.class);
    }

    public List<User> getAllUsers() {

        List<User> users = userDAO.getAllObject();
        return users;
    }

    public Role getRoleById(String id) {
        Role role = (Role) new RoleDB().getObjectByID(id, Role.class);
        System.out.println(Arrays.asList(role.getUserList()));
        return role;
    }

    public List<User> getUserByName(String name) {
        return userDAO.getUsersByName(name);
    }

    public User getUserByLoginAndPassword(String email, String password) {
        return userDAO.getUserByLoginAndPassword(email, password);
    }

    public List<Region> getAllRegions() {
        if (regions == null) {
            regions = new RegionDB().getAllObject();
        }
        return regions;
    }

    public boolean saveRealty(Realty realty) {

        return new RealtyDB().insert(realty);

    }

    public City getCityByName(String name) {
        return new CityDB().getCityByName(name);
    }

    public void saveEntry(Entry entry) {
        entryDAO.insert(entry);
    }

    public static boolean checkCharser(String inutData) {
        String regexp = "{0,10}";
        return inutData.matches(regexp);
    }

//   public User getTestUser(String email){
//      AbstractObjectDao  databaseUser = new MySQLDatabaseUser();
//       
//       return (User) databaseUser.getObjectByID(email, User.class);
//   }
    public byte[] getImage(String path) {
        byte[] imageInByte = null;
        try {
            File fnew = new File(path);
            BufferedImage originalImage = ImageIO.read(fnew);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            imageInByte = baos.toByteArray();
            System.out.println(imageInByte.length);
        } catch (IOException ex) {
            Logger.getLogger(RealtySell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageInByte;
    }
}
