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
import Model.BuyBook;
import Model.BuyCustomer;
import Model.RentBook;
import Model.RentCustomer;

public class Admin {

    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<RentCustomer> rentCustomers = new ArrayList<>();
    static ArrayList<BuyCustomer> buyCustomers = new ArrayList<>();
    static ArrayList<BuyBook> Buybooks = new ArrayList<>();
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
    public static void addReadObject(String fileName) throws NumberFormatException, ParseException {
    String path = System.getProperty("user.dir") + File.separator + fileName;

    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        if (fileName.equals("BuyBook.txt")) {
            addBuyBooks(reader);}
        // } else if (fileName.equals("Customer.txt")) {
        //     addCustomers(reader);
        // } else if (fileName.equals("BuyCustomer.txt")) {
        //     addBuyCustomers(reader);
        // } else if (fileName.equals("RentBook.txt")) {
        //     addRentBooks(reader);
        // } else if (fileName.equals("RentCustomer.txt")) {
        //     addRentCustomers(reader);
        // }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void addBuyBooks(BufferedReader reader) throws IOException, NumberFormatException, ParseException {
    ArrayList<Book> readBooks = ReadFile("BuyBook.txt", Book.class);
    String line;
    while ((line = reader.readLine()) != null) {
        String[] data = line.split(";");
        BuyBook book = new BuyBook(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]),Double.parseDouble(data[5]),(java.util.Date) parseDate(data[6]),Integer.parseInt(data[7]),Double.parseDouble(data[8]),data[9]);
        Buybooks.add(book);
    }
}

// private static void addCustomers(BufferedReader reader) throws IOException {
//     ArrayList<Customer> readCustomers = ReadFile("Customer.txt", Customer.class);
//     String line;
//     while ((line = reader.readLine()) != null) {
//         // Process each line as needed
//         // Assuming customer data is comma-separated
//         String[] data = line.split(";");
//         Customer customer = new Customer(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]),data[3]);
//         readCustomers.add(customer);
//         customers.add(customer);
//     }
// }

// private static void addBuyCustomers(BufferedReader reader) throws IOException {
//     ArrayList<BuyCustomer> readBuyCustomers = ReadFile("BuyCustomer.txt", BuyCustomer.class);
//     String line;
//     while ((line = reader.readLine()) != null) {
//         // Process each line as needed
//         // Assuming buy customer data is comma-separated
//         String[] data = line.split(";");
//         BuyCustomer buyCustomer = new BuyCustomer();
//         readBuyCustomers.add(buyCustomer);
//         buyCustomers.add(buyCustomer);
//     }
// }

// private static void addRentBooks(BufferedReader reader) throws IOException {
//     ArrayList<RentBook> readRentBooks = ReadFile("RentBook.txt", RentBook.class);
//     String line;
//     while ((line = reader.readLine()) != null) {
//         // Process each line as needed
//         // Assuming rent book data is comma-separated
//         String[] data = line.split(";");
//         RentBook rentBook = new RentBook(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), Integer.parseInt(data[5]), data[6], data[7], data[8]);
//         readRentBooks.add(rentBook);
//         rentBooks.add(rentBook);
//     }
// }

// private static void addRentCustomers(BufferedReader reader) throws IOException {
//     ArrayList<RentCustomer> readRentCustomers = ReadFile("RentCustomer.txt", RentCustomer.class);
//     String line;
//     while ((line = reader.readLine()) != null) {
//         // Process each line as needed
//         // Assuming rent customer data is comma-separated
//         String[] data = line.split(";");
//         RentCustomer rentCustomer = new RentCustomer(data[0],Integer.parseInt(data[1]),Double.parseDouble(data[2]));
//         readRentCustomers.add(rentCustomer);
//         rentCustomers.add(rentCustomer);
//     }
// }


    public static void setDayRentBook(RentBook book, String date) {
        try {
            Date rentalDate = parseDate(date);
            book.setRentDay(rentalDate);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    public static void delRentBook(RentBook book,Customer Customer,RentCustomer RentCustomer){
        rentBooks.remove(book);
        RentCustomer.setBookNumber(RentCustomer.getBookNumber()-1);
        if (RentCustomer.getBookNumber() < 0){
            rentCustomers.remove(RentCustomer);
            customers.remove(Customer);
        }
    }
    public static void printRentBook(RentBook book){
        System.out.println(book.toString());
    }
    public static void addRentBooks(RentBook book,Customer Customer,RentCustomer rentCustomer){
        rentBooks.add(book);
        rentCustomer.setBookNumber(rentCustomer.getBookNumber()+1);
        Customer.setBookNumber(Customer.getBookNumber()+1);
        }
    public static void main(String[] args) throws Exception{
        addReadObject("Customer.txt");
        addReadObject("RentCustomer.txt");
        addReadObject("BuyCustomer.txt");
        addReadObject("BuyBook.txt");
        addReadObject("RentBook.txt");
    //     for (Customer customers : customers){
    //         System.out.println(customers.toString());}
    //     for (BuyCustomer buyCustomer : buyCustomers){
    //         System.out.println(buyCustomer.toString());}
    //     for (RentCustomer rentCustomer : rentCustomers){
    //         System.out.println(rentCustomer.toString());}
    //     for (Book books : books){
    //         System.out.println(books.toString());}
    //     for (RentBook rentBook : rentBooks){
    //         System.out.println(rentBook.toString());}
    for (BuyBook Buybooks : Buybooks){
        System.out.println(Buybooks.toString());
    }
    }
    private static Date parseDate(String dateStr) throws  ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }
}