
package Model;

import Controller.Admin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Book extends Admin{
    Scanner scanner = new Scanner(System.in);
    String TheLoai;
    String BookName;
    String AuthorName;
    String BookID;
    String Review;
    double Price;
    int SoldBookNumber;
    int UnsoldBookNumber;
    Date Dob;
    
    public Book(){
        super();
    }

    public Book (String TheLoai,String BookName, String AuthorName,String HookID,String Review, double Price,int SoldBookNumber, int UnsoldBookNumber, String Dob) {
        super();
        this.TheLoai = TheLoai;
        this.BookName=BookName;
        this.AuthorName = AuthorName;
        this.Price = Price;
        this.BookID = BookID;
        this.Review=Review;
        this.SoldBookNumber= SoldBookNumber;
        this.UnsoldBookNumber=UnsoldBookNumber;
        try {
            this.Dob = parseDate(Dob);
        } catch (ParseException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private Date parseDate(String dob) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dateFormat.parse(dob);
     }
    public String getTheLoai() {
        return TheLoai ;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }
    
    public String getBookName() {
        return BookName ;
    }

    public void setBookName(String BookName) {
        this.BookName=BookName;
    }

    public String getName() {
        return AuthorName;
    }

    public void setName(String AuthorName) {
        this.AuthorName = AuthorName;
    }
    
    public String getBookID(){
        return BookID;
    }
    
    public void setBookID(String BookID){
        this.BookID=BookID;
    }
    public String getReview(){
        return Review;
    }
    
    public void setReview(String Review){
        this.Review=Review;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    public int getSoldBookNumber() {
        return SoldBookNumber;
    }
 
    public void setSoldBookNumber(int SoldBookNumber) {
        this.SoldBookNumber = SoldBookNumber;
    }
    
    public int getUnsoldBookNumber() {
        return UnsoldBookNumber;
    }
 
    public void setUnsoldBookNumber(int UnsoldBookNumber) {
        this.UnsoldBookNumber=UnsoldBookNumber;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }
    
    

    
    @Override
    public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String dobString = dateFormat.format(Dob);
    return "Book(" +
            "The loai='" + TheLoai +
            "Book Name='" + BookName +
            ", Author Name='" + AuthorName +
             ", Book ID ='" + BookID +
            ", Price='" + Price  +
            ", Day of production='" + dobString  +
            ", So luong da ban='" + SoldBookNumber +
            ", So luong trong kho='" + UnsoldBookNumber +
            ", Review sach='" + Review +
            '}';
}

}