package com.mycompany.hibirnate.dao.mysql;

import com.mycompany.hibirnate.dao.interfaces.UserDAO;
import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.model.User;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDB extends AbstractObjectDao<User, String> implements UserDAO {

    private static final String USER_OBJECT = "User";

    public UserDB() {
        super(USER_OBJECT);
    }

    private static UserDB instance;

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
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
        Session session = HibernateSessionFactoryUtill.getSessionFactory().getCurrentSession();
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from User where email = :emailParametr and password = :passwordParametr");
            query.setParameter("emailParametr", email);
            query.setParameter("passwordParametr", password);
            user = (User) query.uniqueResult();
            if (user != null) {
                Hibernate.initialize(user.getRole());
            }
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Ошибка" + e);
        }

        return user;
    }

}
