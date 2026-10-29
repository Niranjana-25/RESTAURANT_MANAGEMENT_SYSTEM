
package com.rest.CLI;

import com.rest.models.Table;
import com.rest.service.TableService;
import java.util.List;
import java.util.Scanner;

public class TableCLI {

    private final TableService service;
    private final Scanner scanner;

    public TableCLI(Scanner scanner, TableService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== TABLE MANAGEMENT =====");
            System.out.println("1. View All Tables");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Table> tables = service.getAllTables();
                    System.out.println("\n== ALL TABLES ==");
                    for (Table table : tables) {
                        System.out.println(table);
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
