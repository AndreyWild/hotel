package com.senla.util;

import com.senla.model.entities.Guest;
import com.senla.model.entities.Maintenance;
import com.senla.model.entities.Order;
import com.senla.model.entities.Room;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@Log4j
public class HibernateAnnotationsUtil {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new AnnotationConfiguration()
                .addPackage("com/senla/model/entities")
                .addAnnotatedClass(Guest.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Maintenance.class)
                .addAnnotatedClass(Order.class)
                .configure()
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        return sessionFactory;
    }
}
