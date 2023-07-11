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

public class BookStore {
    public BookStore cusmanage;

     public void Menu(){
        String [] mc = {"ADMIN MENU", "CUSTOMER MENU", };
        Menu m = new Menu ("====== MENU =====",mc) {
            @Override
            public void execute(int n) {
                switch(n){
                    case 1:
                       // CustomerMenu();
                        break;
                    case 2:
                        //AdminMenu();
                        break;
                }
            }
        };
       m.run(); 
    }

    public void CustomerMenu(){
        String [] mc={"Tim kiem sach","Chinh sua thong tin sach","Tim kiem thong tin khach hang","Chinh sua thong tin khach hang",
            "Phan loai cac dau sach ban chay","In tong doanh thu",
            "In sach co nguoi thue","In sach da ban duoc"};
        Menu m = new Menu("Customer Management",mc){
            @Override
        public void execute(int n) {
        switch (n) {
        case 1:
           // findBooks();
            break;
        case 2:
           // changeBookInfor();
            break;
        case 3:
           // searchCustomer();
            break;
        // case "4":
        //     changeCustomerInfor();
        //     break;
        case 5:
           // sortBook();
            break;
        case 6:
           // printSale();
            break;
        case 7 :
            //printRentedBook();
            break;
        case 8:
            //printBoughtBook();
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
                }
            }
        };
        m.run();
    }



 
    public void findBooks(){
        Menu menu = new Menu("Book Searching", new String[] { "Search Buy books","Search Rent books"} ){
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> searchBuyBook();
                    case 2 -> searchRentBook();
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
            };
            menu.run();
        }
private void searchBuyBook() {
        System.out.print("Enter Book Name: ");
        String name = scanner.nextLine().trim();
        List<BuyBook> results = Admin.searchBuyBook(p -> ((Book) p).getBookName().startsWith(name));
        
}

private void searchRentBook() {
        System.out.println("Enter Book Name: ");
        String name = scanner.nextLine().trim();
        List<RentBook> results = Admin.searchRentBook(p -> ((Book) p).getBookName().startsWith(name));
        
        }


        private void changeBookInfor(){
            Menu menu = new Menu("Change Book Information", new String[] { "Add books","Delete books"} ) {
                @Override
                public void execute(int n) {
                    switch (n) {
                       case 1 -> addBook();
                       case 2 -> deleteBook();
                       default -> System.out.println("Invalid choice. Please try again.");
                   }
                }
            };    
            menu.run();
       }



private void addBook() throws ParseException {
    System.out.println(" +----ADDING BOOK----+");
    System.out.println("Enter book type: ");
    String type = scanner.nextLine();
    System.out.println("Enter book name: ");
    String bookname = scanner.nextLine();
    System.out.println("Enter author name: ");
    String authorname = scanner.nextLine();
    BuyBook b = new BuyBook(type,bookname, authorname,"",0,0,parseDate("00/00/0000"), 0,"");
    addBbook(b);
}
private void addBbook(BuyBook b) {
}
private void deleteBook() {
        System.out.println(" +----DELETING BOOK----+");
        System.out.println("Enter Book Name: ");
        String name = scanner.nextLine().trim();
        List<BuyBook> results = Admin.searchBuyBook(p -> ((Book) p).getBookName().startsWith(name));
        Admin.getBookName().remove(results);
        System.out.println("+-------------------------------+");
        System.out.println("Deleted book successfully");
        }


        public void searchCustomer(){
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
        Menu.display(results);

}
public void searchRentCustomer(){
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine().trim();
        List<RentCustomer> results = Admin.searchRentCustomer(p -> ((Customer) p).getID().startsWith(id));
        Menu.display(results);
}

// public void changeCustomerInfor(){

// }

public void sortBook(){

}

public double printSale(){

}

public void printRentedBook(){

}

public void printBoughtBook(){

}
private static Date parseDate(String dateStr) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    return dateFormat.parse(dateStr);
}


}

