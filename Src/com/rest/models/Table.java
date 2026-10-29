package com.rest.models;

public class Table {

    public enum Availability {
        FREE,
        OCCUPIED
    }

    private int id;
    private int capacity;
    private Availability status;

    public Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.status = Availability.FREE;
    }

    public int getid() {
        return id;
    }

    public int getcapacity() {
        return capacity;
    }

    public Availability getStatus() {
        return status;
    }

    public void freeTable() {
        this.status = Availability.FREE;
    }

    public void occupyTable() {
        this.status = Availability.OCCUPIED;
    }

    @Override
    public String toString() {
        return "Table ID: " + id
                + ", Capacity: " + capacity
                + ", Status: " + status;
    }
}
