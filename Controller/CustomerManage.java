
package Controller;

import Model.BuyBook;
import Model.Customer;
import Model.RentBook;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.function.Predicate;


public class CustomerManage  {
    ArrayList<Customer> cuslist;
    ArrayList<BuyBook> Buylist;
    ArrayList<RentBook> Rentlist;
    public CustomerManage() {
        cuslist = new ArrayList<>();
        Buylist= new ArrayList<>();
        Rentlist=new ArrayList<>();
                
    }
    
    public void deleteIDBook(String bookid) {
          Iterator<BuyBook> iterator = Buylist.iterator();
    boolean found = false;
    while (iterator.hasNext()) {
        BuyBook cus = iterator.next();
        if (cus.getBookID().equals(bookid)) {
            iterator.remove();
            System.out.println("Sach co mã số " + bookid + " đã được xóa.");
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Không tìm thấy sach có mã số " + bookid);
    }
    }
    public void addcusID(Customer c) {
        cuslist.add(c);
    }
    public void addBooktoBuy(BuyBook bb) {
        Buylist.add(bb);
    }
    public void addBooktoRent(RentBook rb) {
        Rentlist.add(rb);
    }

    public  ArrayList<Customer> search(Predicate<Object> p) {
        ArrayList<Customer> cuslistfind=new ArrayList<>();
            for(Customer cus: cuslist) {
                if(p.test(cus)) 
                    cuslistfind.add(cus);
            }
            return cuslistfind;
        }
        public  ArrayList<BuyBook> searchBuybook(Predicate<BuyBook> p) {
        ArrayList<BuyBook> cuslistfind=new ArrayList<>();
            for(BuyBook cus: Buylist) {
                if(p.test(cus)) 
                    cuslistfind.add(cus);
            }
            return cuslistfind;
        }
        public  ArrayList<RentBook> searchRentbook(Predicate<RentBook> p) {
        ArrayList<RentBook> cuslistfind=new ArrayList<>();
            for(RentBook cus: Rentlist) {
                if(p.test(cus)) 
                    cuslistfind.add(cus);
            }
            return cuslistfind;
        }
    public void rentnum(RentBook rb) {
        for (Iterator it = Rentlist.iterator(); it.hasNext();) {
            rb = (RentBook) it.next();
            System.out.println(rb.getBookNumber());
        }
        }
    public void printPriceBuy() {
        for(BuyBook bb:Buylist) {
            System.out.println(bb.getBuyPrice());
        }
    }
    public void printPriceRent() {
        for(RentBook rb:Rentlist) {
            System.out.println(rb.getRentPrice());
        }
    }

   
    public void BuyNum(BuyBook bb) {
        for (Iterator it = Buylist.iterator(); it.hasNext();) {
            bb = (BuyBook) it.next();
            System.out.println(bb.getBookNumber());
        }
       }
    public void printBuybook(String id) {
        Buylist=searchBuybook((BuyBook bb)->bb.getBookID().equalsIgnoreCase(id));
        for (Iterator it = Buylist.iterator(); it.hasNext();) {
            BuyBook b = (BuyBook) it.next();
            System.out.println(b.getBuyPrice());
        }
    }
    public void printRentbook(String id) {
        Rentlist=searchRentbook((RentBook rb)->rb.getBookID().equalsIgnoreCase(id));
        for (Iterator it = Rentlist.iterator(); it.hasNext();) {
            RentBook b = (RentBook) it.next();
            System.out.println(b.getRentPrice());
        }
    }
    

    public void checkIddiscount(String id) {
            double price;
            BuyBook bb=new BuyBook ();
            ArrayList<Customer> cusdisc;
            cusdisc = new ArrayList<>();
       cusdisc= search( cus-> ((Customer) cus).getID().equalsIgnoreCase(id));
            int count = cusdisc.size();
        if(count>=3) {
             System.out.println("Price: "+ (Buylist.get((int) (bb.getPrice()-50/100))));
        }
        else {
            System.out.println("Price: "+ Buylist.get((int) bb.getPrice()));
            }
        }
    public static void setDayRentBook(RentBook book, String date,String returnDay) {
        try {
            Date rentalDate = parseDate(date);
            book.setRentDay(rentalDate);
            Date ReturnDay = parseDate(returnDay);
            book.setReturnDay(ReturnDay);

        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }
    
}