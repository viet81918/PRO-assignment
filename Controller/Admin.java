package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

import java.util.Iterator;
import Model.Book;
import Model.BuyBook;
import Model.BuyCustomer;
import Model.Customer;
import Model.RentBook;
import Model.RentCustomer;
import View.BookStore;
import Controller.CustomerManage;

public class Admin {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<RentCustomer> Rcuslist;
    private ArrayList<BuyCustomer> Bcuslist;
    private ArrayList<BuyBook> Bbooklist;
    private ArrayList<RentBook> Rbooklist;
    private ArrayList<String> bookReview;

    public Admin() {
        Rcuslist = new ArrayList<>();
        Bcuslist = new ArrayList<>();
        Bbooklist = new ArrayList<>();
        Rbooklist = new ArrayList<>();
        bookReview = new ArrayList<>();
        try {
            addReadObject("RentCustomer.txt");
            addReadObject("BuyCustomer.txt");
            addReadObject("BuyBook.txt");
            addReadObject("RentBook.txt");
            bookReview = readBookReview();
        } catch (NumberFormatException | ParseException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<BuyBook> getBbooklist() {
        return Bbooklist;
    }

    public void setBbooklist(ArrayList<BuyBook> bbooklist) {
        Bbooklist = bbooklist;
    }

    public void addReadObject(String fileName) throws NumberFormatException, ParseException {
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

    private void addBbooklist(BufferedReader reader) throws IOException, NumberFormatException, ParseException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            BuyBook book = new BuyBook(data[0], data[1], data[2], Integer.parseInt(data[3]),
                    Double.parseDouble(data[4]), (java.util.Date) parseDate(data[5]), Integer.parseInt(data[6]),
                    data[7]);
            Bbooklist.add(book);
        }
    }

    private void addBcuslist(BufferedReader reader) throws IOException {
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

    public void readFile(String p) throws FileNotFoundException, ParseException {

        // Create a Scanner object to read the text file.
        File file = new File(p);
        Scanner scanner = new Scanner(file);

        // Iterate through the text file, one line at a time.
        while (scanner.hasNextLine()) {
            // Get the line from the file.
            String line = scanner.nextLine();

            // Split the line into the person's name and ID.
            String[] tokens = line.split(",");
            String id = tokens[0];
            String name = tokens[1];
            String phone = tokens[2];
            // SimpleDateFormat df=new SimpleDateFormat("dd/mm/yyyy");
            int dob = Integer.parseInt(tokens[3]);
            double a = Double.parseDouble(tokens[4]);
            Date date = parseDate(tokens[5]);
            int b = Integer.parseInt(tokens[6]);
            String c = tokens[7];
            // Create a new Person object and add it to the ArrayList.
            BuyBook d = new BuyBook(id, name, phone, dob, a, date, b, c);
            Bbooklist.add(d);
        }
    }

    private void addRbooklist(BufferedReader reader) throws IOException, NumberFormatException, ParseException {
        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line as needed
            // Assuming rent book data is comma-separated
            String[] data = line.split(";");
            RentBook book = new RentBook(data[0], data[1], data[2], Double.parseDouble(data[3]),
                    parseDate(data[4]), data[5], Integer.parseInt(data[6]),
                    Integer.parseInt(data[7]), Double.parseDouble(data[8]), data[9], data[10]);
            Rbooklist.add(book);
        }
    }

    private void addRcuslist(BufferedReader reader) throws IOException {
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

    public void writeBooksToFile() {
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

    public void writeCustomersToFile() {
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

    public void delRentBook(RentBook book, RentCustomer RentCustomer) {
        Rbooklist.remove(book);
        RentCustomer.setBookNumber(RentCustomer.getBookNumber() - 1);
        if (RentCustomer.getBookNumber() < 0) {
            Rcuslist.remove(RentCustomer);
        }
    }

    public void addRbooklist(RentBook book, RentCustomer customer) {
        Rbooklist.add(book);
        customer.setBookNumber(customer.getBookNumber() + 1);
    }

    public void printlnRbooklist(RentBook book) {
        for (RentBook rentBook : Rbooklist) {
            System.out.println(rentBook.toString());
        }
    }

    public void deleteIDBook(String bookid) throws ParseException {
        Iterator<BuyBook> iterator = Bbooklist.iterator();
        Iterator<RentBook> iterator2 = Rbooklist.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            BuyBook cus = iterator.next();
            if (cus.getBookID().contains(bookid)) {
                iterator.remove();
                System.out.println("Sach co mã số " + bookid + " đã được xóa.");
                found = true;
                break;
            }
        }
        while (iterator2.hasNext()) {
            RentBook cus = iterator2.next();
            if (cus.getBookID().contains(bookid)) {
                iterator2.remove();
                System.out.println("Sach co mã số " + bookid + " đã được xóa.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sach có mã số " + bookid);
        }
    }

    public void addbook(BuyBook br, RentBook r) throws ParseException {
        Rbooklist.add(r);
        Bbooklist.add(br);
    }

    public double SumPrice(RentBook rb, BuyBook b) {
        return rb.getRentPrice() + b.getBuyPrice();
    }

    public void SortSoldBook() {
        Collections.sort(Bbooklist, new Comparator<BuyBook>() {
            @Override
            public int compare(BuyBook book1, BuyBook book2) {
                return Integer.compare(book2.getSoldBookNumber(), book1.getSoldBookNumber());
            }
        });
        int count = 0;
        for (BuyBook book : Bbooklist) {
            if (count >= 5) {
                break; // Stop after printing the top 5 books
            }
            System.out.print("| Book ID: " + book.getBookID());
            System.out.print("| Book Name: " + book.getBookName());
            System.out.print("| Sold Book Number: " + book.getSoldBookNumber());
            System.out.println("| Revenue: " + (book.getBuyPrice()));
            System.out.println("--------------------------------");

            count++;
        }
    }

    public <T> ArrayList<T> searchRentBook1(Predicate<Object> p) {
        ArrayList<T> rentbookfind = new ArrayList<>();
        for (Object renbok : Rbooklist) {
            if (p.test(renbok))
                rentbookfind.add((T) renbok);
        }
        return rentbookfind;
    }

    public <T> ArrayList<T> searchRentCustomer(Predicate<Object> p) {
        ArrayList<T> cuslistfind = new ArrayList<>();
        for (Object cus : Rcuslist) {
            if (p.test(cus))
                cuslistfind.add((T) cus);
        }
        return cuslistfind;
    }

    public <T> ArrayList<T> searchBuyCustomer(Predicate<Object> p) {
        ArrayList<T> cuslistfind = new ArrayList<>();
        for (Object cus : Bcuslist) {
            if (p.test(cus))
                cuslistfind.add((T) cus);
        }
        return cuslistfind;
    }

    public ArrayList<BuyBook> searchBuyBook1(Predicate<BuyBook> p) {
        ArrayList<BuyBook> buybookfind = new ArrayList<>();
        for (BuyBook cus : Bbooklist) {
            if (p.test(cus))
                buybookfind.add(cus);
        }
        return buybookfind;
    }

    public ArrayList<BuyBook> searchBuyBookByPriceRange1(double minPrice, double maxPrice) {
        ArrayList<BuyBook> buyBooksInRange = new ArrayList<>();
        for (BuyBook book : Bbooklist) {
            if (book.getPrice() >= minPrice && book.getPrice() <= maxPrice) {
                buyBooksInRange.add(book);
            }
        }
        return buyBooksInRange;
    }

    public ArrayList<BuyBook> searchBuyBookByPriceRange2(double minPrice) {
        ArrayList<BuyBook> buyBooksInRange = new ArrayList<>();
        for (BuyBook book : Bbooklist) {
            if (book.getPrice() >= minPrice) {
                buyBooksInRange.add(book);
            }
        }
        return buyBooksInRange;
    }

    public ArrayList<BuyBook> searchBuyBookByPriceRange3(double maxPrice) {
        ArrayList<BuyBook> buyBooksInRange = new ArrayList<>();
        for (BuyBook book : Bbooklist) {
            if (book.getPrice() <= maxPrice) {
                buyBooksInRange.add(book);
            }
        }
        return buyBooksInRange;
    }

    public ArrayList<String> readBookReview() throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("Review.txt"))) {
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(";");
                    String bookName = data[0];
                    String review = data[1];
                    bookReview.add(bookName + ";" + review);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bookReview;
    }

    public void writeBookReview() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Review.txt"))) {
            for (String data : bookReview) {
                writer.write(data);
                writer.newLine();
            }
        }
    }

    public void DisplayReviewByID(String id) {
        ArrayList<BuyCustomer> result1 = new ArrayList<>();
        result1 = searchBuyCustomer(p -> ((BuyCustomer) p).getID().equals(id));
        ArrayList<RentCustomer> result2 = new ArrayList<>();
        result2 = searchRentCustomer(p -> ((RentCustomer) p).getID().equals(id));
        for (BuyCustomer bc : result1) {
            System.out.println(bc.getReview());
        }
        for (RentCustomer rc : result2) {
            System.out.println(rc.getReview());
        }
    }

    public void addBookReview(String bookName, String review) {
        String data = bookName + ";" + review;
        if (!checkNameBook(bookName))
            bookReview.add(data);
        else
            System.out.println("Not book available");
    }

    Boolean checkNameBook(String bookName) {
        for (BuyBook b : Bbooklist) {
            if (b.getBookName().equalsIgnoreCase(bookName)) {
                return false;
            }
        }
        for (RentBook b : Rbooklist) {
            if (b.getBookName().equalsIgnoreCase(bookName)) {
                return false;
            }
        }
        return true;
    }

    public void printBookReview() {
        for (String data : bookReview) {
            System.out.println(data);
        }
    }

    public boolean deleteBook(String name) throws ParseException {
        boolean deleted = false;
        for (Iterator<BuyBook> iterator = Bbooklist.iterator(); iterator.hasNext();) {
            BuyBook b = iterator.next();
            if (b.getBookID().equals(name)) {
                iterator.remove();
                deleted = true;
            }
        }
        return deleted;
    }

    public void writeRbooklist(ArrayList<RentBook> books) throws IOException, ParseException {
        String bookFilePath = System.getProperty("user.dir") + File.separator + "RentedBook.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookFilePath, true))) {
            for (RentBook book : books) {
                String bookInfo = book.getBookType() + book.getBookID() + " | " + book.getBookName() + " | " +
                        book.getRentDay() + " | " + book.getReturnDay();
                writer.write(bookInfo);
                writer.newLine();
            }
        }
    }

    public void writeReviewforCustomer(String id, String review) {
        ArrayList<BuyCustomer> result1 = new ArrayList<>();
        result1 = searchBuyCustomer(p -> ((BuyCustomer) p).getID().equals(id));
        ArrayList<RentCustomer> result2 = new ArrayList<>();
        result2 = searchRentCustomer(p -> ((RentCustomer) p).getID().equals(id));
        for (BuyCustomer bc : result1) {
            String Review = bc.getReview();
            bc.setReview(Review + "," + review);
        }
        for (RentCustomer rc : result2) {
            String Review = rc.getReview();
            rc.setReview(Review + "," + review);
        }
    }

    public void WritereviewforBook(String id, String review) {
        ArrayList<BuyBook> result1 = new ArrayList<>();
        result1 = searchBuyBook1(p -> ((BuyBook) p).getBookID().equals(id));
        ArrayList<RentBook> result2 = new ArrayList<>();
        result2 = searchRentBook1(p -> ((RentBook) p).getBookID().equals(id));
        for (BuyBook bc : result1) {
            String Review = bc.getReview();
            bc.setReview(Review + "," + review);
        }
        for (RentBook rc : result2) {
            String Review = rc.getReview();
            rc.setReview(Review + "," + review);
            addBookReview(rc.getBookName(), review);
        }
    }

    private Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }

    public void getAllBooks() {
        for (BuyBook book : Bbooklist) {
            System.out.println(book.toString());
        }
        for (RentBook book : Rbooklist) {
            System.out.println(book.toString());
        }
    }

    public void getAllCustomer() {
        for (BuyCustomer cus : Bcuslist) {
            System.out.println(cus.toString());
        }
        for (RentCustomer cus : Rcuslist) {
            System.out.println(cus.toString());
        }
    }

}
