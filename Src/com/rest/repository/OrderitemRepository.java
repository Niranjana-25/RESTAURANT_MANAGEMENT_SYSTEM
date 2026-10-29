package com.rest.repository;

import com.rest.models.Orderitem;
import java.util.ArrayList;
import java.util.List;

public class OrderitemRepository {

    private final List<Orderitem> orderItems = new ArrayList<>();

    public void addOrderItem(Orderitem orderItem) {
        orderItems.add(orderItem);
    }

    public List<Orderitem> findAll() {
        return orderItems;
    }

    public List<Orderitem> findByOrderId(int orderId) {
        List<Orderitem> matchingItems = new ArrayList<>();
        for (Orderitem orderItem : orderItems) {
            if (orderItem.getOrderId() == orderId) {
                matchingItems.add(orderItem);
            }
        }
        return matchingItems;
    }
}
