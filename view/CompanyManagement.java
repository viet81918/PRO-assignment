
package view;

import Controller.Company;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import model.Customer;

public class CompanyManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static Company company = new Company();
    public static void addCustomer() {
        System.out.print("Enter customer ID: ");
        int customerID = getValidIntegerInput();

        System.out.print("Enter customer name: ");
        String name = getValidStringInput();

        System.out.print("Enter customer phone: ");
        int phone = getValidIntegerInput();

        Customer customer = new Customer(customerID, name, phone);
        company.addCustomer(customer);

        System.out.println("Customer added successfully!");
    }

    public static void displayCustomers() {
        System.out.println("List of customers ");
        System.out.println("------------------");
        company.printCustomers();
    }

    public static void searchCustomers() {
    System.out.println("Customers Searching");
    System.out.println("------------------");
    System.out.println("1. Find by CustomerID");
    System.out.println("2. Find by Name");
    System.out.println("3. Find by Phone Number");
    System.out.println("0. Back to main menu");
    System.out.print("Enter your choice: ");
    int choice = getValidIntegerInput();
    switch (choice) {
        case 1 -> {
            System.out.print("Enter the customer ID: ");
            int id = getValidIntegerInput(); 
            List<Customer> customersById = company.searchCustomersByCriteria(String.valueOf(id));
            if (customersById.isEmpty()) {
                System.out.println("No customers found with the given ID.");
            } else {
                 int totalCustomers = customersById.size();
                 for (Customer customer : customersById) {
                 System.out.println(customer.toString());
                }
                 System.out.println("Total : " + totalCustomers + " Customers." );
                 System.out.println("------------------");
            }
            }
        case 2 -> {
            System.out.print("Enter the customer name: ");
            String name = getValidStringInput();
            List<Customer> customersByName = company.searchCustomersByCriteria(name);
            if (customersByName.isEmpty()) {
                System.out.println("No customers found with the given name.");
            } else {
                int totalCustomers = customersByName.size();
                 for (Customer customer : customersByName) {
                 System.out.println(customer.toString());
                }
                 System.out.println("Total : " + totalCustomers + " Customers." );
                 System.out.println("------------------");
            }
            }
        case 3 -> {
            System.out.print("Enter the customer phone: ");
            int phone = getValidIntegerInput();
            List<Customer> customersByPhone = company.searchCustomersByCriteria(String.valueOf(phone));
            if (customersByPhone.isEmpty()) {
                System.out.println("No customers found with the given phone number.");
            } else {
                int totalCustomers = customersByPhone.size();
                 for (Customer customer : customersByPhone) {
                 System.out.println(customer.toString());
                }
                 System.out.println("Total : " + totalCustomers + " Customers." );
                 System.out.println("------------------");
            }
            }
        case 0 -> System.out.println("Returning to the main menu.");
        default -> System.out.println("Invalid choice. Returning to the main menu.");
    }
}


    public static void sortCustomers() {
    System.out.println("----- Sort Customers -----");
    System.out.println("1. Sort by Name");
    System.out.println("2. Sort by ID");
    System.out.println("3. Sort by Phone");
    System.out.println("0. Back to main menu");
    System.out.print("Enter your choice: ");
    int choice = getValidIntegerInput();
    List<Customer> sortedCustomers;
    switch (choice) {
        case 1 -> {
            sortedCustomers = company.getCustomers();
            sortedCustomers.sort(Comparator.comparing(Customer::getName));
            System.out.println("----- Customers Sorted by Name -----");
            for (Customer customer : sortedCustomers) {
                System.out.println(customer.toString());
            }
            }
        case 2 -> {
            sortedCustomers = company.getCustomers();
            sortedCustomers.sort(Comparator.comparingInt(Customer::getCustomerID));
            System.out.println("----- Customers Sorted by ID -----");
            for (Customer customer : sortedCustomers) {
                System.out.println(customer.toString());
            }
            }
        case 3 -> {
            sortedCustomers = company.getCustomers();
            sortedCustomers.sort(Comparator.comparingInt(Customer::getPhone));
            System.out.println("----- Customers Sorted by Phone -----");
            for (Customer customer : sortedCustomers) {
                System.out.println(customer.toString());
            }
            }
        case 0 -> System.out.println("Returning to the main menu.");
        default -> System.out.println("Invalid choice. Returning to the main menu.");
    }
}

    
public static void addSampleCustomers() {
    Customer customer1 = new Customer(1, "John Doe", 123456789);
    Customer customer2 = new Customer(2, "Jane Smith", 987654321);
    Customer customer3 = new Customer(3, "Michael Johnson", 456123789);
    Customer customer4 = new Customer(4, "Emily Davis", 789123456);
    Customer customer5 = new Customer(5, "Robert Wilson", 321987654);

    company.addCustomer(customer1);
    company.addCustomer(customer2);
    company.addCustomer(customer3);
    company.addCustomer(customer4);
    company.addCustomer(customer5);
}
    public static int getValidIntegerInput() {
    String input;
    while (true) {
        input = scanner.nextLine();
        if (Pattern.matches("^\\d+$", input)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("Invalid input. Please enter a valid non-empty integer.");
        }
    }
    }


    public static String getValidStringInput() {
    String input;
    while (true) {
        input = scanner.nextLine();
        if (!input.isEmpty() && !Pattern.matches(".*[^a-zA-Z].*", input)) {
            return input;
        } else {
            System.out.println("Invalid input. Please enter a valid non-empty string without special characters.");
        }
    }
}

}