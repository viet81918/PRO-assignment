package Model;

public  class Customer {
    private String ID;
    private String Review;
    private int BookNumber;

    public Customer() {
        super();
    }

    public Customer(String ID) {
        super();
        this.ID = ID;
    }

    public Customer(String ID, int BookNumber, String Review) {
        super();
        this.ID = ID;
        this.BookNumber = BookNumber;
        this.Review = Review;

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
        this.BookNumber = BookNumber;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String Review) {
        this.Review = Review;
    }

    @Override
    public String toString() {
        return "| ID: " + ID +
                "| Number of books used: " + BookNumber +
                "| Customer's review: " + Review;
    }
}
