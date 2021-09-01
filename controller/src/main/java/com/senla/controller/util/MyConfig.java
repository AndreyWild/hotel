package com.senla.controller.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;




//@PropertySource("/application.properties")
//@ComponentScan(basePackages = {"com.senla.api", "com.senla.model.entities", "com.senla.service.impl", "com.senla.dao.impl"}) // откуда брать компоненты
//@Configuration
//@EnableTransactionManagement
public class MyConfig {

//    @Bean
//    public DataSource dataSource() {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource(); // подключение к БД
//        try {
//            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver"); // драйвер
//            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotel?autoReconnect=true");
//            dataSource.setUser("root");
//            dataSource.setPassword("root");
//
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.senla.model.entities");
//
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        hibernateProperties.setProperty("hibernate.show_sql", "true");
//        hibernateProperties.setProperty("hibernate.use_sql_comments", "true");
//        hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
//        hibernateProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
////        hibernateProperties.setProperty("hibernate.connection.pool_size", "3");
//
//        sessionFactory.setHibernateProperties(hibernateProperties);
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager transactionManager() {
//        HibernateTransactionManager transactionManager =
//                new HibernateTransactionManager();
//
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//
//        return transactionManager;
//    }

//    @Bean
//    public PlatformTransactionManager transactionManager(){
//        JpaTransactionManager transactionManager
//                = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                entityManagerFactoryBean().getObject() );
//
//        return transactionManager;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }



//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.senla.api", "com.senla.model.entities", "com.senla.service.impl", "com.senla.dao.impl" );
//        sessionFactory.setHibernateProperties(hibernateProperties());
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:hotel;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager
//                = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }
//
//    private final Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty(
//                "hibernate.hbm2ddl.auto", "create-drop");
//        hibernateProperties.setProperty(
//                "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//        return hibernateProperties;
//    }


}
