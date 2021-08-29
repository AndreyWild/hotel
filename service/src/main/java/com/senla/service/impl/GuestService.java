package com.senla.service.impl;

import com.senla.api.service.IGuestService;
import com.senla.dao.impl.GuestDao;
import com.senla.model.entities.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("guestService")
public class GuestService implements IGuestService {

    @Autowired
    private GuestDao guestDao; // = new GuestDao();

    @Autowired
    @Transactional
    public Guest save(Guest entity) {
        return guestDao.save(entity);
    }

    @Autowired
    @Transactional
    public Guest getById(Long id) {
        return guestDao.getById(id);
    }

    @Autowired
    @Transactional
    public List<Guest> getAll() {
        return guestDao.getAll();
    }

    @Autowired
    @Transactional
    public void delete(Guest entity) {
        guestDao.delete(entity);
    }

    @Autowired
    @Transactional
    public void deleteById(Long id) {
        guestDao.deleteById(id);
    }

    @Autowired
    @Transactional
    public void deleteAll() {
        guestDao.deleteAll();
    }

    @Autowired
    @Transactional
    public void update(Guest entity) {
        guestDao.update(entity);
    }

}
