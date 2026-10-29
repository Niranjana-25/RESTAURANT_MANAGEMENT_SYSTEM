package com.rest.CLI;

import com.rest.models.payment;
import com.rest.payment.CardPayment;
import com.rest.payment.CashPayment;
import com.rest.payment.PaymentMethod;
import com.rest.payment.UPIPayment;
import com.rest.service.paymentService;
import java.util.List;
import java.util.Scanner;

public class PaymentCLI {
    private final paymentService paymentService;
    private final Scanner scanner;

    public PaymentCLI(Scanner scanner, paymentService paymentService) {
        this.scanner = scanner;
        this.paymentService = paymentService;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== RESTAURANT PAYMENT SYSTEM ===");
            System.out.println("1. Process Payment");
            System.out.println("2. View All Payments");
            System.out.println("3. View Payment by ID");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            switch (scanner.nextLine().trim()) {
                case "1":
                    processPayment();
                    break;
                case "2":
                    viewAllPayments();
                    break;
                case "3":
                    viewPaymentById();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 0, 1, 2, or 3.");
            }
        }
    }

    private void processPayment() {
        int orderId = readPositiveInt("Enter Order ID: ");
        double amount = readPositiveAmount("Enter payment amount: ");
        PaymentMethod method = readPaymentMethod();

        payment payment = paymentService.processPayment(orderId, amount, method);
        System.out.println("Payment processed successfully.");
        System.out.println(payment);
    }

    private void viewAllPayments() {
        List<payment> payments = paymentService.getAllPayments();
        System.out.println("\n=== ALL PAYMENTS ===");
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        for (payment payment : payments) {
            System.out.println(payment);
        }
    }

    private void viewPaymentById() {
        int paymentId = readPositiveInt("Enter Payment ID: ");
        payment payment = paymentService.getPaymentById(paymentId);
        if (payment == null) {
            System.out.println("No payment found with ID " + paymentId + ".");
            return;
        }

        System.out.println(payment);
    }

    private PaymentMethod readPaymentMethod() {
        while (true) {
            System.out.println("Select payment method:");
            System.out.println("1. Cash");
            System.out.println("2. Card");
            System.out.println("3. UPI");
            System.out.print("Enter choice: ");

            switch (scanner.nextLine().trim()) {
                case "1":
                    return new CashPayment();
                case "2":
                    return new CardPayment();
                case "3":
                    return new UPIPayment();
                default:
                    System.out.println("Invalid payment method. Please choose 1, 2, or 3.");
            }
        }
    }

    private int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
                continue;
            }
            System.out.println("Please enter a number greater than zero.");
        }
    }

    private double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (Double.isFinite(amount) && amount > 0) {
                    return amount;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
                continue;
            }
            System.out.println("Please enter an amount greater than zero.");
        }
    }
}
