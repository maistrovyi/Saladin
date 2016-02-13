package com.maystrovoy.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class CheckStockDAOImpl implements CheckStockDAO {

    Thread threadInsertingData;

    private JdbcTemplate jdbcTemplate;

    public CheckStockDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void putIntoQueue(final String location, String material) {
        final String finalMaterial = material;
        final String finalLocation = location;

        if (threadInsertingData == null || !threadInsertingData.isAlive()) {
            threadInsertingData = new Thread(new Runnable() {
                public void run() {
                    String sql = "INSERT INTO queue (location, material)" + " VALUES (?, ?)";
                    jdbcTemplate.update(sql, finalLocation, finalMaterial);
                }
            });
            threadInsertingData.setName("WRITING DB THREAD");
            threadInsertingData.start();
        } else {
            threadInsertingData.interrupt();
            System.out.println("Thread interruption");
        }


    }

//    public void putIntoQueue(final Queue queue) {
//        String sql = "INSERT INTO queue (location, material)" + " VALUES (?, ?)";
//        jdbcTemplate.update(sql, queue.getLocation(), queue.getMaterial());
//    }
}