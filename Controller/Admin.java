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
import Model.BuyBook;
import Model.BuyCustomer;
import Model.RentBook;
import Model.RentCustomer;

public class Admin {

    static ArrayList<RentCustomer> rentCustomers = new ArrayList<>();
    static ArrayList<BuyCustomer> buyCustomers = new ArrayList<>();
    static ArrayList<BuyBook> buyBooks = new ArrayList<>();
    static ArrayList<RentBook> rentBooks = new ArrayList<>();

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
                addBuyBooks(reader);
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

    private static void addBuyBooks(BufferedReader reader) throws IOException, NumberFormatException, ParseException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            BuyBook book = new BuyBook(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
                    Double.parseDouble(data[5]), (java.util.Date) parseDate(data[6]), Integer.parseInt(data[7]),
                    data[8]);
            buyBooks.add(book);
        }
    }

    private static void addBuyCustomers(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming customer data is comma-separated
            String[] data = line.split(";");
            BuyCustomer customer = new BuyCustomer(data[0], Integer.parseInt(data[1]), data[2],
                    Integer.parseInt(data[3]), Double.parseDouble(data[4]));
            buyCustomers.add(customer);
        }
    }

    private static void addRentBooks(BufferedReader reader) throws IOException, NumberFormatException, ParseException {
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming rent book data is comma-separated
            String[] data = line.split(";");
            RentBook book = new RentBook(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]),
                    parseDate(data[5]), data[6], Integer.parseInt(data[7]), Double.parseDouble(data[8]),
                    Integer.parseInt(data[9]), data[10], data[11]);
            rentBooks.add(book);
        }
    }

    private static void addRentCustomers(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming rent customer data is comma-separated
            String[] data = line.split(";");
            RentCustomer customer = new RentCustomer(data[0], Integer.parseInt(data[1]), data[2],
                    Integer.parseInt(data[3]), Double.parseDouble(data[4]));
            rentCustomers.add(customer);
        }
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

    public static void delRentBook(RentBook book, RentCustomer RentCustomer) {
        rentBooks.remove(book);
        RentCustomer.setBookNumber(RentCustomer.getBookNumber() - 1);
        if (RentCustomer.getBookNumber() < 0) {
            rentCustomers.remove(RentCustomer);
        }
    }

    public static void addRentBooks(RentBook book, RentCustomer rentCustomer) {
        rentBooks.add(book);
        rentCustomer.setBookNumber(rentCustomer.getBookNumber() + 1);
    }
    public static void printlnRentBooks(RentBook book){
        for (RentBook rentBook : rentBooks) {
            System.out.println(rentBook.toString());
        }
    }
    public static void main(String[] args) throws Exception {
        addReadObject("RentCustomer.txt");
        addReadObject("BuyCustomer.txt");
        addReadObject("BuyBook.txt");
        addReadObject("RentBook.txt");
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
    }

    private static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }
}