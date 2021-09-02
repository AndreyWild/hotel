package com.senla.configuration;

import com.mchange.v1.db.sql.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@ComponentScan(basePackages = {"com.senla.api", "com.senla.model.entities", "com.senla.service.impl", "com.senla.dao.impl"})
@Configuration
public class DaoJpaConfig {

    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/hotel?autoReconnect=true", "root", "root");
    }
}
