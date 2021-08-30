package com.senla.controller.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.senla.api",
        "com.senla.model.entities",
        "com.senla.service.impl",
        "com.senla.dao.impl"}) // откуда брать компоненты
@EnableTransactionManagement
@PropertySource("/application.properties")
public class MyConfig {

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource(); // подключение к БД
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver"); // драйвер
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotel?autoReconnect=true");
            dataSource.setUser("root");
            dataSource.setPassword("root");

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("model.src.main.java.com.senla.model.entities");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.use_sql_comments", "true");
        hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
//        hibernateProperties.setProperty("hibernate.connection.pool_size", "3");

        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }
//
//    @Bean(name = "guestDao")
//    public IGuestDao guestDao() {
//        return new GuestDao();
//    }
//
//    @Bean(name = "roomDao")
//    public IRoomDao roomDao() {
//        return new RoomDao();
//    }
//
//    @Bean(name = "maintenanceDao")
//    public IMaintenanceDao maintenanceDao() {
//        return new MaintenanceDao();
//    }
//
//    @Bean(name = "orderDao")
//    public IOrderDao orderDao() {
//        return new OrderDao();
//    }
//
//    @Bean(name = "guestService")
//    public IGuestService guestService() {
//        IGuestService iGuestService = new GuestService();
//        iGuestService.setGuestDao(guestDao());
//        return iGuestService;
//    }
//
//    @Bean(name = "roomService")
//    public IRoomService roomService() {
//        IRoomService iRoomService = new RoomService();
//        iRoomService.setRoomDao(roomDao());
//        return iRoomService;
//    }
//
//    @Bean(name = "maintenanceService")
//    public IMaintenanceService maintenanceService() {
//        IMaintenanceService iMaintenanceService = new MaintenanceService();
//        iMaintenanceService.setMaintenanceDao(maintenanceDao());
//        return iMaintenanceService;
//    }
//
//    @Bean(name = "orderService")
//    public IOrderService orderService() {
//        IOrderService iOrderService = new OrderService();
//        iOrderService.setOrderDao(orderDao());
//        return iOrderService;
//    }

}
