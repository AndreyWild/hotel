package com.senla.dao.impl;

import com.senla.api.dao.IGenericDao;
import com.senla.model.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractDao<T extends AEntity> implements IGenericDao<T> {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;


    private Class<T> domainClass;
//    private SessionFactory sessionFactory = new Configuration()
//            .configure("hibernate.cfg.xml")
//            .buildSessionFactory();

    @Override
    public void save(T entity) {
//        getCurrentSession().saveOrUpdate(entity);
//        return entity;
        entityManager.persist(entity);
    }

    @Override
    public T getById(Long id) {
//        return getCurrentSession().get(getGenericClass(), id);
        return entityManager.find(getGenericClass(), id);
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
//        return getCurrentSession().createQuery("from " + getGenericClass().getSimpleName(), getGenericClass()).list();

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

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getGenericClass());
        return entityManager.createQuery(query).getResultList();

    }

    public List<T> findAll() {

//        return getCurrentSession().createCriteria(getGenericClass()).list();
        return entityManager.createQuery("from " + domainClass.getName())
                .getResultList();
    }

    @Override
    public void delete(T entity) {
//        getCurrentSession().delete(entity);
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(Long id) {
//        getCurrentSession().delete(getById(id));
        entityManager.remove(getById(id));
    }


    @Override
    public void update(T entity) {
//        getCurrentSession().update(entity);
        entityManager.merge(entity);
    }

//    protected Class<T> getGenericClass() {
//        if (domainClass == null) {
//            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
//            domainClass = (Class<T>) type.getActualTypeArguments()[0];
//        }
//        return domainClass;
//    }

//    protected Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
//    }

    protected abstract Class<T> getGenericClass();
}
