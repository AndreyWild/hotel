package com.senla.controller;

import com.senla.api.service.IGuestService;


import com.senla.controller.util.MyConfig;
import com.senla.model.entities.Guest;
import com.senla.service.impl.GuestService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Hotel {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);


        IGuestService guestService = context.getBean(GuestService.class);

//        GuestDao guestDao = context.getBean("guestDao", GuestDao.class);

        Guest guest = new Guest("Test", 25);
        guestService.save(guest);
//        guestDao.save(guest);




    }
}
