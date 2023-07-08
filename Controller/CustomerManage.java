/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import Model.Customer;
import Model.RentBook;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


public class CustomerManage {
    List cuslist;
    List Buylist;
    List Rentlist;
    public CustomerManage() {
        cuslist = new LinkedList();
        Buylist= new LinkedList();
        Rentlist=new LinkedList();
                
    }
    
    public void deleteIDBook(String bookid) {
          Iterator<Book> iterator = cuslist.iterator();
    boolean found = false;
    while (iterator.hasNext()) {
        Book cus = iterator.next();
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
//    public void prinprice(Book B) {
//        for (Iterator it = cuslist.iterator(); it.hasNext();) {
//            B = (Book) it.next();
//            System.out.println(B.toString());
//        }
//    }
    public <T> ArrayList<T> search(Predicate<Object> p) {
        ArrayList<T> cuslistfind=new ArrayList<>();
            for(Object cus:cuslist) {
                if(p.test(cus)) 
                    cuslistfind.add((T) cus);
            }
            return cuslistfind;
        }
    public void rentnum(RentBook rb) {
        for (Iterator it = cuslist.iterator(); it.hasNext();) {
            rb = (RentBook) it.next();
            System.out.println(rb.getBookNumber());
        }
        }

    /**
     *
     * @param bb
     */
    public void BuyNum(BuyBook bb) {
        for (Iterator it = cuslist.iterator(); it.hasNext();) {
            bb = (BuyBook) it.next();
            System.out.println(bb.getBookNumber());
        }
       }
    public void printBuybook(String id) {
        Buylist=search((BuyBook bb)-> bb.getBookID().equalsIgnoreCase(id));
        for (Iterator it = Buylist.iterator(); it.hasNext();) {
            BuyBook b = (BuyBook) it.next();
            System.out.println(b.getPrice);
        }
    }
    public void printRentbook(String id) {
        Rentlist=search((RentBook rb)->rb.getBookID().equalsIgnoreCase(id));
    }
    public <T>void checkIddiscount(String id) {
        
            ArrayList<T> cusdisc;
            cusdisc = new ArrayList<>();
       cusdisc= search((Customer cus)->cus.getID().equalsIgnoreCase(id));
        
            int count = cusdisc.size();
        if(count>=3) {
            
        }
        else {
            
            }
        }
    
   }

