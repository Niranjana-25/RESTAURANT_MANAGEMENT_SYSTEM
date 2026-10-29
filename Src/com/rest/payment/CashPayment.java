package com.rest.payment;

public class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        // Implement cash payment logic here
        System.out.printf("Processing cash payment of $%.2f%n", amount);
    }

    @Override
    public String getMethodName() {
        return "Cash Payment";
    }
}