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
    return "Buy Customer{" +
            "ID='" + ID +
            ", Số sách dã mua='" + BuyBookNumber +
            ", Tiền sách mua='" + BuyCost  +
            '}';
    }
    
}
