package Model;

public class RentCustomer extends Customer {
    double RentCost;
    
    public RentCustomer(String ID, int BookNumberRent, double RentCost, String Review) {
    super(ID, Review, BookNumberRent, 0, RentCost);
    this.RentCost = RentCost;
    // Other RentCustomer-specific initialization if needed
}

    @Override
    public int getBookNumberRent(){
        return BookNumberRent;
    }
    @Override
    public void setBookNumberRent(int BookNumberRent){
        this.BookNumberRent=BookNumberRent;
    }
    
    @Override
    public double getCost() {
        return RentCost;
    }
    public double getRentCost() {
        return RentCost;
    }
    @Override
    public void setCost(double RentCost){
        this.RentCost=RentCost;
    }
    @Override
public String toString() {
    return "RentCustomer {ID: " + ID +
            ", Number of rentbooks: " + BookNumberRent +
            ", Number of buybooks: " + BookNumberBuy +
            ", Paid price for books: " + Cost +
            ", Customer's review: " + Review +
            "}";
}
}