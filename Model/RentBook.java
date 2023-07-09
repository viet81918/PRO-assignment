
package Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentBook extends Book {
    private double RentPrice;
    private Date RentDay;
    private Date ReturnDay;
    private int RentBookNumber;
    
    public RentBook(){
        
    }
    
    
 
    public RentBook(String BookType, String BookName, String AuthorName, String BookID, double Price , Date Dob, String Review , int BookNumber, double RentPrice, int RentBookNumber, String RentDay, String ReturnDay) {
    super(BookType, BookName, AuthorName, BookID, Price, Dob, Review, BookNumber);
    this.RentPrice = RentPrice;
    this.RentBookNumber=RentBookNumber;
   
    try {
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

    public int getRentBookNumber() {
        return RentBookNumber;
    }

    public void setRentBookNumber(int RentBookNumber) {
        this.RentBookNumber = RentBookNumber;
    }


  
    public double getRentPrice(){
        return RentPrice;
    }
    public void setRentPrice(double RentPrice){
        this.RentPrice=RentBookNumber*(getPrice()-70/100);
    }
      public Date getRentDay() {
        return RentDay;
    }

    public void setRentDay(Date RentDay) {
        this.RentDay = RentDay;
    }
      public Date getReturnDay() {
        return ReturnDay;
    }

    public void setReturnDay(Date ReturnDay) {
        this.ReturnDay = ReturnDay;
    }
   
  @Override
    public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    String dateString = dateFormat.format(RentDay);
    String dateString1 = dateFormat.format(ReturnDay);
    return "---RENT BOOK---" +  
            super.toString() +
            "| Rent Book Number: " + RentBookNumber  +  
            "| Rent Price: " + RentPrice  +  
            "| Rent-day: " + dateString  +  
            "| Return-day: " + dateString1  +  
             "\n"   ;
    }

    
}
