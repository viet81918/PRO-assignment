package Model;

public class BuyCustomer extends Customer {
    BuyBook bb = new BuyBook();
    private double BuyPrice;
    private int SoldBookNumber;
    
    
    public BuyCustomer(String ID, int BookNumber,String Review,int SoldBookNumber,double BuyPrice){
        super(ID, BookNumber, Review);
        this.BuyPrice=BuyPrice;
        this.SoldBookNumber=SoldBookNumber;
    }

   
    
    


    public double getBuyPrice() {
        return BuyPrice;
    }






    public void setBuyPrice(double buyPrice) {
        BuyPrice = buyPrice;
    }






    public int getSoldBookNumber() {
        return SoldBookNumber;
    }






    public void setSoldBookNumber(int soldBookNumber) {
        SoldBookNumber = soldBookNumber;
    }






    @Override
    public String toString() {
    return "Buy Customer{" +
            super.toString() +
            "Buy book number: " + getSoldBookNumber() +
            "Buy price: " +  getBuyPrice() +
            '}';
    }
}

    

   
// }KH001;2;Tiem sach Viet Nguyen co chat luong phuc vu tot;1;190.000
