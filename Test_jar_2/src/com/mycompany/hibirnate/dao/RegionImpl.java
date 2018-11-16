package com.mycompany.hibirnate.dao;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.model.Region;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import org.hibernate.query.Query;



public class RegionImpl extends AbstractObjectDao<Region, Integer> {

    public RegionImpl() {
        super("Region");
    }


    
}
