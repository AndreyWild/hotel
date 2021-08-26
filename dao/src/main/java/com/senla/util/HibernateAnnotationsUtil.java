package com.senla.util;

import com.senla.model.entityes.Guest;
import com.senla.model.entityes.Maintenance;
import com.senla.model.entityes.Order;
import com.senla.model.entityes.Room;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@Log4j
public class HibernateAnnotationsUtil {

    private static final SessionFactory sessionFactory;

    static {

        try {
            sessionFactory = new AnnotationConfiguration()
                    .addPackage("com/senla/model/entityes")
                    .addAnnotatedClass(Guest.class)
                    .addAnnotatedClass(Room.class)
                    .addAnnotatedClass(Maintenance.class)
                    .addAnnotatedClass(Order.class)
                    .configure()
                    .buildSessionFactory();

        } catch (Throwable ex) {
            log.warn("Something else is wrong here");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        return sessionFactory;
    }
}
