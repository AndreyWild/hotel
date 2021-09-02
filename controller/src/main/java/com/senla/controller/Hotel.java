package com.senla.controller;

import com.senla.api.service.IGuestService;
import com.senla.controller.configuration.ControllerConfig;
import com.senla.model.entities.Guest;
import com.senla.model.entities.Room;
import com.senla.service.GuestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Hotel {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ControllerConfig.class);


        IGuestService guestService = context.getBean(GuestService.class);

//        Room room = context.getBean(Room.class);
//        System.out.println(room);



//        GuestDao guestDao = context.getBean(GuestDao.class);

//
//        IMaintenanceService maintenanceService = context.getBean(MaintenanceService.class);

//        Guest guest = guestService.getById(1L);
//        System.out.println(guest);

        guestService.findAll().forEach(System.out::println);


    }
}
