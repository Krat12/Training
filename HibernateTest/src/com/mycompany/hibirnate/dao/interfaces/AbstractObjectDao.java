package com.mycompany.hibirnate.dao.interfaces;

import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractObjectDao<Entity, Key> implements ObjectDAO<Entity,Key> {

    private String entityName;

    public AbstractObjectDao(String entityName) {
        this.entityName = entityName;
    }

    public AbstractObjectDao() {

    }

    @Override
    public boolean insert(Entity model) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(model);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Exeption" + e);
            return false;
        } finally {
            session.close();
        }

        return true;
    }

    @Override
    public Entity getObjectByID(Key key, Class eClass) {

        return (Entity) HibernateSessionFactoryUtill.getSessionFactory().openSession().get(eClass, (Serializable) key);
    }

    @Override
    public List<Entity> getAllObject() {

        List<Entity> entitys = (List<Entity>) HibernateSessionFactoryUtill.getSessionFactory().openSession().createQuery("FROM " + entityName).list();

        return entitys;
    }

    @Override
    public boolean delete(Entity model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Entity model) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(model);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Exeption" + e);
            return false;
        } finally {
            session.close();
        }

        return true;
    }
    
    
    

}
