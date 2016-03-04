package com.maystrovoy.service;

import com.maystrovoy.dao.CheckStockDAO;
import com.maystrovoy.factory.QueueFactory;
import com.maystrovoy.model.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CheckStockService {

    @Autowired
    private CheckStockDAO checkStockDAO;

    @Autowired
    private QueueFactory queueFactory;

    public void processCheckStock(String location, String material) {
        Queue queue = queueFactory.createInstance(location + "-" + material, "sapuser", QueueFactory.ObjectType.CHECK_STOCK.getObjectTypeValue());
        checkStockDAO.addQueue(queue);
    }

}
