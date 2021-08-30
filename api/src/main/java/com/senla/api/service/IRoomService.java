package com.senla.api.service;

import com.senla.api.dao.IRoomDao;
import com.senla.model.entities.Room;

public interface IRoomService extends IGenericService<Room>{

    void setRoomDao(IRoomDao roomDao);
}
