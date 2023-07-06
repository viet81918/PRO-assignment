package Model;

public abstract class Customer {
    String ID;
    String Review;
    int BookNumberRent;
    int BookNumberBuy;
    double Cost;
    
    public Customer(){
        super();
    }
    

   public Customer(String ID, String Review, int BookNumberRent, int BookNumberBuy, double Cost) {
    this.ID = ID;
    this.Review = Review;
    this.BookNumberRent = BookNumberRent;
    this.BookNumberBuy = BookNumberBuy;
    this.Cost = Cost;
}


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getBookNumberRent() {
        return BookNumberRent;
    }
    
    public void setBookNumberRent(int BookNumberRent){
        this.BookNumberRent=BookNumberRent;
    }
    
    public int getBookNumberBuy(){
        return BookNumberBuy;
    }

    public void setBookNumberBuy(int BookNumberBuyu) {
        this.BookNumberBuy=BookNumberBuy;
    }

    public double getCost(){
        return Cost;
    } 
    
    public void setCost(double Cost){
        this.Cost=Cost;
    }

    public String getReview(){
        return Review;
    }
    
    public void setReview(String Review){
        this.Review=Review;
    }
@Override
public String toString() {
    String customerType = "Customer";
    if (this instanceof RentCustomer) {
        customerType = "RentCustomer";
    } else if (this instanceof BuyCustomer) {
        customerType = "BuyCustomer";
    }

    return customerType + " {ID: " + ID +
            ", Number of rentbooks: " + BookNumberRent +
            ", Number of buybooks: " + BookNumberBuy +
            ", Paid price for books: " + Cost +
            ", Customer's review: " + Review +
            "}";
}


}

