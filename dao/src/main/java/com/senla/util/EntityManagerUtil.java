package com.senla.util;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    @Getter
    EntityManager entityManager;

    private EntityManagerUtil(){
        init();
    }

    private void init(){
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistence.xml");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void beginTransaction(){
        entityManager.getTransaction().begin();
    }

    public void commit(){
        entityManager.getTransaction().commit();
    }

    public void rollback(){
        entityManager.getTransaction().rollback();
    }
}
