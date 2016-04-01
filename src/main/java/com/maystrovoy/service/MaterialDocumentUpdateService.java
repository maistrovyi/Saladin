package com.maystrovoy.service;

import com.maystrovoy.dao.QueueDAO;
import com.maystrovoy.factory.QueueFactory;
import com.maystrovoy.model.Queue;
import com.maystrovoy.model.Sap_Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MaterialDocumentUpdateService {

    private static final Logger LOGGER = LogManager.getLogger(MaterialDocumentService.class);

    @Autowired
    private QueueDAO materialDocumentDAO;

    @Qualifier("queueFactory")
    @Autowired
    private QueueFactory queueFactory;

    public void processMaterialDocumentUpdate(String year, String document, String login) {
        LOGGER.info("Material Document query : " + year + "-" + document + " by user: "+ login);
        Sap_Log sapLog = queueFactory.createInstance(document);
        materialDocumentDAO.removeQueueFromSapLog(sapLog);
        Queue queue = queueFactory.createInstance(year + "_" + document, login, QueueFactory.ObjectType.MATERIAL_DOCUMENT.getObjectTypeValue());
        materialDocumentDAO.addQueue(queue);
    }
}
