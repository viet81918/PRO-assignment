package Model;

public class RentCustomer extends Customer {
    private int RentBookNumber;
    double RentCost;
    
    public RentCustomer(int RentBookNumber, double RentCost){
        this.RentBookNumber=RentBookNumber;
        this.RentCost=RentCost;
    }
    @Override
    public int getBookNumber(){
        return RentBookNumber;
    }
    @Override
    public void setBookNumber(int RentBookNumber){
        this.BookNumber=RentBookNumber;
    }
    
    @Override
    public double getCost() {
        return RentCost;
    }

    @Override
    public void setCost(double RentCost){
        this.Cost=RentCost;
    }
     @Override
    public String toString() {
    return "Rent Customer{" +
            "ID='" + ID +
            ", Số sách dã thuê='" + BookNumber +
            ", Tiền sách thuê='" + Cost  +
            '}';
    }
}