package com.maystrovoy.factory;

public abstract class AbstractFactory {

    public abstract Object createInstance(String targetObject, String userName, int objectType);
}
