package com.maystrovoy.factory;

import com.maystrovoy.model.Queue;
import org.springframework.stereotype.Component;

@Component
public class QueueFactory extends AbstractFactory {

    public enum ObjectType {
        CHECK_STOCK(10);

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

}
