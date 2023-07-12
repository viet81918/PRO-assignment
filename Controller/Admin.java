package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import Model.Book;
import Model.BuyBook;
import Model.BuyCustomer;
import Model.RentBook;
import Model.RentCustomer;

public class Admin {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<RentCustomer> Rcuslist = new ArrayList<>();
    static ArrayList<BuyCustomer> Bcuslist = new ArrayList<>();
    static ArrayList<BuyBook> Bbooklist = new ArrayList<>();
    static ArrayList<RentBook> Rbooklist = new ArrayList<>();
    static ArrayList<String> bookReview = new ArrayList<>();

    public static void addReadObject(String fileName) throws NumberFormatException, ParseException {
        String path = System.getProperty("user.dir") + File.separator + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            if (fileName.equals("BuyBook.txt")) {
                addBbooklist(reader);
            } else if (fileName.equals("BuyCustomer.txt")) {
                addBcuslist(reader);
            } else if (fileName.equals("RentBook.txt")) {
                addRbooklist(reader);
            } else if (fileName.equals("RentCustomer.txt")) {
                addRcuslist(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addBbooklist(BufferedReader reader) throws IOException, NumberFormatException, ParseException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            BuyBook book = new BuyBook(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
                    Double.parseDouble(data[5]), (java.util.Date) parseDate(data[6]), Integer.parseInt(data[7]),
                    data[8]);
            Bbooklist.add(book);
        }
    }

    public static void deleteBook(List<Book> listBooks) {
        String bookName = listBooks.get(0).getBookName();
        for (int i = 0; i < Bbooklist.size(); i++) {
            if (Bbooklist.get(i).getBookName().equals(bookName)) {
                Bbooklist.remove(i);
                break;
            }
        }
        for (int i = 0; i < Rbooklist.size(); i++) {
            if (Rbooklist.get(i).getBookName().equals(bookName)) {
                Rbooklist.remove(i);
                break;
            }
        }
    }

    private static void addBcuslist(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming customer data is comma-separated
            String[] data = line.split(";");
            BuyCustomer customer = new BuyCustomer(data[0], Integer.parseInt(data[1]), data[2],
                    Integer.parseInt(data[3]), Double.parseDouble(data[4]));
            Bcuslist.add(customer);
        }
    }

    private static void addRbooklist(BufferedReader reader) throws IOException, NumberFormatException, ParseException {
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming rent book data is comma-separated
            String[] data = line.split(";");
            RentBook book = new RentBook(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]),
                    parseDate(data[5]), data[6], Integer.parseInt(data[7]),
                    Integer.parseInt(data[8]), data[9], data[10]);
            Rbooklist.add(book);
        }
    }

    private static void addRcuslist(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming rent customer data is comma-separated
            String[] data = line.split(";");
            RentCustomer customer = new RentCustomer(data[0], Integer.parseInt(data[1]), data[2],
                    Integer.parseInt(data[3]), Double.parseDouble(data[4]));
            Rcuslist.add(customer);
        }
    }

    public static void writeBooksToFile() {
        String bookFilePath = System.getProperty("user.dir") + File.separator + "Book.txt";
        File bookFile = new File(bookFilePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookFile))) {
            for (BuyBook book : Bbooklist) {
                writer.write(book.toString());
                writer.newLine();
            }

            for (RentBook book : Rbooklist) {
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
            for (BuyCustomer customer : Bcuslist) {
                writer.write(customer.toString());
                writer.newLine();
            }

            for (RentCustomer customer : Rcuslist) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delRentBook(RentBook book, RentCustomer RentCustomer) {
        Rbooklist.remove(book);
        RentCustomer.setBookNumber(RentCustomer.getBookNumber() - 1);
        if (RentCustomer.getBookNumber() < 0) {
            Rcuslist.remove(RentCustomer);
        }
    }

    public static void addRbooklist(RentBook book,RentCustomer customer) {
        Rbooklist.add(book);
        customer.setBookNumber(customer.getBookNumber() + 1);
    }

    public static void printlnRbooklist(RentBook book) {
        for (RentBook rentBook : Rbooklist) {
            System.out.println(rentBook.toString());
        }
    }

    public static void addBbook(BuyBook b) {
        Bbooklist.add(b);
    }

    public double SumPrice(RentBook rb, BuyBook b) {

        return rb.getRentPrice() + b.getBuyPrice();
    }

    public static void SortSoldBook() {
        Collections.sort(Bbooklist, new Comparator<BuyBook>() {
            @Override
            public int compare(BuyBook book1, BuyBook book2) {
                return Integer.compare(book2.getSoldBookNumber(), book1.getSoldBookNumber());
            }
        });
    }

    public static <T> ArrayList<T> searchRentBook(Predicate<Object> p) {
        ArrayList<T> rentbookfind = new ArrayList<>();
        for (Object renbok : Rbooklist) {
            if (p.test(renbok))
                rentbookfind.add((T) renbok);
        }
        return rentbookfind;
    }

    public static <T> ArrayList<T> searchRentCustomer(Predicate<Object> p) {
        ArrayList<T> cuslistfind = new ArrayList<>();
        for (Object cus : Rcuslist) {
            if (p.test(cus))
                cuslistfind.add((T) cus);
        }
        return cuslistfind;
    }

    public static <T> ArrayList<T> searchBuyCustomer(Predicate<Object> p) {
        ArrayList<T> cuslistfind = new ArrayList<>();
        for (Object cus : Bcuslist) {
            if (p.test(cus))
                cuslistfind.add((T) cus);
        }
        return cuslistfind;
    }

    public static <T> ArrayList<T> searchBuyBook(Predicate<Object> p) {
        ArrayList<T> cuslistfind = new ArrayList<>();
        for (Object cus : Bbooklist) {
            if (p.test(cus))
                cuslistfind.add((T) cus);
        }
        return cuslistfind;
    }

    public static ArrayList<String> readBookReview() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("Review.txt"))) {
            String line;
            while ((line = reader.readLine()) !=null) {
                String[] data = line.split(";");
                String bookName = data[0];
                String review = data[1];
                bookReview.add(bookName + ";" + review);
            }
        }
        return bookReview;
    }
    public static void writeBookReview(ArrayList<String> bookReview) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Review.txt"))) {
            for (String data : bookReview) {
                writer.write(data);
                writer.newLine();
            }
        }
    }

    public static void addBookReview(ArrayList<String> bookReview, String bookName, String review) {
        String data = bookName + ";" + review;
        bookReview.add(data);
    }
    public static void printBookReview(ArrayList<String> bookReview) {
            for (String data : bookReview) {
            System.out.println(data);
        }
        }

    public static void main(String[] args) throws Exception {
        addReadObject("RentCustomer.txt");
        addReadObject("BuyCustomer.txt");
        addReadObject("BuyBook.txt");
        addReadObject("RentBook.txt");
        writeBooksToFile();
        writeCustomersToFile();
        SortSoldBook();
        ArrayList<String> bookReview = readBookReview();
        String Name = scanner.nextLine();
        String Review = scanner.nextLine();
        addBookReview(bookReview, Name, Review);
        printBookReview(bookReview);
        writeBookReview(bookReview);

    }

    private static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }
}
