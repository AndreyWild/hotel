package com.senla.controller.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com.senla.api", "com.senla.model.entities",
        "com.senla.service.impl", "com.senla.dao.impl", "com.senla.controller"}) // откуда брать компоненты
@Configuration
@EnableTransactionManagement
public class ControllerConfig {
}
