package Model;

public class BuyCustomer extends Customer {
    double BuyCost;
    
    public BuyCustomer(String ID, int BookNumberBuy, double BuyCost, String Review) {
    super(ID, Review, 0, BookNumberBuy, BuyCost);
    this.BuyCost = BuyCost;
    // Other BuyCustomer-specific initialization if needed
}


    @Override
    public int getBookNumberBuy(){
        return BookNumberBuy;
    }
    @Override
    public void setBookNumberBuy(int BuyBookNumberBuy){
        this.BookNumberBuy=BookNumberBuy;
    }
    
    @Override
    public double getCost() {
        return BuyCost;
    }

    @Override
    public void setCost(double BuyCost){
        this.BuyCost=BuyCost;
    }
    public String toString() {
    return "BuyCustomer {ID: " + ID +
            ", Number of rentbooks: " + BookNumberRent +
            ", Number of buybooks: " + BookNumberBuy +
            ", Paid price for books: " + Cost +
            ", Customer's review: " + Review +
            "}";
}
    
}
