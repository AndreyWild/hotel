package com.senla.dao.impl;

import com.senla.api.dao.IRoomDao;
import com.senla.model.entities.Room;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("roomDao")
public class RoomDao extends AbstractDao<Room> implements IRoomDao {
}
