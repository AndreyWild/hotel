package com.senla.util;

import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Log4j
public class HibernateCfgUtil {

    private static final SessionFactory sessionFactory;

    static {

        try {
            sessionFactory = new Configuration()
                    .configure("/resources/hibernate.cfg.xml")
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
