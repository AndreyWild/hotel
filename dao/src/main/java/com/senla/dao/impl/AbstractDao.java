package com.senla.dao.impl;

import com.senla.api.dao.IGenericDao;
import com.senla.model.entityes.*;
import lombok.extern.log4j.Log4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Log4j
public abstract class AbstractDao<T extends AEntity> implements IGenericDao<T> {

    private Class<T> domainClass;

    File file = new File("C:/Users/Andrey/Desktop/SENLA_JavaEE/hotel/dao/src/main/java/hibernate.cfg.xml");
    private SessionFactory sessionFactory = new Configuration().configure(file)
//            .addAnnotatedClass(Guest.class)
//            .addAnnotatedClass(Room.class)
//            .addAnnotatedClass(Maintenance.class)
//            .addAnnotatedClass(Order.class)
            .buildSessionFactory();

    protected Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return sessionFactory.openSession();
        }
    }

    @Override
    public T save(T entity) {
        getSession().beginTransaction();
        getSession().save(entity);
        getSession().getTransaction().commit();
        System.out.println(entity.getClass().getSimpleName() + " Create!");
        return entity;
    }

    @Override
    public T getById(Long id) {
        getSession().beginTransaction();
        T entity = getSession().get(getGenericClass(), id);
        getSession().getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> getAll() {
        // todo version 1 WORK!
        getSession().beginTransaction();
        List<T> list = getSession()
                .createQuery("FROM " + getGenericClass().getSimpleName(), getGenericClass())
                .getResultList();
        getSession().getTransaction().commit();
        return list;

        // todo version 2 not work
//        getSession().beginTransaction();
//        return getSession().createQuery("from " + getGenericClass()).list();

        // todo version 3 WORK!
//        Session session = getSession();
//        session.beginTransaction();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<T> query = builder.createQuery(getGenericClass());
//        Root<T> root = query.from(getGenericClass());
//        query.select(root);
//        TypedQuery<T> result = session.createQuery(query);
//        return result.getResultList();
    }

    @Override
    public void delete(T entity) {
        getSession().beginTransaction();
        getSession().delete(entity);
        getSession().getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) {
        getSession().beginTransaction();
        getSession().delete(getById(id));
        getSession().getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        getSession().beginTransaction();
        getSession().createQuery("DELETE " + getGenericClass()).executeUpdate();
        getSession().getTransaction().commit();
    }


    @Override
    public void update(T entity) {
        getSession().beginTransaction();
        getSession().update(entity);
        getSession().getTransaction().commit();
    }

    protected Class<T> getGenericClass() {
        if (domainClass == null) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class<T>) type.getActualTypeArguments()[0];
        }
        return domainClass;
    }

}
