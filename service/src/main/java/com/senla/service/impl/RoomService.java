package com.senla.service.impl;

import com.senla.api.service.IRoomService;
import com.senla.dao.impl.RoomDao;
import com.senla.model.entities.Room;

import java.util.List;

public class RoomService implements IRoomService {

    //@Autowired
    private final RoomDao roomDao = new RoomDao();

    public Room save(Room entity) {
        return roomDao.save(entity);
    }

    public Room getById(Long id) {
        return roomDao.getById(id);
    }

    public List<Room> getAll() {
        return roomDao.getAll();
    }

    public void delete(Room entity) {
        roomDao.delete(entity);
    }

    public void deleteById(Long id) {
        roomDao.deleteById(id);
    }

    public void deleteAll() {
        roomDao.deleteAll();
    }

    public void update(Room entity) {
        roomDao.update(entity);
    }
}
