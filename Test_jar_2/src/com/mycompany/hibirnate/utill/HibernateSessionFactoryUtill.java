package com.mycompany.hibirnate.utill;

import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realtor;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.model.Region;
import com.mycompany.hibirnate.model.Role;
import com.mycompany.hibirnate.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtill {

    private static SessionFactory sessionFactory;

    public HibernateSessionFactoryUtill() {
    }
    
    public static SessionFactory getSessionFactory() {
        
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Entry.class);
                configuration.addAnnotatedClass(Realty.class);
                configuration.addAnnotatedClass(Realtor.class);
                configuration.addAnnotatedClass(Region.class);
                configuration.addAnnotatedClass(City.class);
                
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }

        }
        return sessionFactory;
    }
    
    

}



