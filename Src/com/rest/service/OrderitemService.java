package com.rest.service;

import com.rest.models.Orderitem;
import com.rest.repository.OrderitemRepository;
import java.util.List;

public class OrderitemService {

    private final OrderitemRepository repository;

    public OrderitemService() {
        this.repository = new OrderitemRepository();
    }

    public void addOrderItem(Orderitem orderItem) {
        repository.addOrderItem(orderItem);
    }

    public List<Orderitem> getAllOrderItems() {
        return repository.findAll();
    }

    public List<Orderitem> getOrderItemsByOrderId(int orderId) {
        return repository.findByOrderId(orderId);
    }
}
