package com.mycompany.hibirnate.dao.mysql;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.dao.interfaces.RealtyDAO;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import java.util.List;
import org.hibernate.query.Query;


public class RealtyDB extends AbstractObjectDao<Realty, Integer> implements RealtyDAO{

    private static final String REALTY_OBJECT = "Realty";

    public RealtyDB() {
        super(REALTY_OBJECT);
    }

    private static RealtyDB instance;

    public static RealtyDB getInstance() {
        if (instance == null) {
            instance = new RealtyDB();
        }
        return instance;
    }

    @Override
    public List<Realty> getRealtyByTypeAndCity(String type, City city) {
        
        Query query = HibernateSessionFactoryUtill.getSessionFactory().openSession().createQuery("from Realty where city = :ParametrCity and typeRealty = :ParametrType");
        query.setParameter("ParametrCity", city);
        query.setParameter("ParametrType", type);
        List<Realty> realtys = query.list();
        return  realtys;
    }
}
