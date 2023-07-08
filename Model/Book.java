
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Book {
<<<<<<< HEAD
    static Scanner scanner = new Scanner(System.in);
    private String TheLoai;
    private String BookName;
    private String AuthorName;
    private String BookID;
    private String Review;
    private double Price;
    private int SoldBookNumber;
    private int UnsoldBookNumber;
    private Date Dob;
=======
    Scanner scanner = new Scanner(System.in);
    String BookType;
    String BookName;
    String AuthorName;
    String BookID;
    String Review;
    double Price;
    int SoldBookNumber;
    int UnsoldBookNumber;
    Date Dob;
>>>>>>> 3c1c3244e7fac1aca3b9642b9d272c23ea09a98d
    
    public Book(){
        
    }
    public Book (String BookType,String BookName, String AuthorName,String BookID, double Price, String Dob,int SoldBookNumber, int UnsoldBookNumber,String Review) {
        super();
        this.BookType = BookType;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(dob);
     }
    public String getBookType() {
        return BookType ;
    }

    public void setBookType(String BookType) {
        this.BookType = BookType;
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
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String dobString = dateFormat.format(Dob);
    return "Book {" +
            "Type of book: " + BookType +
            "Book's Name: " + BookName +
            ", Author's Name: " + AuthorName +
            ", Book ID: " + BookID +
            ", Price: " + Price  +
            ", Day of production: " + dobString  +
            ", Number of sold books: " + SoldBookNumber +
            ", Number of unsold books: " + UnsoldBookNumber +
            ", Customer's reivew: " + Review +
            '}';
}

}