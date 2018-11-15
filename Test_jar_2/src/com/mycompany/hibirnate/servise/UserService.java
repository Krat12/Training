package com.mycompany.hibirnate.servise;

import com.mycompany.hibirnate.dao.AbstractObjectDao;
import com.mycompany.hibirnate.dao.CityImpl;
import com.mycompany.hibirnate.dao.EntryImpl;
import com.mycompany.hibirnate.dao.MySQLDatabaseUser;
import com.mycompany.hibirnate.dao.RegionImpl;
import com.mycompany.hibirnate.dao.RoleImpl;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.model.Region;
import com.mycompany.hibirnate.model.Role;
import com.mycompany.hibirnate.model.User;
import java.util.Arrays;
import java.util.List;

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

}
