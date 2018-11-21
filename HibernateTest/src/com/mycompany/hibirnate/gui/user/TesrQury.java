/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.gui.user;

import com.mycompany.hibirnate.gui.Authorization;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.model.User;
import com.mycompany.hibirnate.servise.RealtorService;
import com.mycompany.hibirnate.servise.UserService;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TesrQury {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        HibernateSessionFactoryUtill.getSessionFactory();   
        RealtorService realtorService = new RealtorService();
        UserService service = new UserService();
        City city = service.getCityByName("Новокузнецк");
        List<Realty> realtys = realtorService.getRealtyByTypeAndCity("Квартира", city);
        System.out.println(realtys.get(1).getEntryList());
    }
    
}
