package com.senla.api.service;

import com.senla.model.entities.AEntity;

import java.util.List;

public interface IGenericService<T extends AEntity> {

    T save(T entity);

    T getById(Long id);

    List<T> getAll();

    void delete(T entity);

    void deleteById(Long id);

    void deleteAll();

    void update(T entity);
}
