package com.maystrovoy.model;

public enum PersonRoleType {

    DEFAULT_USER("read"),
    CONFIRMED_USER("write"),
    ADMIN("admin");

    private String roleType;

    private PersonRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }
}
