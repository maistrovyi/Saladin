package com.maystrovoy.service;

import com.maystrovoy.dao.QueueDAO;
import com.maystrovoy.factory.QueueFactory;
import com.maystrovoy.model.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MaterialDocumentService {

    @Autowired
    private QueueDAO materialDocumentDAO;

    @Qualifier("queueFactory")
    @Autowired
    private QueueFactory queueFactory;

    public void processMaterialDocument(String year, String document) {
        Queue queue = queueFactory.createInstance(year + "_" + document, "sapuser", QueueFactory.ObjectType.MATERIAL_DOCUMENT.getObjectTypeValue());
        materialDocumentDAO.addQueue(queue);
    }
}
