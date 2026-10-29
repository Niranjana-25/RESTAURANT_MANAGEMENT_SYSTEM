package com.rest.payment;

public class UPIPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        // Implement UPI payment logic here
        System.out.printf("Processing UPI payment of $%.2f%n", amount);
    }

    @Override
    public String getMethodName() {
        return "UPI Payment";
    }
    
}
