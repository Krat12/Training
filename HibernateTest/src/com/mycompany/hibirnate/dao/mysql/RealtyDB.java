package com.mycompany.hibirnate.dao.mysql;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.model.Realty;

public class RealtyDB extends AbstractObjectDao<Realty, Integer> {

    private static final String REALTY_OBJECT = "Realty";

    public RealtyDB() {
        super(REALTY_OBJECT);
    }

    private static RealtyDB instance;

    public RealtyDB getInstance() {
        if (instance == null) {
            instance = new RealtyDB();
        }
        return instance;
    }
}
