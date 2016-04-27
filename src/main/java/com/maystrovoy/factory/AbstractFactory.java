package com.maystrovoy.factory;

import com.maystrovoy.model.SapLog;

public abstract class AbstractFactory {

    public abstract Object createInstance(String targetObject, String userName, int objectType);

    public abstract SapLog createInstance(String targetObject);

}
