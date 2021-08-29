package com.senla.service.impl;

import com.senla.api.service.IRoomService;
import com.senla.dao.impl.RoomDao;
import com.senla.model.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roomService")
public class RoomService implements IRoomService {

    @Autowired
    private RoomDao roomDao;// = new RoomDao();

    @Autowired
    @Transactional
    public Room save(Room entity) {
        return roomDao.save(entity);
    }

    @Autowired
    @Transactional
    public Room getById(Long id) {
        return roomDao.getById(id);
    }

    @Autowired
    @Transactional
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Autowired
    @Transactional
    public void delete(Room entity) {
        roomDao.delete(entity);
    }

    @Autowired
    @Transactional
    public void deleteById(Long id) {
        roomDao.deleteById(id);
    }

    @Autowired
    @Transactional
    public void deleteAll() {
        roomDao.deleteAll();
    }

    @Autowired
    @Transactional
    public void update(Room entity) {
        roomDao.update(entity);
    }
}
