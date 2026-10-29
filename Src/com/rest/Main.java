package com.rest;

import com.rest.CLI.OrderCLI;
import com.rest.CLI.OrderitemCLI;
import com.rest.CLI.PaymentCLI;
import com.rest.CLI.TableCLI;
import com.rest.CLI.menuitemCLI;
import com.rest.service.OrderitemService;
import com.rest.service.OrderService;
import com.rest.service.TableService;
import com.rest.service.menuitemService;
import com.rest.service.paymentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TableCLI tableCLI = new TableCLI(scanner, new TableService());
        OrderCLI orderCLI = new OrderCLI(scanner, new OrderService());
        menuitemCLI menuItemCLI = new menuitemCLI(scanner, new menuitemService());
        OrderitemCLI orderitemCLI = new OrderitemCLI(scanner, new OrderitemService());
        PaymentCLI paymentCLI = new PaymentCLI(scanner, new paymentService());

        while (true) {
            System.out.println("\n===== RESTAURANT MANAGEMENT =====");
            System.out.println("1. Table Management");
            System.out.println("2. Order Management");
            System.out.println("3. Menu Item Management");
            System.out.println("4. Order Item Management");
            System.out.println("5. Payment Management");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    tableCLI.showMenu();
                    break;
                case "2":
                    orderCLI.showMenu();
                    break;
                case "3":
                    menuItemCLI.showMenu();
                    break;
                case "4":
                    orderitemCLI.showMenu();
                    break;
                case "5":
                    paymentCLI.showMenu();
                    break;
                case "0":
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
