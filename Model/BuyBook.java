package Model;

import java.util.Date;

public class BuyBook extends Book {
    protected int SoldBookNumber;
    private double BuyPrice;
        
    public BuyBook(){
        
    }

    public BuyBook(String BookType, String BookName, String AuthorName, String BookID, int BookNumber, double Price, Date Dob,int SoldBookNumber, double BuyPrice, String Review) {
        super(BookType, BookName, AuthorName, BookID, Price, Dob, Review, BookNumber);
        this.SoldBookNumber=SoldBookNumber;
        this.BuyPrice=BuyPrice;
    }

    public int getSoldBookNumber() {
        return SoldBookNumber;
    }

    public void setSoldBookNumber(int SoldBookNumber) {
        this.SoldBookNumber = SoldBookNumber;
    }

    public double getBuyPrice() {
        return BuyPrice=SoldBookNumber*Price;
    }

    public void setBuyPrice(double BuyPrice) {
        this.BuyPrice = BuyPrice;
    }

    @Override
    public String toString() {
        return "BuyBook{" +
               super.toString() + 
               "SoldBook Number: " + SoldBookNumber + 
               ", Buy Price: " + BuyPrice + '}';
    }

  
    
    
    
    
    
}
