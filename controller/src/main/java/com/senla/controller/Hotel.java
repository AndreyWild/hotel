package com.senla.controller;

import com.senla.DaoConfig;
import com.senla.api.service.IGuestService;


import com.senla.controller.util.MyConfig;
import com.senla.dao.impl.GuestDao;
import com.senla.model.entities.Guest;
import com.senla.model.entities.Room;
import com.senla.service.impl.GuestService;

import com.senla.service.impl.RoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class Hotel {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DaoConfig.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        RoomService roomService = context.getBean(RoomService.class);

//        GuestDao guestDao = context.getBean(GuestDao.class);

        Room room = roomService.getById(1L);
        System.out.println(room);





    }
}
