package View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.Admin;
import Controller.CustomerManage;
import Model.BuyBook;
import Model.RentBook;


public class CustomerManagement extends Menu<String>   {
    static Scanner scanner = new Scanner(System.in);
    private Admin admin = new Admin();
    private final CustomerManage cm = new CustomerManage();
    static String[] me={"Want to buy.", "Want to hired."};
    public CustomerManagement()  throws IOException {
        super("Customer management", me);
    }
    @Override
    public void execute(int n) throws ParseException {
        switch(n) {
            case 1:{ cusBuyMenu();
            break;}
            case 2: {cusRentMenu();break;}
            default: System.out.println("Out of function!");
        }
    }
    private void cusBuyMenu() throws ParseException {
        String search[] = {"Hien thi tat ca sach ", "Tim kiem sach "," Them sach vao gio hang ", " Hien thi nhung review da viet",  " Hien thi Muc giam gia " , " Viet review sau khi nhap ID sach" };
        Menu m = new Menu("Buy Menu", search) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1: {
                        admin.getAllBooks();
                        break;
                    }
                    case 2: {
                        findBuyBooks();
                        break;
                    }
                    case 3: {
                        try {
                            AddBuyintoBag();
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 4: {

                        break;
                    }
                    case 5: {
                        break;
                    }
                    default:
                    break;
                }
            }

            
        };
        m.run();
    }
    private void cusRentMenu() throws ParseException {
        String[] search = {"Hien thi tat ca sach ", "Tim kiem sach "," Them sach vao gio hang ", " Hien thi nhung review da viet" , " Viet review sau khi nhap ID sach","Nhap thoi gian tra sach" };
        Menu m = new Menu("Rent Menu", search) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1: {
                        admin.getAllBooks();
                        break;
                    }
                    case 2: {
                        findRentBooks();
                        break;
                    }
                    case 3: {
                     addRentbag();
                        
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 5: {
                        break;
                    }
                    default:
                    break;
                }
            }

            
        };
        m.run();
    }
    private void findBuyBooks() throws ParseException {
        String[] mc = { "Search By Name","Search By Type", "Search By author","Search Price"};
        Menu menu = new Menu("Book Searching",mc ){
            ArrayList<BuyBook> bl = new ArrayList<>();
        
            @Override
            public void execute(int n) throws ParseException {
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
                    case 4 :
                        SearchBuyPrice();
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
    private void findRentBooks() throws ParseException {
        String[] mc = { "Search By Name","Search By Type", "Search By author"};
        Menu menu = new Menu("Book Searching",mc ){
            ArrayList<RentBook> bl = new ArrayList<>();
        
                @Override
                public void execute(int n) {
                    switch (n) {
                        case 1:
                            String name = getValue("Enter name: ");
                            bl = admin.searchRentBook1(b -> ((RentBook) b).getBookName().equalsIgnoreCase(name));
                            break;
                        case 2:
                            String type = getValue("Enter type: ");
                            bl = admin.searchRentBook1(b -> ((RentBook)b).getBookType().equalsIgnoreCase(type));
                            break;
                        case 3:
                            String aname = getValue("Enter Author name: ");
                            bl = admin.searchRentBook1(b -> ((RentBook) b).getName().equalsIgnoreCase(aname));
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    if (!bl.isEmpty()) {
                        Display1(bl);
                    }
                    else System.out.println("Not Book are found.");
                }
            };
            menu.run();
            }
    private void addRentbag() {
        // for(RentBook rb:admin.getRbooklist()) {
        //     cm.getRentlist().add(rb);
        //     for(RentBook rr: cm.getRentlist())
        //     System.out.println(rr.toString());
        // }
    }
    
    private void checkdis() throws ParseException {
        String id=getValue("Nhap vao id: ");
        cm.checkIddiscount(id);
    }
    
    private String getValue(String s) {
        System.out.println(s);
        return scanner.nextLine().trim();
    }
    private void SearchBuyPrice() throws ParseException{
        String search[] = {"Nhap khoang gia mua muon tim"," Nhap gia mua toi thieu muon tim " ," Nhap gia mua toi da muon tim "};
        Menu menu = new Menu("Search Buy Price", search){
            ArrayList<BuyBook> result = new ArrayList<>();
            @Override
            public void execute(int n) throws ParseException {

                switch (n) {
                    case 1 :
                    String a = getValue("Gia thap nhat :");
                    String b = getValue("Gia cao nhat : ");
                    result = admin.searchBuyBookByPriceRange1(Double.parseDouble(a),Double.parseDouble(b));
                    Display(result);
                    break;
                    case 2 :
                    String c = getValue("Gia toi thieu muon tim :");
                    result = admin.searchBuyBookByPriceRange2(Double.parseDouble(c));
                    Display(result);
                    break;
                    case 3 :
                    String d = getValue("Gia toi da muon tim ");
                    result = admin.searchBuyBookByPriceRange3(Double.parseDouble(d));
                    Display(result);
                    break;
                    default:
                    break;
        }

    }
};menu.run();
    }
    private void AddBuyintoBag() throws FileNotFoundException, ParseException{
        String id = getValue("Nhap id sach muon :");
        Display(cm.addBooktoBuy(id));
    }
    private void printBookReview(String id){
        admin.DisplayReviewByID(id);
    }
    private void Writereview(String idCus , String idBook){
        String review= getValue("Nhap cua ban ve cuon sach nay :");
        admin.writeReviewforCustomer(idCus,review);
        admin.WritereviewforBook(idBook, review);
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
    public  void Display1(ArrayList<RentBook> list) {
        System.out.println("List of results:");
        System.out.println("---------------------------------");
        if(!list.isEmpty()) {
            for (RentBook a : list) {
                System.out.println(a.toString());
            } 
        }
        else
            System.out.println("List is empty");
        System.out.println("---------------------------------");
        System.out.println("Total : " + list.size() );
    }
}