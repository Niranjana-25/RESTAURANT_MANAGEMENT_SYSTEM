package com.rest.repository;

import com.rest.models.menuitem;
import java.util.ArrayList;
import java.util.List;

public class menuitemRepository {

    private final List<menuitem> menuItems = new ArrayList<>();

    public void addMenuItem(menuitem item) {
        menuItems.add(item);
    }

    public List<menuitem> findAll() {
        return menuItems;
    }

    public menuitem findById(int id) {
        for (menuitem item : menuItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}