package View;

import Model.Book;
import Model.BuyBook;
import Model.BuyCustomer;
import Model.Customer;
import Model.RentBook;
import Model.RentCustomer;
import View.Menu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import Controller.Admin;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class BookStore<T> {
    static Scanner scanner = new Scanner(System.in);
    static Admin admin = new Admin();
    public BookStore() {
        try {
        admin.addReadObject("RentCustomer.txt");
        admin.addReadObject("BuyCustomer.txt");
        admin.addReadObject("BuyBook.txt");
        admin.addReadObject("RentBook.txt");
        } catch (NumberFormatException | ParseException ex) {
            ex.printStackTrace();
        }
    }
    public void Menu() throws ParseException {
        String[] mc = { "ADMIN MENU", "CUSTOMER MENU", };
        Menu m = new Menu("====== MENU =====", mc) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1:
                        AdminMenu();
                        break;
                    case 2:
                        // AdminMenu();
                        break;
                }
            }
        };
        m.run();
    }

    public void AdminMenu() throws ParseException {
        String[] mc = { "Tim kiem sach", "Them sach va xoa danh sach mua","Chinh sua thong tin sach", "Tim kiem thong tin khach hang",
                "Chinh sua thong tin khach hang",
                "Phan loai cac dau sach ban chay", "In tong doanh thu",
                "In sach co nguoi thue", "In sach da ban duoc", "Hien thi tat ca thong tin sach",
                "Viet du lieu khach hang va sach vao file" };
        Menu m = new Menu("Customer Management", mc) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1:
                        findBooks();
                        break;
                    case 2:
                        addBookAndDelete();
                        break;
                    case 3:
                        searchCustomer();
                        break;
                    // case "4":
                    // changeCustomerInfor();
                    // break;
                    case 5:
                        // sortBook();
                        break;
                    case 6:
                         printSale();
                        break;
                    case 7:
                        // printRentedBook();
                        break;
                    case 8:
                        // printBoughtBook();
                        break;
                    case 9:
                        displayAll();
                        break;
                    case 10:
                        // writeToFile();
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    default:
                        break;
                }
            }
        };
        m.run();
    }

    protected void displayAll() {
        admin.getAllBooks();
    }
    public void findBooks() throws ParseException{
        String[] mc = new String[] { "Search Buy books","Search Rent books"};
        Menu menu = new Menu("Book Searching",mc ){
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {searchBuyBook();}
                    case 2 -> {searchRentBook();}
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
            };
            menu.run();
        }

    private void searchBuyBook() {
            System.out.print("Enter Book Name: ");
            String name = scanner.nextLine().trim();
            List<BuyBook> results = Admin.searchBuyBook1(p -> ((Book) p).getBookName().startsWith(name));
            display(results);
    }
    private void searchRentBook() {
            System.out.print("Enter Book Name: ");
            String name = scanner.nextLine().trim();
            List<RentBook> results = Admin.searchRentBook1(p -> ((Book) p).getBookName().startsWith(name));
            display(results);
        }
    private void addBookAndDelete() throws ParseException{
                Menu menu = new Menu("Change Book Information", new String[] { "Add books","Delete books"} ) {
                    @Override
                    public void execute(int n) throws ParseException {
                        switch (n) {
                        case 1 -> addBook();
                        case 2 -> deleteBook();
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                    }
                };    
                menu.run();
        }

    

    public static void addBook() throws ParseException  {
        System.out.println(" +----ADDING BOOK----+");
        System.out.println("Enter book type: ");
        String type = scanner.nextLine();
        System.out.println("Enter book name: ");
        String bookname = scanner.nextLine();
        System.out.println("Enter author name: ");
        String authorname = scanner.nextLine();
        BuyBook b = new BuyBook(type,bookname, authorname,0,0,parseDate("00/00/0000"), 0,"");
        b.setBookNumber(b.getBookNumber()+1);
        Admin.addBbook(b);
    }


    private void deleteBook() {
        // System.out.println(" +----DELETING BOOK----+");
        // System.out.println("Enter Book Name: ");
        // String name = scanner.nextLine().trim();
        // List<Book> results = Admin.searchBuyBook1(p -> ((Book) p).getBookName().startsWith(name));
        // Admin.deleteBook(results);
        // Book.setBookNumber(Book.getBookNumber() - results.size());
        // System.out.println("+-------------------------------+");
        // System.out.println("Deleted book successfully");
    }

    public void searchCustomer() throws ParseException {
        Menu menu = new Menu("Search Customer Information", new String[] { "Search for Buy Customers","Search for Rent Customers"} ){
            @Override
            public void execute(int n) {
                    switch (n) {
                    case 1 -> searchBuyCustomer();
                    case 2 -> searchRentCustomer();
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
            };  
        menu.run();
    }


    public void searchBuyCustomer(){
            System.out.print("Enter Customer ID: ");
            String id = scanner.nextLine().trim();
            List<BuyCustomer> results = Admin.searchBuyCustomer(p -> ((Customer) p).getID().startsWith(id));
    }
    public void searchRentCustomer(){
            System.out.print("Enter Customer ID: ");
            String id = scanner.nextLine().trim();
            List<RentCustomer> results = Admin.searchRentCustomer(p -> ((Customer) p).getID().startsWith(id));
    }

// public void changeCustomerInfor(){

// }

    public void sortBook(){

    }

    public double printSale(){
        System.out.print("Enter Book Name want to find sale: ");
        String Name = scanner.nextLine().trim();
        double sale = 0;
        List<RentBook> results1 = admin.searchRentBook1(p -> ((Book) p).getName().startsWith(Name));
        List<BuyBook> results2 = admin.searchBuyBook1(p -> ((Book) p).getName().startsWith(Name));
        for (BuyBook book : results2){
            sale = book.getBuyPrice();
        }
        for (RentBook book : results1){
            sale = book.getRentPrice();
        }
        return sale;

    }

    public void printRentedBook(){

    }

    public void printBoughtBook(){

    }
    public static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }
    
    public <T> void display(List<T> list) {
        System.out.println("List of results:");
        System.out.println("---------------------------------");
        if(!list.isEmpty()) {
            for (T a : list) {
                System.out.println(a.toString());
            } 
        }
        else
            System.out.println("List is empty");
        System.out.println("---------------------------------");
        System.out.println("Total : " + list.size() );
    }
}

