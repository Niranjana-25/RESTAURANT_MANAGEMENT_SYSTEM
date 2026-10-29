package com.rest.payment;

public class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        // Implement card payment logic here
        System.out.printf("Processing card payment of $%.2f%n", amount);
    }

    @Override
    public String getMethodName() {
        return "Card Payment";
    }
    
}
