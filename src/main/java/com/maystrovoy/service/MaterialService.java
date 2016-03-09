package com.maystrovoy.service;

import com.maystrovoy.dao.MaterialDAO;
import com.maystrovoy.factory.QueueFactory;
import com.maystrovoy.model.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MaterialService {

    private final int numericItemLength = 18;

    @Autowired
    private MaterialDAO materialDAO;

    @Qualifier("queueFactory")
    @Autowired
    private QueueFactory queueFactory;

    public void processMaterial(String material) {
        String materialSap = optimizeMaterialValue(material);
        System.out.println("materialSap : " + materialSap);
        Queue queue = queueFactory.createInstance(materialSap, "sapuser", QueueFactory.ObjectType.MATERIAL.getObjectTypeValue());
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
        }
        else {
            optimizedValue = material;
        }
        return optimizedValue;
    }
}
