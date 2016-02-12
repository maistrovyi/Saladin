package com.maystrovoy.service;

import com.maystrovoy.dao.CheckStockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckStockService {
    @Autowired
    private CheckStockDAO checkStockDAO;

    public void processCheckStock(String location, String material) {
        checkStockDAO.putIntoQueue(location, material);
//        checkStockDAO.putIntoQueue(new Queue(location, material));
    }
}
