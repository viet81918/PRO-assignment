package Model;

import java.text.ParseException;
import java.util.Date;

public class BuyBook extends Book {
    protected int SoldBookNumber;
        
    public BuyBook() throws ParseException{}
    

    public BuyBook(String BookType, String BookName, String AuthorName, int BookNumber, double Price, Date Dob,int SoldBookNumber, String Review) throws ParseException {
        super(BookType, BookName, AuthorName, Price, Dob, Review, BookNumber);
        this.SoldBookNumber=SoldBookNumber;
    }

    public int getSoldBookNumber() {
        return SoldBookNumber;
    }

    public void setSoldBookNumber(int SoldBookNumber) {
        this.SoldBookNumber = SoldBookNumber;
    }

    public double getBuyPrice() {
        return getSoldBookNumber()*getPrice();
    }


    @Override
    public String toString() {
        return "---BUY BOOK----" +
               super.toString() + 
               "| SoldBook Number: " + SoldBookNumber + 
               "| Buy Price: " + getBuyPrice() +"\n";
    }

  
    
    
    
    
    
}
