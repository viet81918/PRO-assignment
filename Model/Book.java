
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Book  {
    Scanner scanner = new Scanner(System.in);
    private  int BookNumber;
    private String BookType;
    private String BookName;
    private String AuthorName;
    private String BookID;
    private  String Review;
    private  double Price;
    private Date Dob;
    public static int current_id = 0;
    
    public Book() throws ParseException{
        super();
    }
    public Book (String BookType,String BookName, String AuthorName, double Price, Date Dob, String Review, int BookNumber) throws ParseException {
        super();
        this.BookNumber=BookNumber;
        this.BookType = BookType;
        this.BookName=BookName;
        this.AuthorName = AuthorName;
        this.Price = Price;
        this.Review=Review;
        this.Dob = Dob;
        setBookID(this.getBookType());
    }
 

    public  int getBookNumber() {
        return this.BookNumber;
    }

    public void setBookNumber(int bn) {
        this.BookNumber = bn;
    }
     
    public String getBookType() {
        return this.BookType ;
    }

    public void setBookType(String BookType) {
        this.BookType = BookType;
    }
    
    public String getBookName() {
        return this.BookName ;
    }

    public void setBookName(String BookName) {
        this.BookName=BookName;
    }

    public String getName() {
        return this.AuthorName;
    }

    public void setName(String AuthorName) {
        this.AuthorName = AuthorName;
    }
    
    public String getBookID() {
        return this.BookID;
    }
    public static String getNameType(String typeName)  {
        StringBuilder res = new StringBuilder();
        res.append(typeName.charAt(0)); 
        for(int i = 1; i < typeName.length();i ++) {
            if(typeName.charAt(i) == ' ') {
                res.append(typeName.charAt(i + 1));
            }
        }
        return res.toString().toUpperCase();
    }  
    public void setBookID(String BookType) {
        Book.current_id ++;
        this.BookID=getNameType(BookType)+ Book.current_id;
    }
    public String getReview(){
        return this.Review;
    }
    
    public void setReview(String Review){
        this.Review=Review;
    }

    public double getPrice() {
        return this.Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }  
   

    public Date getDob() {
        return this.Dob;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }
    
    

    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dobString = dateFormat.format(Dob);
        return "| Type of book: " + BookType +
                " | Book's Name: " + BookName +
                " | Books in storage: " + BookNumber +
                " | Author's Name: " + AuthorName +  
                " | Book ID: " + getBookID() + 
                " | Books's Price : " + Price +
                " | Day of production: " + dobString + 
                " | Customer's review: " + Review 
                ;
    }
    
    }
    

