package View;


import Model.Book;
import Model.BuyBook;
import Model.Customer;
import View.Menu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import Controller.Admin;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement extends Menu<String>{
    public CustomerManagement cusmanage;
    public CustomerManagement(){
    super("ADMIN MENU",new String[]{
        "Tim kiem sach","Chinh sua thong tin sach","Tim kiem thong tin khach hang","Chinh sua thong tin khach hang",
        "Phan loai cac dau sach ban chay","In tong doanh thu",
        "In sach co nguoi thue","In sach da ban duoc"});
    }
    private void displayMenu() {
        run();
    }

@Override
public void execute(String n) {
switch (n) {
    case "1":
        findBooks();
        break;
    case "2":
        changeBookInfor();
        break;
    case "3":
        searchCustomer();
        break;
    case "4":
        changeCustomerInfor();
        break;
    case "5":
        sortBook();
        break;
    case "6":
        printSale();
        break;
    case "7" :
        printRentedBook();
        break;
    case "8":
        printBoughtBook();
        break;
    case "0":
        System.out.println("Exiting...");
        break;
    default:
        System.out.println("Invalid choice. Please try again.");
        break;
}
}


public void findBooks(){
    Menu menu = new Menu("Book Searching", new String[] { "Search Buy books","Search Rent books","Exit"} ) {
        @Override
        public void execute(String n) {
            switch (n) {
                case "1":
                    searchBuyBook();
                    break;
                case "2":
                    searchRentBook();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    };
    menu.run();    
    }
private void searchBuyBook() {
        System.out.print("Enter Book Name: ");
        String name = scanner.nextLine().trim();
        List<BuyBook> results = Admin.searchBuyBook(p -> ((Book) p).getBookName().startsWith(name));
        Menu.display(results);
        }

private void searchRentBook() {
        }



public void changeBookInfor(){
     Menu menu = new Menu("Change Book Information", new String[] { "Add books","Delete books","Exit"} ) {
        @Override
        public void execute(String n) {
            switch (n) {
                case "1":
                    addBook();
                    break;
                case "2":
                    deleteBook();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    };
    menu.run();    
}
private void addBook() {
        }
private void deleteBook() {
        }


public void searchCustomer(){
      
}


public void changeCustomerInfor(){

}

public void sortBook(){

}

public double printSale(){

}

public void printRentedBook(){

}

public void printBoughtBook(){

}

}

