package com.senla.service.impl;

import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IRoomService;
import com.senla.model.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomService implements IRoomService {

    private IRoomDao roomDao;
//
//    @Autowired
//    public RoomService(IRoomDao roomDao) {
//        this.roomDao = roomDao;
//    }

    @Override
    public void save(Room entity) {
        roomDao.save(entity);
    }

    @Override
    public Room getById(Long id) {
        return roomDao.getById(id);
    }

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Override
    public void delete(Room entity) {
        roomDao.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        roomDao.deleteById(id);
    }

    @Override
    public void update(Room entity) {
        roomDao.update(entity);
    }
}
