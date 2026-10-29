package com.rest.models;

public class payment {
    private final int paymentId;
    private final int orderId;
    private final double amount;
    private final String paymentMethod;
    private final String status;

    public payment(int paymentId, int orderId, double amount, String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }
@Override
    public String toString() {
        return "Payment ID: " + paymentId
                + ", Order ID: " + orderId
                + ", Amount: " + amount
                + ", Payment Method: " + paymentMethod
                + ", Status: " + status;
    }

}
