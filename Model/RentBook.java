
package Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentBook extends Book {
    private double RentPrice;
    private int BookNumber;
    Date RentDay;
    Date ReturnDay;
    
    
 
    public RentBook(String BookType, String BookName, String AuthorName, String BookID, double RentPrice, int BookNumber, String Dob, String RentDay, String ReturnDay) {
    this.BookType = BookType;
    this.BookName = BookName;
    this.AuthorName = AuthorName;
    this.BookID = BookID;
    this.RentPrice = RentPrice;
    this.BookNumber = BookNumber;
    
    try {
        this.Dob = parseDate(Dob);
        this.RentDay = parseDate(RentDay);
        this.ReturnDay = parseDate(ReturnDay);
    } catch (ParseException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private Date parseDate(String dateString) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    return dateFormat.parse(dateString);
}


    public int getBookNumber(){
        return BookNumber;
    }
    public void setBookNumber(int BookNumber){
        this.BookNumber=BookNumber;
    }
    public double getRentPrice(){
        return RentPrice;
    }
    public void setRentPrice(double RentPrice){
        this.RentPrice=RentPrice;
    }
      public Date getRentDay() {
        return RentDay;
    }

    public void setRentDay(Date RentDay) {
        this.RentDay = RentDay;
    }
      public Date getNgayTraach() {
        return ReturnDay;
    }

    public void setReturnDay(Date ReturnDay) {
        this.ReturnDay = ReturnDay;
    }
  @Override
    public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
     String dobString = dateFormat.format(Dob);
    String dateString = dateFormat.format(RentDay);
    String dateString1 = dateFormat.format(ReturnDay);
    return "Rent Book {" +
            "Type of book: " + BookType +
            "Book's Name: " + BookName +
            ", Author's Name: " + AuthorName +
            ", Book ID: " + BookID +
            ", Rent Price: " + RentPrice  +
            ", Day of production='" + dobString  +
            ", Rent-day: " + dateString  +
            ", Return-day: " + dateString1  +
            ", Number of books in storage: " + BookNumber +
            '}';
    }
}
