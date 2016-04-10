package com.maystrovoy.model;

import java.util.EnumSet;

public enum MenuType {

    HOME("/home", "HOME"),
    CHECK_STOCK("/check_stock", "CHECK STOCK"),
    MATERIAL_DOCUMENT("/material_document", "MATERIAL DOCUMENT"),
    MD_UPDATE("/update_material_document", "MD UPDATE"),
    MATERIAL("/simple_material", "MATERIAL"),
    ACTIVE_QUEUE("/active", "ACTIVE QUEUE"),
    PERSONS("/persons", "PERSONS"),
    SETTINGS("/settings", "SETTINGS");

    private String menuType;

    private String menuName;

    MenuType(String menuType, String name) {
        this.menuType = menuType;
        this.menuName = name;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }


    public static EnumSet<MenuType> filterTypes(String role) {
        EnumSet<MenuType> set = null;
        if (role.equals(PersonRoleType.ADMIN.getRoleType())) {
            set = EnumSet.allOf(MenuType.class);
        }
        if (role.equals(PersonRoleType.DEFAULT_USER.getRoleType())) {
            set = EnumSet.of(HOME);
        }
        if (role.equals(PersonRoleType.CONFIRMED_USER.getRoleType())) {
            set = EnumSet.allOf(MenuType.class);
            set.remove(PERSONS);
        }
        return set;
    }

}
