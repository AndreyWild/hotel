package com.senla.dao;

import com.senla.api.dao.IGuestDao;
import com.senla.model.entities.Guest;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDao extends AbstractDao<Guest> implements IGuestDao {

//    public GuestDao() {
//        System.out.println(">> Create GuestDao");
//    }

    @Override
    protected Class<Guest> getGenericClass() {
        return Guest.class;
    }
}

