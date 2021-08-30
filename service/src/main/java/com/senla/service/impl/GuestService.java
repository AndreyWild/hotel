package com.senla.service.impl;

import com.senla.api.dao.IGuestDao;
import com.senla.api.service.IGuestService;
import com.senla.dao.impl.GuestDao;
import com.senla.model.entities.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuestService implements IGuestService {

    @Autowired(required = false)
    private IGuestDao guestDao;

    public GuestService() {
        System.out.println("Create GuestService");
    }

    @Override
    public Guest save(Guest entity) {
        return guestDao.save(entity);
    }

    @Override
    public Guest getById(Long id) {
        return guestDao.getById(id);
    }

    @Override
    public List<Guest> getAll() {
        return guestDao.getAll();
    }

    @Override
    public void delete(Guest entity) {
        guestDao.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        guestDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        guestDao.deleteAll();
    }

    @Override
    public void update(Guest entity) {
        guestDao.update(entity);
    }
}
