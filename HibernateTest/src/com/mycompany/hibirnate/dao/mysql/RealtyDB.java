package com.mycompany.hibirnate.dao.mysql;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.dao.interfaces.RealtyDAO;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RealtyDB extends AbstractObjectDao<Realty, Integer> implements RealtyDAO {

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
    public List<Realty> getRealtyByTypeRealty(String type) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        List<Realty> realtys = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Realty where typeRealty = :ParametrType");
            query.setParameter("ParametrType", type);
            realtys = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Exeption" + e);
        }

        return realtys;
    }

}
