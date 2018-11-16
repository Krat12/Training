package com.mycompany.hibirnate.servise;

import com.mycompany.hibirnate.dao.CityImpl;
import com.mycompany.hibirnate.dao.EntryImpl;
import com.mycompany.hibirnate.dao.MySQLDatabaseUser;
import com.mycompany.hibirnate.dao.RegionImpl;
import com.mycompany.hibirnate.dao.RoleImpl;
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
import javax.swing.JOptionPane;

public class UserService {
   
    
    public UserService() {

    }
    
    public String getUserRole(User user) {
        String role = user.getRole().getRoleId();
        return role;
    }

    public void saveUser(User user) {
        new MySQLDatabaseUser().insertOrUpdate(user);
        System.out.println(user);
    }

    public User getUserByEmail(String email) {  
        return  (User) new MySQLDatabaseUser().getObjectByID(email,User.class);
    }

    public List<User> getAllUsers() {
        List<User> users = new MySQLDatabaseUser().getAllObject();
        System.out.println(users);
        return users;
    }
    
    public Role getRoleById(String id){
        Role role =  (Role) new RoleImpl().getObjectByID(id,Role.class);
        System.out.println(Arrays.asList(role.getUserList()));
        return role;
    }
    
    public List<User>getUserByName(String name){
        return new MySQLDatabaseUser().getUsersByName(name);
    }
    
    public User getUserByLoginAndPassword(String email, String password){
        return (User) new MySQLDatabaseUser().getUserByLoginAndPassword(email, password);
    }
    
    public List<Region> getAllRegions(){
        List<Region> regions= new RegionImpl().getAllObject();
        return regions;
    }
    public boolean saveRealty(Realty realty){
        return new CityImpl().insertOrUpdate(realty);
    } 
    
    public City getCityByName(String name){
        return new CityImpl().getCityByName(name);
    }
    
    public void saveEntry(Entry entry){
        new EntryImpl().insertOrUpdate(entry);
    }
    
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
   
   public static boolean checkCharser(String inutData){
       String regexp = "{0,10}";
       if (inutData.matches(regexp)){
           return true;
       }
       JOptionPane.showMessageDialog(null, "Размер поля не должен превышать 10 символов");
       return false;
   }

}
