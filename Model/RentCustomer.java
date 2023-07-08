package Model;

public class RentCustomer extends Customer {
    RentBook rb = new RentBook();
    protected static int RentBookNumber;
    protected static double RentPrice;
    
    
    public RentCustomer(String ID, int BookNumber,String Review, int RentBookNumber, double RentPrice){
        super( ID,BookNumber,Review);
        this.RentBookNumber=RentBookNumber;
        this.RentPrice=RentPrice;
    }
    public double getRentPrice() {
        return rb.getRentPrice();
    }

    public void setRentPrice(double RentPrice) {
        this.RentPrice=RentPrice;
    }

    public int getRentBookNumber() {
        return rb.getRentBookNumber();
    }

    public void setRentBookNumber(int RentBookNumber) {
        this.RentBookNumber = RentBookNumber;
    }
    
    

     @Override
    public String toString() {
    return "Rent Customer{" +
            super.toString() +
            "Rent book number: " + getRentBookNumber() +
            "Rent price: " + getRentPrice() +
            '}';
    }

    

   
}