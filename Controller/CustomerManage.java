package Controller;

import Model.BuyBook;
import Model.Customer;
import Model.RentBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.function.Predicate;

public class CustomerManage {
    private ArrayList<Customer> cuslist;
    private ArrayList<BuyBook> Buylist;
    private ArrayList<RentBook> Rentlist;
    private Admin admin = new Admin();

    public CustomerManage() {
        cuslist = new ArrayList<>();
        Buylist = new ArrayList<>();
        Rentlist = new ArrayList<>();

    }

    public void deleteIDBook(String bookid) throws ParseException {
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

    public ArrayList<BuyBook> addBooktoBuy(String id) {
        Buylist = admin.searchBuyBook1(p -> ((BuyBook) p).getBookID().equalsIgnoreCase(id));
        for (BuyBook b : admin.getBbooklist()) {
            Buylist.add(b);
        }
        return Buylist;
    }

    public void addBooktoRent(RentBook rb) {
        Rentlist.add(rb);
    }

    public void addRbooklist() throws IOException, NumberFormatException, ParseException {
        String path = System.getProperty("user.dir") + File.separator + "RentBook.txt";
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                // Process each line as needed
                // Assuming rent book data is comma-separated
                String[] data = line.split(";");
                RentBook book = new RentBook(data[0], data[1], data[2], Double.parseDouble(data[3]),
                        parseDate(data[4]), data[5], Integer.parseInt(data[6]),
                        Integer.parseInt(data[7]), Double.parseDouble(data[8]), data[9], data[10]);
                Rentlist.add(book);
            }
        }
    }

    public ArrayList<Customer> search(Predicate<Object> p) {
        ArrayList<Customer> cuslistfind = new ArrayList<>();
        for (Customer cus : cuslist) {
            if (p.test(cus))
                cuslistfind.add(cus);
        }
        return cuslistfind;
    }

    public ArrayList<BuyBook> searchBuybook(Predicate<BuyBook> p) {
        ArrayList<BuyBook> cuslistfind = new ArrayList<>();
        for (BuyBook cus : Buylist) {
            if (p.test(cus))
                cuslistfind.add(cus);
        }
        return cuslistfind;
    }

    public ArrayList<RentBook> searchRentbook(Predicate<RentBook> p) {
        ArrayList<RentBook> cuslistfind = new ArrayList<>();
        for (RentBook cus : Rentlist) {
            if (p.test(cus))
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
        for (BuyBook bb : Buylist) {
            System.out.println(bb.getBuyPrice());
        }
    }

    public void printPriceRent() {
        for (RentBook rb : Rentlist) {
            System.out.println(rb.getRentPrice());
        }
    }

    public void BuyNum(BuyBook bb) {
        for (Iterator it = Buylist.iterator(); it.hasNext();) {
            bb = (BuyBook) it.next();
            System.out.println(bb.getBookNumber());
        }
    }

    public void printBuybook(String id) throws ParseException {
        Buylist = searchBuybook((BuyBook bb) -> bb.getBookID().equalsIgnoreCase(id));
        for (Iterator it = Buylist.iterator(); it.hasNext();) {
            BuyBook b = (BuyBook) it.next();
            System.out.println(b.getBuyPrice());
        }
    }

    public void printRentbook(String id) {
        Rentlist = searchRentbook((RentBook rb) -> rb.getBookID().equalsIgnoreCase(id));
        for (Iterator it = Rentlist.iterator(); it.hasNext();) {
            RentBook b = (RentBook) it.next();
            System.out.println(b.getRentPrice());
        }
    }

    public boolean writefile(String path) throws ParseException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (RentBook book : Rentlist) {
                String line = book.getBookType() + " | " + book.getBookID() + " | " + book.getBookName() + " | " +
                        getDateFormat(book.getRentDay()) + " | " + getDateFormat(book.getReturnDay());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            return true;
            // } catch (FileNotFoundException e) {
            // System.out.println("Không tìm thấy file hoặc không có quyền truy cập đọc
            // file.");
            // e.printStackTrace();
            // return false;
        } catch (IOException ex) {
            System.out.println("Xảy ra sự cố khi đọc file. Có thể file đang được mở hoặc bị hỏng.");
            ex.printStackTrace();
            return false;
        }
    }

    public void checkIddiscount(String id) throws ParseException {
        double price;
        BuyBook bb = new BuyBook();
        ArrayList<Customer> cusdisc;
        cusdisc = new ArrayList<>();
        cusdisc = search(cus -> ((Customer) cus).getID().equalsIgnoreCase(id));
        int count = cusdisc.size();
        if (count >= 3) {
            System.out.println("Price: " + (Buylist.get((int) (bb.getPrice() - 50 / 100))));
        } else {
            System.out.println("Price: " + Buylist.get((int) bb.getPrice()));
        }
    }

    public static void setDayRentBook(RentBook book, String date, String returnDay) {
        try {
            Date rentalDate = parseDate(date);
            book.setRentDay(rentalDate);
            Date ReturnDay = parseDate(returnDay);
            book.setReturnDay(ReturnDay);

        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public Boolean checkNameBook(String bookName) {
        for (BuyBook b : admin.getBbooklist()) {
            if (b.getBookName().equalsIgnoreCase(bookName)) {
                return false;
            }
        }
        return true;
    }

    public static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateStr);
    }

    private String getDateFormat(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        return df.format(date);
    }

}