package Model;

public class BuyCustomer extends Customer {
    BuyBook bb = new BuyBook();
    protected static double BuyPrice;
    protected static int SoldBookNumber;
    
    
    public BuyCustomer(String ID, int BookNumber,String Review,int SoldBookNumber,double BuyPrice){
        super(ID, BookNumber, Review);
        this.BuyPrice=BuyPrice;
        this.SoldBookNumber=SoldBookNumber;
    }

    public double getBuyPrice() {
        return bb.getBuyPrice();
    }

    public void setBuyPrice(double BuyPrice) {
        this.BuyPrice=BuyPrice;
    }

    public int getSoldBookNumber() {
        return bb.getSoldBookNumber();
    }

    public void setSoldBookNumber(int SoldBookNumber) {
        this.SoldBookNumber = SoldBookNumber;
    }
    
     @Override
    public String toString() {
    return "Rent Customer{" +
            super.toString() +
            "Buy book number: " + getSoldBookNumber() +
            "Buy price: " +  getBuyPrice() +
            '}';
    }

    

   
}