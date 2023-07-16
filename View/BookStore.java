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
public class BookStore<T> {
    static Scanner scanner = new Scanner(System.in);
    static Admin admin = new Admin();
    private final CustomerManage cm = new CustomerManage();
    public BookStore() throws IOException {
        try {
        admin.addReadObject("RentCustomer.txt");
        admin.addReadObject("BuyCustomer.txt");
        admin.addReadObject("BuyBook.txt");
        admin.addReadObject("RentBook.txt");
        cm.addRbooklist();
        } catch (NumberFormatException | ParseException ex) {
            ex.printStackTrace();
        }
    }
    public void Menu() throws ParseException {
        String[] mc = { "admin MENU", "CUSTOMER MENU", };
        Menu m = new Menu("====== MENU =====", mc) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1:
                        AdminMenu();
                        break;
                    case 2:
                        // adminMenu();
                        break;
                }
            }
        };
        m.run();
    }

    public void AdminMenu() throws ParseException {
        String[] mc = { "Tim kiem sach", "Them sach va xoa danh sach mua","Tim kiem thong tin khach hang",
                "Phan loai cac dau sach ban chay", "In tong doanh thu",
                "Viet du lieu khach hang va sach vao file",  "Hien thi tat ca thong tin sach","Hien thi tat ca thong tin khach hang ",
                 };
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
                    
                    case 4:
                        printBestSeller();
                        break;
                    case 5:
                         printSale();
                        break;
                    case 6:
                        writeData();
                        break;
                    case 7:
                        displayAllBook();
                        break;
                    case 8:
                        displayAllCustomer();
                        break;
                    default:
                        break;
                }
            }
        };
        m.run();
    }

    protected void displayAllBook() {
        admin.getAllBooks();
    }
    protected void displayAllCustomer(){
        admin.getAllCustomer();
    }
    public void findBooks() throws ParseException{
        String[] mc = new String[] { "Search Buy books","Search Rent books"};
        Menu menu = new Menu("Book Searching",mc ){
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1:
                        searchBuyBook();
                        break;
                    case 2:
                        searchRentBook();
                        break;
                    default: System.out.println("Invalid choice. Please try again.");
                }
            }
            };
            menu.run();
        }

        private void searchBuyBook() throws ParseException {
            String[] mc = new String[] { "Search Buy books By Name", "Search Buy books By Type", "Search Buy Books By Author Name" };
        
            Menu menu = new Menu("Buy Book Searching", mc) {
                ArrayList<BuyBook> bl = new ArrayList<>();
        
                @Override
                public void execute(int n) {
                    switch (n) {
                        case 1:
                            String name = getValue("Enter name: ");
                            bl = admin.searchBuyBook1(b -> ((BuyBook) b).getBookName().equalsIgnoreCase(name));
                            break;
                        case 2:
                            String type = getValue("Enter type: ");
                            bl = admin.searchBuyBook1(b -> b.getBookType().equalsIgnoreCase(type));
                            break;
                        case 3:
                            String aname = getValue("Enter Author name: ");
                            bl = admin.searchBuyBook1(b -> ((BuyBook) b).getName().equalsIgnoreCase(aname));
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    if (!bl.isEmpty()) {
                        Display(bl);
                        // Handle the case when the list is not empty
                    }
                    else System.out.println("Not Book are found.");
                }
            };
            menu.run();
        }
        
    
    private String getValue(String s) {
        System.out.println(s);
        return scanner.nextLine().trim();
    }
    
    
    // private void searchBuyBookByName() {
    //         System.out.print("Enter Book Name: ");
    //         String name = scanner.nextLine().trim();
    //         List<BuyBook> results = new ArrayList<>(); 
    //         results = admin.searchBuyBook1(p -> ((Book) p).getBookName().equalsIgnoreCase(name));
    //         display(results);
    // }
    //  private void searchBuyBookByType() {
    //         System.out.print("Enter Book Type: ");
    //         String type = scanner.nextLine().trim();
    //         List<BuyBook> results = admin.searchBuyBook1(p -> ((Book) p).getBookType().equalsIgnoreCase(type));
    //         display(results);
    // }
    //  private void searchBuyBookByAuthor() {
    //         System.out.print("Enter Book Auhtor Name: ");
    //         String aName = scanner.nextLine().trim();
    //         List<BuyBook> results = new ArrayList<>(); 
    //         results = admin.searchBuyBook1(p -> ((Book) p).getName().equalsIgnoreCase(aName));
    //         display(results);
    // }
    
    
    private void searchRentBook() throws ParseException{
        String[] mc = new String[] { "Search Rent books By Name","Search Rent books By Type","Search Rent Books By Author Name "};
        Menu menu = new Menu("Buy Book Searching",mc ){
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
                        default: System.out.println("Invalid choice. Please try again.");
                }

                    
                    }
    };
        menu.run();
    }
    private void searchRentBookByName() {
            System.out.print("Enter Book Name: ");
            String name = scanner.nextLine().trim();
            List<RentBook> results = admin.searchRentBook1(p -> ((Book) p).getBookName().startsWith(name));
            display(results);
        }
    private void searchRentBookByType(){
            System.out.print("Enter Book Type: ");
            String type = scanner.nextLine().trim();
            List<RentBook> results = admin.searchRentBook1(p -> ((Book) p).getBookType().startsWith(type));
            display(results);
    }
    private void searchRentBookByAuthor(){
            System.out.print("Enter Book Auhtor Name: ");
            String aName = scanner.nextLine().trim();
            List<RentBook> results = admin.searchRentBook1(p -> ((Book) p).getName().startsWith(aName));
            display(results);
    }
    private void addBookAndDelete() throws ParseException{
                Menu menu = new Menu("Change Book Information", new String[] { "Add books","Delete books"} ) {
                    @Override
                    public void execute(int n) throws ParseException {
                        switch (n) {
                        case 1 -> addBook();
                        case 2 -> {
                            String input = getValue(" Input Id want to delete :");
                            admin.deleteIDBook(input);
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                    }
                };    
                menu.run();
        }
        // private void writeData() throws ParseException {
        //     String bookFilePath = System.getProperty("user.dir") + File.separator + "RentedBook.txt";
        //     if (cm.writefile(bookFilePath)) {
        //         System.out.println("Success");
        //     } else {
        //         System.out.println("Error");
        //     }
        // }

private void writeData(){
    admin.writeBooksToFile();
    admin.writeCustomersToFile();
}
    

    public static void addBook() throws ParseException  {
        System.out.println(" +----ADDING BOOK----+");
        System.out.println("Enter book type: ");
        String type = scanner.nextLine();
        System.out.println("Enter book name: ");
        String bookname = scanner.nextLine();
        System.out.println("Enter author name: ");
        String authorname = scanner.nextLine();
        System.out.println(" Enter Price  :");
        String price = scanner.nextLine().trim();
        BuyBook b = new BuyBook(type,bookname, authorname,0,Integer.parseInt(price),parseDate("00/00/0000"), 0,"");
        RentBook r = new RentBook(type, bookname, authorname, Integer.parseInt(price), parseDate("00/00/0000"),"", 0, 0, 0, "00/00/0000", "00/00/0000") ;
        b.setBookNumber(b.getBookNumber()+1);
        r.setBookNumber(r.getBookNumber()+1);
        admin.addbook(b,r);

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
            List<BuyCustomer> results = admin.searchBuyCustomer(p -> ((Customer) p).getID().startsWith(id));
            display(results);
    }
    public void searchRentCustomer(){
            System.out.print("Enter Customer ID: ");
            String id = scanner.nextLine().trim();
            List<RentCustomer> results = admin.searchRentCustomer(p -> ((Customer) p).getID().startsWith(id));
            display(results);
    }

// public void changeCustomerInfor(){

// }

    public void sortBook(){

    }

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

    public void printBoughtBook(){

    }
    private void printBestSeller(){
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
    public  void Display(ArrayList<BuyBook> list) {
        System.out.println("List of results:");
        System.out.println("---------------------------------");
        if(!list.isEmpty()) {
            for (BuyBook a : list) {
                System.out.println(a.toString());
            } 
        }
        else
            System.out.println("List is empty");
        System.out.println("---------------------------------");
        System.out.println("Total : " + list.size() );
    }
}

