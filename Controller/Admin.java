package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Model.Customer;
import Model.Book;
import Model.BuyCustomer;
import Model.RentBook;
import Model.RentCustomer;

public class Admin {
    static String customersFilePath = "Customer.txt";
    static String rentCustomersFilePath = "RentCustomer.txt";
    static String buyCustomersFilePath = "BuyCustomer.txt";
    static String booksFilePath = "Book.txt";
    static String rentBooksFilePath = "RentBook.txt";

    static ArrayList<Customer> customers = ReadFile(customersFilePath, Customer.class);
    static ArrayList<RentCustomer> rentCustomers = ReadFile(rentCustomersFilePath, RentCustomer.class);
    static ArrayList<BuyCustomer> buyCustomers = ReadFile(buyCustomersFilePath, BuyCustomer.class);
    static ArrayList<Book> books = ReadFile(booksFilePath, Book.class);
    static ArrayList<RentBook> rentBooks = ReadFile(rentBooksFilePath, RentBook.class);

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static ArrayList<RentCustomer> getRentCustomers() {
        return rentCustomers;
    }

    public static ArrayList<BuyCustomer> getBuyCustomers() {
        return buyCustomers;
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static ArrayList<RentBook> getRentBooks() {
        return rentBooks;
    }

    public static <T> ArrayList<T> ReadFile(String path, Class<T> type) {
        ArrayList<T> items = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            items = (ArrayList<T>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void addReadObject(String fileName) {
        String path = System.getProperty("user.dir") + File.separator + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            if (fileName.equals("Books.txt")) {
                addBooks(reader);
            } else if (fileName.equals("Customer.txt")) {
                addCustomers(reader);
            } else if (fileName.equals("BuyCustomer.txt")) {
                addBuyCustomers(reader);
            } else if (fileName.equals("RentBook.txt")) {
                addRentBooks(reader);
            } else if (fileName.equals("RentCustomer.txt")) {
                addRentCustomers(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addBooks(BufferedReader reader) throws IOException {
        ArrayList<Book> readBooks = ReadFile("Books.txt", Book.class);
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming book data is comma-separated
            String[] data = line.split(",");
            Book book = new Book(data[0], data[1], data[2], data[3], data[4], Double.parseDouble(data[5]),
                    Integer.parseInt(data[6]), Integer.parseInt(data[7]), data[8]);
            readBooks.add(book);
            books.add(book);
        }
    }
<<<<<<< Updated upstream
    Systerm.out.println("haha");
=======

    private static void addCustomers(BufferedReader reader) throws IOException {
        ArrayList<Customer> readCustomers = ReadFile("Customer.txt", Customer.class);
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming customer data is comma-separated
            String[] data = line.split(",");
            Customer customer = new Customer(data[0], data[1], Integer.parseInt(data[2]),
                    Double.parseDouble(data[3]));
            readCustomers.add(customer);
            customers.add(customer);
        }
    }

    private static void addBuyCustomers(BufferedReader reader) throws IOException {
        ArrayList<BuyCustomer> readBuyCustomers = ReadFile("BuyCustomer.txt", BuyCustomer.class);
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming buy customer data is comma-separated
            String[] data = line.split(",");
            BuyCustomer buyCustomer = new BuyCustomer(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
            readBuyCustomers.add(buyCustomer);
            buyCustomers.add(buyCustomer);
        }
    }

    private static void addRentBooks(BufferedReader reader) throws IOException {
        ArrayList<RentBook> readRentBooks = ReadFile("RentBook.txt", RentBook.class);
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming rent book data is comma-separated
            String[] data = line.split(",");
            RentBook rentBook = new RentBook(Double.parseDouble(data[0]), Integer.parseInt(data[1]), data[2], data[3]);
            readRentBooks.add(rentBook);
            rentBooks.add(rentBook);
        }
    }

    private static void addRentCustomers(BufferedReader reader) throws IOException {
        ArrayList<RentCustomer> readRentCustomers = ReadFile("RentCustomer.txt", RentCustomer.class);
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming rent customer data is comma-separated
            String[] data = line.split(",");
            RentCustomer rentCustomer = new RentCustomer(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
            readRentCustomers.add(rentCustomer);
            rentCustomers.add(rentCustomer);
        }
    }

    public static void setDayRentBook(RentBook book, String date) {
        try {
            Date rentalDate = parseDate(date);
            book.setNgayThueSach(rentalDate);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.parse(dateStr);
    }

>>>>>>> Stashed changes
}
