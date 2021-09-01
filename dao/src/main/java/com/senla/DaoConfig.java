package com.senla;

import com.mchange.v1.db.sql.DriverManagerDataSource;
import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IRoomDao;
import com.senla.dao.impl.GuestDao;
import com.senla.dao.impl.RoomDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@ComponentScan(basePackages = {"com.senla.api", "com.senla.model.entities", "com.senla.service.impl", "com.senla.dao.impl"})
@Configuration
@EnableTransactionManagement
public class DaoConfig {

    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/hotel?autoReconnect=true", "root", "root");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManager(){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("com.senla.model.entities");
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setJpaProperties(getJpaProperties());
        return entityManager;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    private Properties getJpaProperties(){
        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
/*        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("hibernate.current_session_context_class", "thread");*/
        properties.setProperty("hibernate.temp.use._jdbc_metadata_defaults", "false");
        return properties;

    }
}
