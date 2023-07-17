package View;

import Model.Book;
import Model.BuyBook;
import Model.BuyCustomer;
import Model.Customer;
import Model.RentBook;
import Model.RentCustomer;
import View.Menu;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import Controller.Admin;
import Controller.CustomerManage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import View.Validation;

public class BookStore<T> {
    static Scanner scanner = new Scanner(System.in);
    static Admin admin = new Admin();
    static Validation val = new Validation();
    private final static CustomerManage cm = new CustomerManage();
    private CustomerManagement cm1 = new CustomerManagement();
    private ReviewManagement sm = new ReviewManagement();

    public BookStore() throws IOException {

    }

    public void Menu() throws IOException, ParseException {
        String[] mc = { "ADMIN MENU", "CUSTOMER MENU", "REVIEW MANAGEMENT" };
        Menu m = new Menu("====== MENU =====", mc) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1:
                        AdminMenu();
                        break;
                    case 2:
                        cm1.run();
                        break;
                    case 3:
                        sm.run();
                        break;
                    default:
                    System.out.println("Out of function!");
                    
                }
            }
        };
        m.run();
    }

    public void AdminMenu() throws ParseException {
        String[] mc = { "Tim kiem sach", "Them sach va xoa danh sach mua", "Tim kiem thong tin khach hang",
                "Phan loai cac dau sach ban chay", "In tong doanh thu",
                "Viet du lieu khach hang va sach vao file", "Hien thi tat ca thong tin sach",
                "Hien thi tat ca thong tin khach hang ",
        };
        Menu m = new Menu("Admin Management", mc) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1: {
                        findBooks();
                        break;
                    }
                    case 2: {
                        addBookAndDelete();
                        break;
                    }
                    case 3: {
                        searchCustomer();
                        break;
                    }

                    case 4: {
                        printBestSeller();
                        break;
                    }
                    case 5: {
                        printSale();
                        break;
                    }
                    case 6: {
                        writeData();
                        break;
                    }
                    case 7: {
                        displayAllBook();
                        break;
                    }
                    case 8: {
                        displayAllCustomer();
                        break;
                    }
                    default:
                    System.out.println("Out of function!");
                        
                }
            }
        };
        m.run();
    }

    protected void displayAllBook() {
        admin.getAllBooks();
    }

    protected void displayAllCustomer() {
        admin.getAllCustomer();
    }

    public void findBooks() throws ParseException {
        String[] mc = new String[] { "Search Buy books", "Search Rent books" };
        Menu menu = new Menu("Book Searching", mc) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1:
                        searchBuyBook();
                        break;
                    case 2:
                        searchRentBook();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        menu.run();
    }

    private void searchBuyBook() throws ParseException {
        String[] mc = new String[] { "Search Buy books By Name", "Search Buy books By Type",
                "Search Buy Books By Author Name" };

        Menu menu = new Menu("Buy Book Searching", mc) {
            ArrayList<BuyBook> bl = new ArrayList<>();

            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        System.out.println("Enter Book Name");
                        String name = val.getValidStringInput();
                        bl = admin.searchBuyBook1(b -> ((BuyBook) b).getBookName().equalsIgnoreCase(name));
                        break;
                    case 2:
                        String type = " ";
                        do {
                            System.out.println("Enter Book Type");
                            type = val.getValidStringInput();
                        } while (!val.checkType(type));
                        final String Type = type;
                        bl = admin.searchBuyBook1(b -> b.getBookType().equalsIgnoreCase(Type));
                        break;
                    case 3:
                        System.out.println("Enter Author Name");
                        String aname = val.getValidStringInput();
                        bl = admin.searchBuyBook1(b -> ((BuyBook) b).getName().equalsIgnoreCase(aname));
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                if (!bl.isEmpty()) {
                    Display(bl);
                    // Handle the case when the list is not empty
                } else
                    System.out.println("Not Book are found.");
            }
        };
        menu.run();
    }

    private String getValue(String s) {
        System.out.println(s);
        return scanner.nextLine().trim();
    }

    // private void searchBuyBookByName() {
    // System.out.print("Enter Book Name: ");
    // String name = scanner.nextLine().trim();
    // List<BuyBook> results = new ArrayList<>();
    // results = admin.searchBuyBook1(p -> ((Book)
    // p).getBookName().equalsIgnoreCase(name));
    // display(results);
    // }
    // private void searchBuyBookByType() {
    // System.out.print("Enter Book Type: ");
    // String type = scanner.nextLine().trim();
    // List<BuyBook> results = admin.searchBuyBook1(p -> ((Book)
    // p).getBookType().equalsIgnoreCase(type));
    // display(results);
    // }
    // private void searchBuyBookByAuthor() {
    // System.out.print("Enter Book Auhtor Name: ");
    // String aName = scanner.nextLine().trim();
    // List<BuyBook> results = new ArrayList<>();
    // results = admin.searchBuyBook1(p -> ((Book)
    // p).getName().equalsIgnoreCase(aName));
    // display(results);
    // }

    private void searchRentBook() throws ParseException {
        String[] mc = new String[] { "Search Rent books By Name", "Search Rent books By Type",
                "Search Rent Books By Author Name " };
        Menu menu = new Menu("Buy Book Searching", mc) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        searchRentBookByName();
                        break;
                    case 2:
                        searchRentBookByType();
                        break;
                    case 3:
                        searchRentBookByAuthor();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        
                }

            }
        };
        menu.run();
    }

    private void searchRentBookByName() {
        System.out.print("Enter Book Name: ");
        String name = val.getValidStringInput();
        List<RentBook> results = admin.searchRentBook1(p -> ((Book) p).getBookName().startsWith(name));
        display(results);
    }

    private void searchRentBookByType() {
        String type = " ";
        do {
            System.out.println("Enter Book Type");
            type = val.getValidStringInput();
        } while (!val.checkType(type));
        final String Type = type;
        List<RentBook> results = admin.searchRentBook1(p -> ((Book) p).getBookType().startsWith(Type));
        display(results);
    }

    private void searchRentBookByAuthor() {
        System.out.print("Enter Book Auhtor Name: ");
        String aName = val.getValidStringInput();
        List<RentBook> results = admin.searchRentBook1(p -> ((Book) p).getName().startsWith(aName));
        display(results);
    }

    private void addBookAndDelete() throws ParseException {
        Menu menu = new Menu("Change Book Information", new String[] { "Add books", "Delete books" }) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1:
                        addBook();
                        break;
                    case 2: {
                        String id = val.getValidStringInput();
                        admin.deleteIDBook(id);
                    }
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        menu.run();
    }
    // private void writeData() throws ParseException {
    // String bookFilePath = System.getProperty("user.dir") + File.separator +
    // "RentedBook.txt";
    // if (cm.writefile(bookFilePath)) {
    // System.out.println("Success");
    // } else {
    // System.out.println("Error");
    // }
    // }

    private void writeData() {
        admin.writeBooksToFile();
        admin.writeCustomersToFile();
    }

    public void addBook() throws ParseException {
        System.out.println(" +----ADDING BOOK----+");
        String type = " ";
        do {
            System.out.println("Enter Book Type");
            type = val.getValidStringInput();
        } while (!val.checkType(type));
        System.out.println("Enter book name: ");
        String bookname = val.getValidStringInput();
        if (cm.checkNameBook(bookname)) {
            System.out.println("Enter author name: ");
            String authorname = val.getValidStringInput();
            String price = " ";
            do {
                System.out.println(" Enter Price  :");
                price = scanner.nextLine();
            } while (!val.isDouble(price) || Double.parseDouble(price) < 0);
            BuyBook b = new BuyBook(type, bookname, authorname, 0, Double.parseDouble(price), parseDate("00/00/0000"),
                    0, "");
            RentBook r = new RentBook(type, bookname, authorname, Double.parseDouble(price), parseDate("00/00/0000"),
                    "", 0, 0, 0, "00/00/0000", "00/00/0000");
            b.setBookNumber(b.getBookNumber() + 1);
            r.setBookNumber(r.getBookNumber() + 1);
            admin.addbook(b, r);
        } else {
            System.out.println("Book is a ready have, Book in storage +1");
        }

    }

    public void searchCustomer() throws ParseException {
        Menu menu = new Menu("Search Customer Information",
                new String[] { "Search for Buy Customers", "Search for Rent Customers" }) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        searchBuyCustomer();
                        break;
                    case 2:
                        searchRentCustomer();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        menu.run();
    }

    public void searchBuyCustomer() {
        String id = " ";
        do {
            System.out.print("Enter Customer ID: ");
            id = scanner.nextLine().trim();
        } while (val.checkIDcus(id));
        final String cusID = id;
        List<BuyCustomer> results = admin.searchBuyCustomer(p -> ((Customer) p).getID().startsWith(cusID));
        display(results);

    }

    public void searchRentCustomer() {
        String id = " ";
        do {
            System.out.print("Enter Customer ID: ");
            id = scanner.nextLine().trim();
        } while (val.checkIDcus(id));
        final String cusID = id;
        List<RentCustomer> results = admin.searchRentCustomer(p -> ((Customer) p).getID().startsWith(cusID));
        display(results);
    }

    // public void changeCustomerInfor(){

    // }

    public void printSale() {
        System.out.print("Enter Book Name you want to find sale: ");
        String name = scanner.nextLine().trim();

        ArrayList<RentBook> rentBooks = admin.searchRentBook1(p -> ((Book) p).getBookName().equalsIgnoreCase(name));
        ArrayList<BuyBook> buyBooks = admin.searchBuyBook1(p -> ((Book) p).getBookName().equalsIgnoreCase(name));

        for (RentBook rentBook : rentBooks) {
            System.out.println(rentBook.getRentPrice());
            for (BuyBook buyBook : buyBooks) {
                System.out.println(buyBook.getBuyPrice());
                double totalPrice = admin.SumPrice(rentBook, buyBook);
                System.out.println("Total Price: " + totalPrice);
            }
        }
    }


    private void printBestSeller() {
        System.out.println("BEST SELLER BOOKS (BASED ON SOLD NUMBER)");
        admin.SortSoldBook();

    }

    public static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }

    public <T> void display(List<T> list) {
        System.out.println("List of results:");
        System.out.println("---------------------------------");
        if (!list.isEmpty()) {
            for (T a : list) {
                System.out.println(a.toString());
            }
        } else
            System.out.println("List is empty");
        System.out.println("---------------------------------");
        System.out.println("Total : " + list.size());
    }

    public void Display(ArrayList<BuyBook> list) {
        System.out.println("List of results:");
        System.out.println("---------------------------------");
        if (!list.isEmpty()) {
            for (BuyBook a : list) {
                System.out.println(a.toString());
            }
        } else
            System.out.println("List is empty");
        System.out.println("---------------------------------");
        System.out.println("Total : " + list.size());
    }
}