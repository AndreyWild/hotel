package com.senla.api.dao;

import com.senla.model.entities.AEntity;

import java.util.List;

public interface IGenericDao<T extends AEntity> {

    void save(T entity);

    T getById(Long id);

    List<T> getAll();

    List<T> findAll();

    void delete(T entity);

    void deleteById(Long id);

    void update(T entity);
}
