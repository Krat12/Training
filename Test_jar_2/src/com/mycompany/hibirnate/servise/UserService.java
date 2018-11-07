package com.mycompany.hibirnate.servise;

import com.mycompany.hibirnate.dao.MySQLDatabaseUser;
import com.mycompany.hibirnate.model.User;
import java.util.List;

public class UserService {
   
            
    public UserService() {

    }

    public String getUserRole(User user) {
        String role = user.getRole().getRoleId();
        return role;
    }

    public void saveUser(User user) {
        new MySQLDatabaseUser().insert(user);
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

}
