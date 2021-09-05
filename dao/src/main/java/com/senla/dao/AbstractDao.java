package com.senla.dao;

import com.senla.api.dao.IGenericDao;
import com.senla.model.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
//        CriteriaQuery<T> criteriaQuery = builder.createQuery(getGenericClass());
//        Root<T> root = criteriaQuery.from(getGenericClass());
//        criteriaQuery.select(root);
////        TypedQuery<T> result = session.createQuery(criteriaQuery);
////        return result.getResultList();
//        return getSession().createQuery(criteriaQuery).getResultList();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(getGenericClass());
        Root<T> root = criteriaQuery.from(getGenericClass());
        criteriaQuery.select(root);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<T> findAll() {

//        return getCurrentSession().createCriteria(getGenericClass()).list();
        return entityManager.createQuery("FROM " + getGenericClass().getSimpleName())
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
