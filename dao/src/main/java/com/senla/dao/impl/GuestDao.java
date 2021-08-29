package com.senla.dao.impl;

import com.senla.api.dao.IGuestDao;
import com.senla.model.entities.Guest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("guestDao")
public class GuestDao extends AbstractDao<Guest> implements IGuestDao {
}

