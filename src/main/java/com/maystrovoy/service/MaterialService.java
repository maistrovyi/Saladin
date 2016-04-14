package com.maystrovoy.service;

import com.maystrovoy.dao.QueueDAO;
import com.maystrovoy.factory.QueueFactory;
import com.maystrovoy.model.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MaterialService {

    private static final Logger LOGGER = LogManager.getLogger(MaterialService.class);

    private final int numericItemLength = 18;

    @Autowired
    private QueueDAO materialDAO;

    @Qualifier("queueFactory")
    @Autowired
    private QueueFactory queueFactory;

    public void processMaterial(String material, String login) {
        String materialSap = optimizeMaterialValue(material);
        LOGGER.info("Material query : " + materialSap + " by user: " + login);
        Queue queue = queueFactory.createInstance(materialSap, login,
                QueueFactory.ObjectType.MATERIAL.getObjectTypeValue());
        materialDAO.addQueue(queue);
    }

    public String optimizeMaterialValue(String material) {
        String optimizedValue = null;

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(material);
        if (m.matches()) {
            int length = numericItemLength - material.length();
            for (int i = 0; i < length; i++) {
                material = "0" + material;
            }
            optimizedValue = material;
        } else {
            optimizedValue = material;
        }
        return optimizedValue;
    }

}
