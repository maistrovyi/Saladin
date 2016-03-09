package com.maystrovoy.service;

import com.maystrovoy.dao.MaterialDAO;
import com.maystrovoy.factory.QueueFactory;
import com.maystrovoy.model.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    private MaterialDAO materialDAO;

    @Autowired
    private QueueFactory queueFactory;

    public void processMaterial(String material) {
        Queue queue = queueFactory.createInstance(material, "sapuser", QueueFactory.ObjectType.MATERIAL.getObjectTypeValue());
        materialDAO.addQueue(queue);
    }
}
