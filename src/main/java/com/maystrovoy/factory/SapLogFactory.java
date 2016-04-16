package com.maystrovoy.factory;

import com.maystrovoy.model.SapLog;
import org.springframework.stereotype.Component;

@Component
public class SapLogFactory extends AbstractFactory {

    @Override
    public Object createInstance(String targetObject, String userName, int objectType) {
        return null;
    }

    @Override
    public SapLog createInstance(String targetObject) {
        SapLog sapLog = new SapLog(targetObject);
        return sapLog;
    }

}
