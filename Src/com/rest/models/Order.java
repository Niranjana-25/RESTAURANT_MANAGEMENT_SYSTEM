package com.rest.models;

import java.time.LocalDateTime;

public class Order {

    public enum Availability {
        ORDER,
        CANCEL
    }

    private final int id;
    private final int tableId;
    private Availability status;
    private final LocalDateTime createdAt;

    public Order(int id, int tableId) {
        this.id = id;
        this.tableId = tableId;
        this.status = Availability.ORDER;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public int getTableId() {
        return tableId;
    }

    public Availability getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}