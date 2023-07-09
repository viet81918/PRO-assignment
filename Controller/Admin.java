package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
    ArrayList<Book> readBooks = ReadFile("Book.txt", Book.class);
    String line;
    while ((line = reader.readLine()) != null) {
        String[] data = line.split(";");
        Book book = new Book(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), data[5],Integer.parseInt(data[6]), Integer.parseInt(data[7]), data[8]);
        readBooks.add(book);
        books.add(book);
    }
}

private static void addCustomers(BufferedReader reader) throws IOException {
    ArrayList<Customer> readCustomers = ReadFile("Customer.txt", Customer.class);
    String line;
    while ((line = reader.readLine()) != null) {
        // Process each line as needed
        // Assuming customer data is comma-separated
        String[] data = line.split(";");
        Customer customer = new Customer(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]),data[3]);
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
        String[] data = line.split(";");
        BuyCustomer buyCustomer = new BuyCustomer(data[0],Integer.parseInt(data[1]), Double.parseDouble(data[2]));
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
        String[] data = line.split(";");
        RentBook rentBook = new RentBook(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), Integer.parseInt(data[5]), data[6], data[7], data[8]);
        readRentBooks.add(rentBook);
        rentBooks.add(rentBook);
    }
<<<<<<< Updated upstream
}

private static void addRentCustomers(BufferedReader reader) throws IOException {
    ArrayList<RentCustomer> readRentCustomers = ReadFile("RentCustomer.txt", RentCustomer.class);
    String line;
    while ((line = reader.readLine()) != null) {
        // Process each line as needed
        // Assuming rent customer data is comma-separated
        String[] data = line.split(";");
        RentCustomer rentCustomer = new RentCustomer(data[0],Integer.parseInt(data[1]),Double.parseDouble(data[2]));
        readRentCustomers.add(rentCustomer);
        rentCustomers.add(rentCustomer);
    }
}


    public static void setDayRentBook(RentBook book, String date) {
        try {
            Date rentalDate = parseDate(date);
            book.setRentDay(rentalDate);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
=======
    public static void writeObjects(String fileName) {
    String path = System.getProperty("user.dir") + File.separator + fileName;
    File file = new File(path);
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        if (fileName.equals("BuyBook.txt")) {
            for (BuyBook book : buyBooks) {
                writer.write(book.toString());
                writer.newLine();
            }
        } else if (fileName.equals("BuyCustomer.txt")) {
            for (BuyCustomer customer : buyCustomers) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } else if (fileName.equals("RentBook.txt")) {
            for (RentBook book : rentBooks) {
                writer.write(book.toString());
                writer.newLine();
            }
        } else if (fileName.equals("RentCustomer.txt")) {
            for (RentCustomer customer : rentCustomers) {
                writer.write(customer.toString());
                writer.newLine();
            }
>>>>>>> Stashed changes
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
<<<<<<< Updated upstream
    public static void delRentBook(RentBook book,Customer Customer,RentCustomer RentCustomer){
=======
}
public static void writeBooksToFile() {
    String bookFilePath = System.getProperty("user.dir") + File.separator + "Book.txt";
    File bookFile = new File(bookFilePath);
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookFile))) {
        for (BuyBook book : buyBooks) {
            writer.write(book.toString());
            writer.newLine();
        }
        
        for (RentBook book : rentBooks) {
            writer.write(book.toString());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void writeCustomersToFile() {
    String customerFilePath = System.getProperty("user.dir") + File.separator + "Customer.txt";
    File customerFile = new File(customerFilePath);
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerFile))) {
        for (BuyCustomer customer : buyCustomers) {
            writer.write(customer.toString());
            writer.newLine();
        }
        
        for (RentCustomer customer : rentCustomers) {
            writer.write(customer.toString());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}



    public static void delRentBook(RentBook book, Customer Customer, RentCustomer RentCustomer) {
>>>>>>> Stashed changes
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
        addReadObject("Book.txt");
        addReadObject("RentBook.txt");
<<<<<<< Updated upstream
        for (Customer customers : customers){
            System.out.println(customers.toString());}
        for (BuyCustomer buyCustomer : buyCustomers){
            System.out.println(buyCustomer.toString());}
        for (RentCustomer rentCustomer : rentCustomers){
            System.out.println(rentCustomer.toString());}
        for (Book books : books){
            System.out.println(books.toString());}
        for (RentBook rentBook : rentBooks){
            System.out.println(rentBook.toString());}
=======
        writeBooksToFile();
        writeCustomersToFile();

        for (RentCustomer rentCustomer : rentCustomers) {
            System.out.println(rentCustomer.toString());
        }
         for (BuyCustomer BuyCustomer : buyCustomers) {
            System.out.println(BuyCustomer.toString());
        }
        for (RentBook rentBook : rentBooks) {
            System.out.println(rentBook.toString());
        }
        for (BuyBook Buybooks : buyBooks) {
            System.out.println(Buybooks.toString());
        }
       

>>>>>>> Stashed changes
    }
    private static Date parseDate(String dateStr) throws  ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.parse(dateStr);
    }
}
