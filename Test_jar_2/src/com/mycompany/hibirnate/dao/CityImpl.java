/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.dao;

import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;

/**
 *
 * @author WSR
 */
public class CityImpl extends AbstractObjectDao<Realty, Integer> implements CityDAO{

    public CityImpl() {
      super("Realty");
    }

    @Override
    public City getCityByName(String name) {
        Query query = HibernateSessionFactoryUtill.getSessionFactory().openSession().createQuery("from City where cityname = :ParametrCity");
        query.setParameter("ParametrCity",name);
        City city = (City) query.uniqueResult();
        return city;
    }
    
    
    
}
