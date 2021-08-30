package com.senla.dao.impl;

import com.senla.api.dao.IGenericDao;
import com.senla.model.entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T extends AEntity> implements IGenericDao<T> {

    private Class<T> domainClass;
//    private SessionFactory sessionFactory = new Configuration()
//            .configure("hibernate.cfg.xml")
//            .buildSessionFactory();

    @Autowired
    private SessionFactory sessionFactory;

//    protected Session getSession() {
//        try {
//            return sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            return sessionFactory.openSession();
//        }
//    }
    @Override
    public T save(T entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public T getById(Long id) {
        return getCurrentSession().get(getGenericClass(), id);
    }

    @Override
    public List<T> getAll() {
        // Hiber realisation WORK!
//        getSession().beginTransaction();
//        List<T> list = getSession()
//                .createQuery("FROM " + getGenericClass().getSimpleName(), getGenericClass())
//                .getResultList();
//        getSession().getTransaction().commit();
//        return list;

        // HQL realisation WORK!
//        getSession().beginTransaction();
        return getCurrentSession().createQuery("from " + getGenericClass().getSimpleName(), getGenericClass()).list();

        // CriteriaQuery realisation WORK!
//        Session session = getSession();
//        session.beginTransaction();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<T> query = builder.createQuery(getGenericClass());
//        Root<T> root = query.from(getGenericClass());
//        query.select(root);
////        TypedQuery<T> result = session.createQuery(query);
////        return result.getResultList();
//        return getSession().createQuery(query).getResultList();
    }

    public List<T> findAll() {
        return getCurrentSession().createCriteria(getGenericClass()).list();
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        getCurrentSession().delete(getById(id));
    }

    @Override
    public void deleteAll() {
        getCurrentSession().createQuery("DELETE " + getGenericClass()).executeUpdate();
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    protected Class<T> getGenericClass() {
        if (domainClass == null) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class<T>) type.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
