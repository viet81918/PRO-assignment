package Model;

public class BuyCustomer extends Customer {
     private int BuyBookNumber;
    double BuyCost;
    
    public BuyCustomer(String ID,int BuyBookNumber, double BuyCost){
        this.ID=ID;
        this.BuyBookNumber=BuyBookNumber;
        this.BuyCost=BuyCost;
        
    }
    @Override
    public int getBookNumber(){
        return BuyBookNumber;
    }
    @Override
    public void setBookNumber(int BuyBookNumber){
        this.BuyBookNumber=BuyBookNumber;
    }
    
    @Override
    public double getCost() {
        return BuyCost;
    }

    @Override
    public void setCost(double BuyCost){
        this.BuyCost=BuyCost;
    }
     @Override
    public String toString() {
    return "Buy Customer {" +
            "Customer's ID: " + ID +
            ", Number of bought books: " + BuyBookNumber +
            ", Paid price for bought books: " + BuyCost  +
            '}';
    }
    
}
