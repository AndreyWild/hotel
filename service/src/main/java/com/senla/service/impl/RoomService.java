package com.senla.service.impl;

import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IRoomService;
import com.senla.dao.impl.RoomDao;
import com.senla.model.entities.Room;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    @Setter
    @Getter
    private IRoomDao roomDao;// = new RoomDao();

    @Override
    @Transactional
    public Room save(Room entity) {
        return roomDao.save(entity);
    }

    @Override
    @Transactional
    public Room getById(Long id) {
        return roomDao.getById(id);
    }

    @Override
    @Transactional
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Override
    @Transactional
    public void delete(Room entity) {
        roomDao.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        roomDao.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        roomDao.deleteAll();
    }

    @Override
    @Transactional
    public void update(Room entity) {
        roomDao.update(entity);
    }
}
