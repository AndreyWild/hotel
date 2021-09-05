package com.senla.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

//@ComponentScan("com.senla")
@Configuration
@PropertySource("classpath:application.properties")
public class DaoJpaConfig {

    @Value("${spring.database.url}")
    private String URL;
    @Value("${spring.database.username}")
    private String username;
    @Value("${spring.database.password}")
    private String password;
    @Value("${spring.database.driver}")
    private String driver;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;
    @Value("${hibernate.show_sql:false}")
    private String showSql;
    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.enable_lazy_load_on_trans}")
    private String hibernateLazyLoadNoTrans;
    @Value("${hibernate.temp.use._jdbc_metadata_defaults}")
    private String hibernateTempUseJdbcMetadataDefaults;

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(URL, username, password);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager =
                new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("com.senla.model.entities");

        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setJpaProperties(getJpaProperties());
        return entityManager;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//        return transactionManager;
//    }

    private Properties getJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.enable_lazy_load_no_trans", hibernateLazyLoadNoTrans);
        properties.setProperty("hibernate.temp.use._jdbc_metadata_defaults", hibernateTempUseJdbcMetadataDefaults);
        return properties;
    }
}
