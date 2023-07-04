package view;

import static view.CompanyManagement.addSampleCustomers;
import static view.CompanyManagement.getValidIntegerInput;
public class Menu {
   
    public static void main(String[] args) {
       addSampleCustomers();
        Menu.displayMenu();
    }


    public static void displayMenu() {
        int choice;
        do {
            System.out.println("Company Management System");
            System.out.println("------------------");
            System.out.println("1. List all customers");
            System.out.println("2. Search customers");
            System.out.println("3. Add new customer");
            System.out.println("4. Customer statistical");
            System.out.println("5. Exit");
            System.out.println("------------------");
            System.out.print("Enter selection : ");
            choice = getValidIntegerInput();
            switch (choice) {
                case 1 -> CompanyManagement.displayCustomers();
                case 2 -> CompanyManagement.searchCustomers();
                case 3 -> CompanyManagement.addCustomer();
                case 4 -> CompanyManagement.sortCustomers();
                case 5 -> System.out.println("Exiting the application. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}