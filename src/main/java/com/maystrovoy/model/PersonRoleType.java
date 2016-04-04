package com.maystrovoy.model;

import java.util.ArrayList;
import java.util.EnumSet;

public enum PersonRoleType {

    DEFAULT_USER("read"),
    CONFIRMED_USER("write"),
    ADMIN("admin");

    private String roleType;

    PersonRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }

    public static PersonRoleType getNameByCode(String code) {
        for (int i = 0; i < PersonRoleType.values().length; i++) {
            if (code.equals(PersonRoleType.values()[i].roleType))
                return PersonRoleType.values()[i];
        }
        return null;
    }

    public static ArrayList<String> filterTypes(String role) {
        PersonRoleType type = PersonRoleType.getNameByCode(role);
        EnumSet<PersonRoleType> set = EnumSet.allOf(PersonRoleType.class);
        set.remove(type);
        ArrayList<String> arrayList = new ArrayList<String>();
        for (PersonRoleType roleType : set) {
            arrayList.add(roleType.getRoleType());
        }
        return arrayList;
    }
}
