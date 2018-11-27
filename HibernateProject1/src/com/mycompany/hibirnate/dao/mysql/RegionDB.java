package com.mycompany.hibirnate.dao.mysql;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.model.Region;




public class RegionDB extends AbstractObjectDao<Region, Integer> {

    public RegionDB() {
        super("Region");
    }


    
}
