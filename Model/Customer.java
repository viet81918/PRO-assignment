package Model;

import Controller.Admin;
public class Customer extends Admin{
    String ID;
    String Review;
    int BookNumber;
    double Cost;
    
    public Customer(){
        super();
    }
    

    public Customer(String ID,String Review, int BookNumber, double Cost ) {
        super();
        this.ID = ID;
        this.BookNumber=BookNumber;
        this.Review=Review;
        this.Cost=Cost;         
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(int BookNumber) {
        this.BookNumber=BookNumber;
    }

    public double getCost() {
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
    return "Customer{" +
            "ID='" + ID +
            ", Số sách='" + BookNumber +
            ", Tiền sách='" + Cost  +
            ", Review ='" + Review  +
            '}';
    }

}

