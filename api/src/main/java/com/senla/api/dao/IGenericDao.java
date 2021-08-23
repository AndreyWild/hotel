package com.senla.api.dao;

import com.senla.model.entityes.AEntity;

import java.util.List;

public interface IGenericDao<T extends AEntity> {

    T save(T entity);

    T getById(Long id);

    List<T> getAll();

    void delete(T entity);

    void deleteById(Long id);

    void deleteAll();

    void update(T entity);

}
