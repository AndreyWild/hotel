package com.senla.controller;

import com.senla.api.service.IGuestService;
import com.senla.model.entities.Guest;
import com.senla.service.GuestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@ComponentScan("com.senla") // откуда брать компоненты
public class Hotel {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        IGuestService guestService = context.getBean("guestService", IGuestService.class);
//        IGuestService guestService2 = context.getBean(GuestService.class);
//
        System.out.println(guestService);
//        System.out.println(guestService2);
//        System.out.println(guestService.equals(guestService2)); // true


        Guest guest = guestService.getById(1L);
        guest.setName("Test1");


        guestService.update(guest);

        Guest guest2 = guestService.getById(1L);
        System.out.println(guest2);

//        IGuestDao guestDao = context.getBean(GuestDao.class);

        Guest newGuest = new Guest("Bill", 25);
//        System.out.println("Добавляю гостя");
        guestService.save(newGuest);


//        guestDao.deleteById(10L);
//
        guestService.getAll().forEach(System.out::println);


        context.close();

    }
}
