package com.senla.dao.impl;

import com.senla.api.dao.IRoomDao;
import com.senla.model.entities.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao extends AbstractDao<Room> implements IRoomDao {
    @Override
    protected Class<Room> getGenericClass() {
        return Room.class;
    }
}
