package com.rest.repository;

import com.rest.models.payment;
import java.util.ArrayList;
import java.util.List;

public class paymentRepository {
    private final List<payment> payments= new ArrayList<>();

    public void save(payment payment) {
        payments.add(payment);
    }
    public List<payment> findAll() {
        return new ArrayList<>(payments);
    }

    public payment findById(int paymentId) {
        for (payment payment : payments) {
            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }
        return null; // Return null if not found
    }
}
