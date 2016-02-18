package com.maystrovoy.config;

import com.maystrovoy.dao.CheckStockDAO;
import com.maystrovoy.dao.CheckStockDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ApplicationConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/XE");
        dataSource.setUsername("maystrovoy");
        dataSource.setPassword("admin");

        return dataSource;
    }

//    @Bean
//    public DriverManagerDataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        dataSource.setUrl("10.1.32.39:1521:MAXIMO2T");
//        dataSource.setUsername("MXSAP");
//        dataSource.setPassword("INTEGRATION");
//
//        return dataSource;
//    }

    @Bean
    public CheckStockDAO getCheckStockDAO() {

        return new CheckStockDAOImpl(dataSource());
    }

}
