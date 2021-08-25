package com.senla.service.impl;

import com.senla.api.service.IGuestService;
import com.senla.dao.impl.GuestDao;
import com.senla.model.entityes.Guest;

import java.util.List;

public class GuestService implements IGuestService {

    //@Autowired
    private final GuestDao guestDao = new GuestDao();

    public Guest save(Guest entity) {
        return guestDao.save(entity);
    }

    public Guest getById(Long id) {
        return guestDao.getById(id);
    }

    public List<Guest> getAll() {
        return guestDao.getAll();
    }

    public void delete(Guest entity) {
        guestDao.delete(entity);
    }

    public void deleteById(Long id) {
        guestDao.deleteById(id);
    }

    public void deleteAll() {
        guestDao.deleteAll();
    }

    public void update(Guest entity) {
        guestDao.update(entity);
    }

}
