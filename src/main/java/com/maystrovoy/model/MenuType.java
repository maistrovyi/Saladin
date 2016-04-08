package com.maystrovoy.model;

import java.util.ArrayList;
import java.util.EnumSet;

public enum MenuType {

    HOME("/home"),
    CHECK_STOCK("/check_stock"),
    MATERIAL_DOCUMENT("/material_document"),
    MD_UPDATE("/update_material_document"),
    MATERIAL("/simple_material"),
    ACTIVE_QUEUE("/active"),
    PERSONS("/persons"),
    SETTINGS("/settings");

    private String menuType;

    MenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuType() {
        return menuType;
    }

    public static MenuType getMenuItemByPersonRole(String code) {
        for (int i = 0; i < MenuType.values().length; i++) {
            if (code.equals(MenuType.values()[i].menuType))
                return MenuType.values()[i];
        }
        return null;
    }

    public static ArrayList<String> filterTypes(String role) {
        MenuType type = MenuType.getMenuItemByPersonRole(role);
        EnumSet<MenuType> set = EnumSet.allOf(MenuType.class);
        set.remove(type);
        ArrayList<String> arrayList = new ArrayList<String>();
        if (role.equals(PersonRoleType.ADMIN.getRoleType())) {
            for (MenuType menuType : set) {
                arrayList.add(menuType.getMenuType());
            }
        }
        if (role.equals(PersonRoleType.DEFAULT_USER.getRoleType())) {
            for (MenuType menuType : set) {
                arrayList.add(menuType.getMenuType());
                arrayList.remove(CHECK_STOCK.getMenuType());
                arrayList.remove(MATERIAL_DOCUMENT.getMenuType());
                arrayList.remove(MD_UPDATE.getMenuType());
                arrayList.remove(MATERIAL.getMenuType());
                arrayList.remove(ACTIVE_QUEUE.getMenuType());
                arrayList.remove(PERSONS.getMenuType());
                arrayList.remove(SETTINGS.getMenuType());
            }
        }
        if (role.equals(PersonRoleType.CONFIRMED_USER.getRoleType())) {
            for (MenuType menuType : set) {
                arrayList.add(menuType.getMenuType());
                arrayList.remove(PERSONS.getMenuType());
            }
        }
        return arrayList;
    }

}
