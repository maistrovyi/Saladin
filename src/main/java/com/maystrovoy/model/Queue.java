package com.maystrovoy.model;

public class Queue {

    private String location;

    private String material;

    public Queue(String location, String material) {
        this.location = location;
        this.material = material;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
