package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Model.Customer;
import Model.Book;
import Model.BuyCustomer;
import Model.RentBook;
import Model.RentCustomer;

public class Admin {

    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<RentCustomer> rentCustomers = new ArrayList<>();
    static ArrayList<BuyCustomer> buyCustomers = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<RentBook> rentBooks = new ArrayList<>();

    public static List<Customer> getCustomers() {
        return customers;
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
        if (fileName.equals("Book.txt")) {
            addBooks(reader);
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
        ArrayList<Book> readBooks = ReadFile("Book.txt", Book.class);
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            Book book = new Book(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), data[5],
                    Integer.parseInt(data[6]), Integer.parseInt(data[7]), data[8]);
            readBooks.add(book);
            books.add(book);
        }
    }

    private static void addRentBooks(BufferedReader reader) throws IOException {
        ArrayList<RentBook> readRentBooks = ReadFile("RentBook.txt", RentBook.class);
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming rent book data is comma-separated
            String[] data = line.split(";");
            RentBook rentBook = new RentBook(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]),
                    Integer.parseInt(data[5]), data[6], data[7], data[8]);
            readRentBooks.add(rentBook);
            rentBooks.add(rentBook);
        }
    }

    private static void addBuyCustomers(BufferedReader reader) throws IOException {
    ArrayList<BuyCustomer> readBuyCustomers = ReadFile("BuyCustomer.txt", BuyCustomer.class);
    String line;
    while ((line = reader.readLine()) != null) {
        // Process each line as needed
        // Assuming buy customer data is comma-separated
        String[] data = line.split(";");
        BuyCustomer buyCustomer = new BuyCustomer(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]),
                data[3]);
        readBuyCustomers.add(buyCustomer);
        customers.add(buyCustomer);
        buyCustomers.add(buyCustomer);
    }
}

private static void addRentCustomers(BufferedReader reader) throws IOException {
    ArrayList<RentCustomer> readRentCustomers = ReadFile("RentCustomer.txt", RentCustomer.class);
    String line;
    while ((line = reader.readLine()) != null) {
        // Process each line as needed
        // Assuming rent customer data is comma-separated
        String[] data = line.split(";");
        RentCustomer rentCustomer = new RentCustomer(data[0], Integer.parseInt(data[1]),
                Double.parseDouble(data[2]), data[3]);
        readRentCustomers.add(rentCustomer);
        customers.add(rentCustomer);
        rentCustomers.add(rentCustomer);
    }
}



    public static void setDayRentBook(RentBook book, String date) {
        try {
            Date rentalDate = parseDate(date);
            book.setRentDay(rentalDate);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void printRentBook(RentBook book) {
        System.out.println(book.toString());
    }

    public static void main(String[] args) throws Exception {
    addReadObject("RentCustomer.txt");
    addReadObject("BuyCustomer.txt");
    addReadObject("Book.txt");
    addReadObject("RentBook.txt");

    System.out.println("Rent Customers:");
    for (RentCustomer rentCustomer : rentCustomers) {
        System.out.println(rentCustomer.toString());
    }

    System.out.println("Buy Customers:");
    for (BuyCustomer buyCustomer : buyCustomers) {
        System.out.println(buyCustomer.toString());
    }

    System.out.println("Books:");
    for (Book book : books) {
        System.out.println(book.toString());
    }

    System.out.println("Rent Books:");
    for (RentBook rentBook : rentBooks) {
        System.out.println(rentBook.toString());
    }
}


    private static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.parse(dateStr);
    }
}
