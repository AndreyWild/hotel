package com.senla.service;

import com.senla.api.dao.IGuestDao;
import com.senla.api.service.IGuestService;
import com.senla.model.entities.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuestService implements IGuestService {

    @Autowired
    private IGuestDao guestDao;

    @Override
    @Transactional
    public void save(Guest entity) {
        guestDao.save(entity);
    }

    @Override
    @Transactional
    public Guest getById(Long id) {
        System.out.println(">> Start method getById() in GuestService.class <<");
        return guestDao.getById(id);
    }

    @Override
    @Transactional
    public List<Guest> getAll() {
        return guestDao.getAll();
    }

    @Override
    @Transactional
    public List<Guest> findAll() {
        return guestDao.findAll();
    }

    @Override
    @Transactional
    public void delete(Guest entity) {
        guestDao.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        guestDao.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Guest entity) {
        guestDao.update(entity);
    }
}
