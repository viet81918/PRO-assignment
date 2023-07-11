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
import java.util.Scanner;
import Model.Customer;
import Model.Book;
import Model.BuyCustomer;
import Model.RentBook;
import Model.RentCustomer;

<<<<<<< Updated upstream
public class Admin {
    static String customersFilePath = "Customer.txt";
    static String rentCustomersFilePath = "RentCustomer.txt";
    static String buyCustomersFilePath = "BuyCustomer.txt";
    static String booksFilePath = "Book.txt";
    static String rentBooksFilePath = "RentBook.txt";
=======
    import Model.Customer;
    import Model.Book;
import Model.BuyBook;
import Model.BuyCustomer;
    import Model.RentBook;
    import Model.RentCustomer;
>>>>>>> Stashed changes

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
                ArrayList<Book> readBooks = ReadFile(path, Book.class);
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
            } else if (fileName.equals("Customer.txt")) {
                ArrayList<Customer> readCustomers = ReadFile(path, Customer.class);
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
            } else if (fileName.equals("BuyCustomer.txt")) {
                ArrayList<BuyCustomer> readBuyCustomers = ReadFile(path, BuyCustomer.class);
                String line;
                while ((line = reader.readLine()) != null) {
                    // Process each line as needed
                    // Assuming buy customer data is comma-separated
                    String[] data = line.split(",");
                    BuyCustomer buyCustomer = new BuyCustomer(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
                    readBuyCustomers.add(buyCustomer);
                    buyCustomers.add(buyCustomer);
                }
            } else if (fileName.equals("RentBook.txt")) {
                ArrayList<RentBook> readRentBooks = ReadFile(path, RentBook.class);
                String line;
                while ((line = reader.readLine()) != null) {
                    // Process each line as needed
                    // Assuming rent book data is comma-separated
                    String[] data = line.split(",");
                    RentBook rentBook = new RentBook(Double.parseDouble(data[0]), Integer.parseInt(data[1]), data[2],data[3]);
                    readRentBooks.add(rentBook);
                    rentBooks.add(rentBook);
                }
            } else if (fileName.equals("RentCustomer.txt")) {
                ArrayList<RentCustomer> readRentCustomers = ReadFile(path, RentCustomer.class);
                String line;
                while ((line = reader.readLine()) != null) {
                    // Process each line as needed
                    // Assuming rent customer data is comma-separated
                    String[] data = line.split(",");
                    RentCustomer rentCustomer = new RentCustomer(Integer.parseInt(data[0]),Double.parseDouble(data[1]));
                    readRentCustomers.add(rentCustomer);
                    rentCustomers.add(rentCustomer);
                }
            }
<<<<<<< Updated upstream
        } catch (IOException e) {
            e.printStackTrace();
=======
            return customersfind;
        }

        public void addBbook(BuyBook b) {
            Bbooklist.add(b);
        }

        public double SumPrice(RentBook rb, BuyBook b) {
            return rb.getRentPrice() + b.getBuyPrice();
        }

        public static void SortBook() {
            Collections.sort(Bbooklist, new Comparator<BuyBook>() {
                @Override
                public int compare(BuyBook book1, BuyBook book2) {
                    return Integer.compare(book2.getBookNumber(), book1.getBookNumber());
                }
            });
        }
        
                
        

        public static void main(String[] args) throws Exception {
            addReadObject("RentCustomer.txt");
            addReadObject("BuyCustomer.txt");
            addReadObject("BuyBook.txt");
            addReadObject("RentBook.txt");
            writeBooksToFile();
            writeCustomersToFile();
            System.out.println("Nhap vao id: ");
            String id = scanner.nextLine();
            ArrayList<RentCustomer> relist = new ArrayList<>();
            relist = FindCustomer(id);
            for (RentCustomer rc : relist) {
                System.out.println(rc.toString());
            }
            BuyBook bookWithMaxQuantity = Bbooklist.get(0);
            for (BuyBook book : Bbooklist) {
                if (book.getSoldBookNumber() > bookWithMaxQuantity.getSoldBookNumber()) {
                    bookWithMaxQuantity = book;
                }
            }
            Collections.sort(Bbooklist, new Comparator<BuyBook>() {
                @Override
                public int compare(BuyBook book1, BuyBook book2) {
                    return Integer.compare(book2.getSoldBookNumber(), book1.getSoldBookNumber());
                }
            });
            for (BuyBook book : Bbooklist) {
                System.out.println("Title: " + book.getBookName() + ", Quantity: " + book.getSoldBookNumber());
            }
        }

        private static Date parseDate(String dateStr) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(dateStr);
        }

        public <T> ArrayList<T> searchRentBook(Predicate<Object> p) {
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

        public <T> ArrayList<T> searchBuyBook(Predicate<Object> p) {
            ArrayList<T> cuslistfind = new ArrayList<>();
            for (Object cus : Bbooklist) {
                if (p.test(cus))
                    cuslistfind.add((T) cus);
            }
            return cuslistfind;
>>>>>>> Stashed changes
        }
    }

    private Date parseDate(String dob) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.parse(dob);
    }
}
