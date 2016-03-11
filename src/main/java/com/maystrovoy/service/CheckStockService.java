package com.maystrovoy.service;

import com.maystrovoy.dao.QueueDAO;
import com.maystrovoy.factory.QueueFactory;
import com.maystrovoy.model.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CheckStockService {

    @Autowired
    private QueueDAO checkStockDAO;

    @Qualifier("queueFactory")
    @Autowired
    private QueueFactory queueFactory;

    @Inject
    private MaterialService materialService;

    public void processCheckStock(String location, String material, String login) {
        String materialSap = materialService.optimizeMaterialValue(material);
        System.out.println("check_stockSap : " + location + "-" + materialSap);
        Queue queue = queueFactory.createInstance(location + "-" + materialSap, login, QueueFactory.ObjectType.CHECK_STOCK.getObjectTypeValue());
        checkStockDAO.addQueue(queue);
    }

}
