
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Book {
    Scanner scanner = new Scanner(System.in);
    protected static int BookNumber;
    private String BookType;
    private String BookName;
    private String AuthorName;
    private String BookID;
    protected static String Review;
    protected static double Price;
    protected static Date Dob;
    
    public Book(){
        super();
    }
    public Book (String BookType,String BookName, String AuthorName,String BookID, double Price, Date Dob, String Review, int BookNumber) {
        super();
        Book.BookNumber=BookNumber;
        this.BookType = BookType;
        this.BookName=BookName;
        this.AuthorName = AuthorName;
        Book.Price = Price;
        this.BookID = BookID;
        Book.Review=Review;
        this.Dob = Dob;
        
    }
 

    public int getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(int BookNumber) {
        this.BookNumber = BookNumber;
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
            "Books in storage: " + BookNumber +
            ", Author's Name: " + AuthorName +
            ", Book ID: " + BookID +
             ", Books's : " + Price +
            ", Day of production: " + dobString  +
            ", Customer's reivew: " + Review +
            '}';
}

}