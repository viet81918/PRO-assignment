package Model;

public class RentCustomer extends Customer {
    
    private  int RentBookNumber;
    private double RentPrice;
    
    
    public RentCustomer(String ID, int BookNumber,String Review, int RentBookNumber, double RentPrice){
        super( ID,BookNumber,Review);
        this.RentBookNumber=RentBookNumber;
        this.RentPrice=RentPrice;
    }
    
    

     public int getRentBookNumber() {
        return RentBookNumber;
    }



    public void setRentBookNumber(int rentBookNumber) {
        RentBookNumber = rentBookNumber;
    }



    public double getRentPrice() {
        return RentPrice;
    }



    public void setRentPrice(double rentPrice) {
        RentPrice = rentPrice;
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