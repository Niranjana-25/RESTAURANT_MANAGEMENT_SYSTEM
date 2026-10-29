package com.rest.CLI;

import com.rest.models.menuitem;
import com.rest.service.menuitemService;
import java.util.List;
import java.util.Scanner;

public class menuitemCLI {

    private final Scanner scanner;
    private final menuitemService service;

    public menuitemCLI(Scanner scanner, menuitemService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== MENU ITEM MANAGEMENT =====");
            System.out.println("1. View Menu Items");
            System.out.println("2. Add Menu Item");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewMenuItems();
                    break;
                case "2":
                    addMenuItem();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void viewMenuItems() {
        List<menuitem> items = service.getAllMenuItems();

        System.out.println("\n===== MENU ITEMS =====");
        if (items.isEmpty()) {
            System.out.println("No menu items found.");
            return;
        }

        for (menuitem item : items) {
            System.out.println(item);
        }
    }

    private void addMenuItem() {
        int id = readInt("Enter Menu Item ID: ");

        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();

        double price = readDouble("Enter Price: ");

        menuitem item = new menuitem(id, name, price);
        service.addMenuItem(item);

        System.out.println("Menu item added successfully.");
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

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }
    }
}