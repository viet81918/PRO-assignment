package View;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.Admin;
import Controller.CustomerManage;
import Model.BuyBook;


public class CustomerManagement {
    static Scanner scanner = new Scanner(System.in);
    static Admin admin = new Admin();
    private final CustomerManage cm = new CustomerManage();
    public CustomerManagement() {
    }

    public void cusMenu() throws ParseException {
        String search[] = {"Hien thi tat ca sach ", "Tim kiem sach "," Them sach vao gio hang ", "HIen thi sach trong gio ", " Hien thi nhung review da viet",  " Hien thi Muc giam gia " , " Viet review sau khi nhap ID sach" };
        Menu m = new Menu("Customer Menu", search) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1: {
                        admin.getAllBooks();
                        break;
                    }
                    case 2: {
                        findBooks();
                        break;
                    }
                    case 3: {
                        System.out.print("Enter author:");
                        String author= sc.nextLine();
                        break;
                    }
                    case 4: {
                        bookPrice();
                        break;
                    }
                    case 5: {
                        System.out.print("Enter year:");
                        int Byear= sc.nextInt();
                        break;
                    }
                }
            }

            
        };
        m.run();
    }
    private void findBooks() {
        String[] mc = new String[] { "Search By TYpe","Search By Name", "Search By author","Search buy Price", "Search By Year"};
        enu menu = new Menu("Book Searching",mc ){
            ArrayList<BuyBook> result = new ArrayList<>();
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1:
                         String type= getValue("Enter the type of book you want to search for");
                         result = admin.searchBuyBook1(b -> ((BuyBook) b).getBookType().equalsIgnoreCase(type));
                        break;
                    case 2:
                        String name = getValue("Enter the name of book you want to search for");
                         result = admin.searchBuyBook1(b -> ((BuyBook) b).getName().equalsIgnoreCase(type));
                        break;
                    case 3 :
                        String author = getValue("Enter the name of book you want to search for");
                         result = admin.searchBuyBook1(b -> ((BuyBook) b).getBookName().equalsIgnoreCase(type));
                        break;
                    case 4 : 
                        break;
                    case 5 :
                        String year = getValue("Enter Name of the ")
                        break;
                    default: System.out.println("Invalid choice. Please try again.");
                }
            }
            };
            menu.run();
            }
    
    
    
    private String getValue(String s) {
        System.out.println(s);
        return scanner.nextLine().trim();
    }
}