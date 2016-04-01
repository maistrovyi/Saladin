package com.maystrovoy.factory;

import com.maystrovoy.model.Queue;
import com.maystrovoy.model.Sap_Log;
import org.springframework.stereotype.Component;

@Component
public class QueueFactory extends AbstractFactory {

    public enum ObjectType {
        CHECK_STOCK(10),
        MATERIAL_DOCUMENT(6),
        MATERIAL(1);

        private int objectTypeValue;

        private ObjectType(int value) {
            this.objectTypeValue = value;
        }

        public int getObjectTypeValue() {
            return objectTypeValue;
        }
    }

    @Override
    public Queue createInstance(String targetObject, String userName, int objectType) {
        Queue queue = new Queue(targetObject, userName, objectType);
        return queue;
    }

    public Sap_Log createInstance(String targetObject) {
        Sap_Log sapLog = new Sap_Log(targetObject);
        return sapLog;
    }

}
