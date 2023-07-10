package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Customer;

public abstract class Menu<T> {
 
    protected String title; 
    protected ArrayList<T> mChon;
    
    protected Scanner scanner = new Scanner(System.in);
    
    public Menu() {}
    
    public Menu(String td, String[] mc) { 
    title = td;
    mChon = new ArrayList<>();
    for (String s : mc) {
        mChon.add((T) s);
    }
    // Add the "Exit" option at the end of the menu
    mChon.add((T) "Exit");
}

public void display() {
    System.out.println(title);
    System.out.println("---------------------------------");
    for (int i = 0; i < mChon.size(); i++) {
        // Adjust the numbering to start from 1 and display "Exit" for 0
        if (i == mChon.size() - 1) {
            System.out.println("0. " + mChon.get(i));
        } else {
            System.out.println((i + 1) + ". " + mChon.get(i));
        }
    }
    System.out.println("---------------------------------");
}

    public void display(List<Customer> list) {
        System.out.println("List of Customers");
        System.out.println("---------------------------------");
        if(!list.isEmpty()) {
            for (Customer customer : list) {
                System.out.println(customer.toString());
            } 
        }
        else
            System.out.println("List is empty");
        System.out.println("---------------------------------");
        System.out.println("Total : " + list.size() + " customers.");
    }
    
    public String getSelected() {
        display(); 
        System.out.print ("Enter selection: ");
        return scanner.nextLine();
    }
    
    public void run() {
    while (true) {
        String n = getSelected();
        try {
            int choice = Integer.parseInt(n);
            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice > mChon.size()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            execute(n);
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Please try again.");
        }
    }
}
    
    public abstract void execute (String n);
       
}