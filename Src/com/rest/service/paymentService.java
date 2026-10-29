package com.rest.service;

import com.rest.models.payment;
import com.rest.payment.PaymentMethod;
import com.rest.repository.paymentRepository;  
import java.util.List;

public class paymentService {

    private final paymentRepository repository;
    private int paymentIdCounter = 1; // Counter to generate unique payment IDs

    public paymentService() {
        this.repository = new paymentRepository();
    }

    public payment processPayment(int orderId, double amount, PaymentMethod method) {
        if (orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be greater than zero.");
        }
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }
        if (method == null) {
            throw new IllegalArgumentException("Payment method is required.");
        }

        method.pay(amount);

        payment payment = new payment(paymentIdCounter++, orderId, amount, method.getMethodName(),"Success");
         
        repository.save(payment);
        return payment;
    }
    public List<payment> getAllPayments() {
        return repository.findAll();
    }

    public payment getPaymentById(int id) {
        return repository.findById(id);
    }


}