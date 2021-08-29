package com.senla.service.impl;

import com.senla.api.service.IGuestService;
import com.senla.dao.impl.GuestDao;
import com.senla.model.entities.Guest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
public class GuestService implements IGuestService {

    private GuestDao guestDao; // = new GuestDao();

    @Autowired
    public GuestService(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Override
    @Transactional
    public Guest save(Guest entity) {
        return guestDao.save(entity);
    }

    @Override
    @Transactional
    public Guest getById(Long id) {
        return guestDao.getById(id);
    }

    @Override
    @Transactional
    public List<Guest> getAll() {
        return guestDao.getAll();
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
    public void deleteAll() {
        guestDao.deleteAll();
    }

    @Override
    @Transactional
    public void update(Guest entity) {
        guestDao.update(entity);
    }

}
