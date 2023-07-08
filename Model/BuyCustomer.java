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
<<<<<<< HEAD
    return "Buy Customer{" +
            "ID='" + ID +
            ", Số sách dã mua='" + BookNumber +
            ", Tiền sách mua='" + Cost  +
            '}';
    }
=======
    return "BuyCustomer {ID: " + ID +
            ", Number of rentbooks: " + BookNumberRent +
            ", Number of buybooks: " + BookNumberBuy +
            ", Paid price for books: " + Cost +
            ", Customer's review: " + Review +
            "}";
}
>>>>>>> 3c1c3244e7fac1aca3b9642b9d272c23ea09a98d
    
}
