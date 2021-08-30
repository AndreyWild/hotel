package com.senla;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IRoomDao;
import com.senla.dao.impl.GuestDao;
import com.senla.dao.impl.RoomDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    IGuestDao guestdao() {
        IGuestDao guestdao = new GuestDao();
        return guestdao;
    }

    @Bean
    IRoomDao roomDao(){
        IRoomDao roomDao = new RoomDao();
        return roomDao;

    }
}
