package com.senla.api.service;

import com.senla.api.dao.IGuestDao;
import com.senla.model.entities.Guest;

public interface IGuestService extends IGenericService<Guest> {

    void setGuestDao(IGuestDao guestDao);
}
