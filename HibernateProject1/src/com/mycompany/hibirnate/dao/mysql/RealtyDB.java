package com.mycompany.hibirnate.dao.mysql;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.dao.interfaces.CityDAO;
import com.mycompany.hibirnate.dao.interfaces.RealtyDAO;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RealtyDB extends AbstractObjectDao<Realty, Integer> implements RealtyDAO {

    private static final String REALTY_OBJECT = "Realty";
    private CityDAO cityDAO = CityDB.getInstance();

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
    public List<Realty> getRealtyByTypeRealty(String type, String cityName) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        List<Realty> realtys = null;
        System.err.println(cityName);
        try {
            transaction = session.beginTransaction();
            boolean isFirst = true;
            StringBuilder query = new StringBuilder("from Realty ");

            if (!type.equals("Недвижимость")) {
                if (isFirst) {
                    query.append(" where typeRealty = '" + type + "'");
                } else {
                    query.append(" and typeRealty = '" + type + "'");
                }
                isFirst = false;
            }

            if (!cityName.equals("Город")) {
                 City city = cityDAO.getCityByName(cityName);
                if (isFirst) {
                    query.append(" where city = " + city.getCityid());
                } else {
                    query.append(" and city = " + city.getCityid());
                }
                isFirst = false;
            }
            
            System.out.println(query);
            Query result = session.createQuery(query.toString());
            realtys = result.list();

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Exeption" + e);
        }

        return realtys;
    }

}
