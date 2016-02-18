package com.maystrovoy.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class CheckStockDAOImpl implements CheckStockDAO {

    private JdbcTemplate jdbcTemplate;

    public CheckStockDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void putIntoQueue(String location, String material) {
        String sql = "INSERT INTO queue (location, material)" + " VALUES (?, ?)";
        jdbcTemplate.update(sql, location, material);
    }
}