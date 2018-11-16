package com.mycompany.hibirnate.dao;

import com.mycompany.hibirnate.dao.interfaces.UserDAO;
import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.model.User;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MySQLDatabaseUser extends AbstractObjectDao<User, String> implements UserDAO {

    public MySQLDatabaseUser() {
        super("User");
    }

    @Override
    public List<User> getUsersByName(String name) {
        Query query = HibernateSessionFactoryUtill.getSessionFactory().openSession().createQuery("from User where firstName = :nameParametr");
        query.setParameter("nameParametr", name);
        List<User> users = query.list();

        return users;
    }

    @Override
    public User getUserByLoginAndPassword(String email, String password) {
        User user = null;
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        try {

            Query query = session.createQuery("from User where email = :emailParametr and password = :passwordParametr");
            query.setParameter("emailParametr", email);
            query.setParameter("passwordParametr", password);
            user = (User) query.uniqueResult();
            if (user != null){
            Hibernate.initialize(user.getRole());
            }
        } finally {
            session.close();
        }

        return user;
    }

}
