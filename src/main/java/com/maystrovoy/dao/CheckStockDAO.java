package com.maystrovoy.dao;

import com.maystrovoy.model.Queue;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckStockDAO {

    void putIntoQueue(String location, String material);

    void putIntoQueue(Queue queue);


}
