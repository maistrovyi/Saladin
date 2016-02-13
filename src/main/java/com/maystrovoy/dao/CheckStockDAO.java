package com.maystrovoy.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface CheckStockDAO {

    void putIntoQueue(String location, String material);

//    void putIntoQueue(Queue queue);
}
