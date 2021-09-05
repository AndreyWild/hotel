package com.senla.controller;

import com.senla.api.service.IGuestService;
import com.senla.configuration.DaoJpaConfig;
import com.senla.model.entities.Guest;
import com.senla.service.GuestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.senla") // откуда брать компоненты
public class Hotel {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DaoJpaConfig.class);

        IGuestService guestService = context.getBean(GuestService.class);

        Guest guest = guestService.getById(1L);
        System.out.println(guest);

        guestService.getAll().forEach(System.out::println);


    }
}
