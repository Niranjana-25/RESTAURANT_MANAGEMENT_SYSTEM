package com.rest.service;

import com.rest.models.menuitem;
import com.rest.repository.menuitemRepository;
import java.util.List;

public class menuitemService {

    private final menuitemRepository repository;

    public menuitemService() {
        this.repository = new menuitemRepository();
    }

    public void addMenuItem(menuitem item) {
        repository.addMenuItem(item);
    }

    public List<menuitem> getAllMenuItems() {
        return repository.findAll();
    }

    public menuitem getMenuItemById(int id) {
        return repository.findById(id);
    }
}