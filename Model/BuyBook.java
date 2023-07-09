package Model;

import java.util.Date;

public class BuyBook extends Book {
    protected int SoldBookNumber;
        
    public BuyBook(){
        
    }
    

    public BuyBook(String BookType, String BookName, String AuthorName, String BookID, int BookNumber, double Price, Date Dob,int SoldBookNumber, String Review) {
        super(BookType, BookName, AuthorName, BookID, Price, Dob, Review, BookNumber);
        this.SoldBookNumber=SoldBookNumber;
    }

    public int getSoldBookNumber() {
        return SoldBookNumber;
    }

    public void setSoldBookNumber(int SoldBookNumber) {
        this.SoldBookNumber = SoldBookNumber;
    }

    public double getBuyPrice() {
        return SoldBookNumber*getPrice();
    }


    @Override
    public String toString() {
        return "---BUY BOOK----" +
               super.toString() + 
               "| SoldBook Number: " + SoldBookNumber + 
               "| Buy Price: " + getBuyPrice() +"\n";
    }

  
    
    
    
    
    
}
