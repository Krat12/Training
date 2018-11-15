/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.dao;

import com.mycompany.hibirnate.model.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserDAO {
    
    List<User> getUsersByName(String name);
    
    User getUserByLoginAndPassword(String email,String password);
    
}
