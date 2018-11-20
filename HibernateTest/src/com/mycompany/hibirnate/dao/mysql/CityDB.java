/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.dao.mysql;

import com.mycompany.hibirnate.dao.interfaces.CityDAO;
import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import org.hibernate.query.Query;

/**
 *
 * @author WSR
 */
public class CityDB extends AbstractObjectDao<City,Integer> implements CityDAO{

    private static final String CITY_OBJECT = "City";
    
    public CityDB() {
      super(CITY_OBJECT);
    }

     private static CityDB instance;

    public CityDB getInstance() {
        if (instance == null) {
            instance = new CityDB();
        }
        return instance;
    }
    
    @Override
    public City getCityByName(String name) {
        Query query = HibernateSessionFactoryUtill.getSessionFactory().openSession().createQuery("from City where cityname = :ParametrCity");
        query.setParameter("ParametrCity",name);
        City city = (City) query.uniqueResult();
        return city;
    }
    
    
    
}
