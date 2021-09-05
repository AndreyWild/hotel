package com.senla.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ComponentScan({"com.senla.dao", "com.senla.service", "com.senla.dao", "com.senla.controller"})
@ComponentScan("com.senla")
@EnableTransactionManagement
public class ContextConfiguration {
}
