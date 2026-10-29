package com.rest.CLI;

import com.rest.models.Orderitem;
import com.rest.service.OrderitemService;
import java.util.List;
import java.util.Scanner;

public class OrderitemCLI {

    private final Scanner scanner;
    private final OrderitemService service;

    public OrderitemCLI(Scanner scanner, OrderitemService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== ORDER ITEM MANAGEMENT =====");
            System.out.println("1. View All Order Items");
            System.out.println("2. View Items by Order ID");
            System.out.println("3. Add Order Item");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    viewAllOrderItems();
                    break;
                case "2":
                    viewOrderItemsByOrderId();
                    break;
                case "3":
                    addOrderItem();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void viewAllOrderItems() {
        List<Orderitem> items = service.getAllOrderItems();
        System.out.println("\n===== ALL ORDER ITEMS =====");
        if (items.isEmpty()) {
            System.out.println("No order items found.");
            return;
        }

        for (Orderitem item : items) {
            System.out.println(item);
        }
    }

    private void viewOrderItemsByOrderId() {
        int orderId = readInt("Enter Order ID: ");
        List<Orderitem> items = service.getOrderItemsByOrderId(orderId);

        System.out.println("\n===== ITEMS FOR ORDER " + orderId + " =====");
        if (items.isEmpty()) {
            System.out.println("No items found for this order.");
            return;
        }

        for (Orderitem item : items) {
            System.out.println(item);
        }
    }

    private void addOrderItem() {
        int orderId = readInt("Enter Order ID: ");
        int menuItemId = readInt("Enter Menu Item ID: ");
        int quantity = readPositiveInt("Enter Quantity: ");
        double unitPrice = readNonNegativeDouble("Enter Unit Price: ");

        service.addOrderItem(new Orderitem(orderId, menuItemId, quantity, unitPrice));
        System.out.println("Order item added successfully.");
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Please enter a number greater than zero.");
        }
    }

    private double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine());
                if (Double.isFinite(value) && value >= 0) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Continue to the standard validation message below.
            }
            System.out.println("Please enter a valid non-negative price.");
        }
    }
}
