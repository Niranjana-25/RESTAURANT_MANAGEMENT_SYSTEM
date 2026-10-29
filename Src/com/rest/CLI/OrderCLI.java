package com.rest.CLI;

import com.rest.models.Order;
import com.rest.service.OrderService;
import java.util.Scanner;

public class OrderCLI {

    private final Scanner scanner;
    private final OrderService orderService;

    public OrderCLI(Scanner scanner, OrderService orderService) {
        this.scanner = scanner;
        this.orderService = orderService;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== ORDER MANAGEMENT =====");
            System.out.println("1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    placeOrder();
                    break;

                case 2:
                    viewOrders();
                    break;

                case 3:
                    System.out.println("Returning to Main Menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void placeOrder() {
        System.out.print("Enter Table ID: ");
        int tableId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Order order = new Order(100, tableId);
        // You can add itemName and quantity later if you expand the Order model
        orderService.placeOrder(order);

        System.out.println("\n----- ORDER DETAILS -----");
        System.out.println("Table ID: " + tableId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Order placed successfully!");
    }

    private void viewOrders() {
        System.out.println("\n=== ALL ORDERS ===");
        if (orderService.getAllOrders().isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (Order order : orderService.getAllOrders()) {
            System.out.println("Order ID: " + order.getId()
                    + ", Table ID: " + order.getTableId()
                    + ", Status: " + order.getStatus()
                    + ", Created At: " + order.getCreatedAt());
        }
    }
}
