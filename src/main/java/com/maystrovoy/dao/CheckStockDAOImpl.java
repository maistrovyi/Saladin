package com.maystrovoy.dao;

import com.maystrovoy.model.Queue;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class CheckStockDAOImpl implements CheckStockDAO {

    Thread t;
    private JdbcTemplate jdbcTemplate;

    public CheckStockDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void putIntoQueue(final String location, String material) {
        final String finalMaterial = material;

//TODO        ThreadPoolExecutor executor = ThreadFactory
        if (t==null || !t.isAlive()) {
            t = new Thread(new Runnable() {
                public void run() {
                    putIntoQueue(new Queue(location, finalMaterial));
//                String sql = "INSERT INTO queue (location, material)" + " VALUES (?, ?)";
//                jdbcTemplate.update(sql, location, finalMaterial);
                }
            });
            t.setName("WRITING DB THREAD");
            t.start();
        }else{
            t.interrupt();
            System.out.println("Thread interruption");
        }


    }

    public void putIntoQueue(final Queue queue) {
        for (int i = 0; i < 1000; i++){
            String sql = "INSERT INTO queue (location, material)" + " VALUES (?, ?)";
            jdbcTemplate.update(sql, queue.getLocation(), queue.getMaterial());
        }

    }
}
