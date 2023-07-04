package Model;

public class BuyCustomer extends Customer {
     private int BuyBookNumber;
    double BuyCost;
    
    public BuyCustomer(int BuyBookNumber, double BuyCost){
        this.BuyBookNumber=BuyBookNumber;
        this.BuyCost=BuyCost;
    }
    @Override
    public int getBookNumber(){
        return BuyBookNumber;
    }
    @Override
    public void setBookNumber(int BuyBookNumber){
        this.BookNumber=BuyBookNumber;
    }
    
    @Override
    public double getCost() {
        return BuyCost;
    }

    @Override
    public void setCost(double RentCost){
        this.Cost=BuyCost;
    }
     @Override
    public String toString() {
    return "Rent Customer{" +
            "ID='" + ID +
            ", Số sách dã mua='" + BookNumber +
            ", Tiền sách mua='" + Cost  +
            '}';
    }
    
}
