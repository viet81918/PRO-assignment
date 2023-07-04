
package Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentBook extends Book {
    private double RentPrice;
    private int BookNumber;
    Date NgayThueSach;
    Date NgayTraSach;
    
    
 
    public RentBook(double RentPrice,int BookNumber, String NgayThueSach, String NgayTraSach) {
        
        this.RentPrice=RentPrice;
        this.BookNumber=BookNumber;
         try {
            this.NgayThueSach = parseDate(NgayThueSach);
            this.NgayTraSach = parseDate(NgayTraSach);
        } catch (ParseException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Date parseDate(String NgayThueSach) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dateFormat.parse(NgayThueSach);
     }
    public int getBookNumber(){
        return BookNumber;
    }
    public void setBookNumber(int BookNumber){
        this.BookNumber=BookNumber;
    }
    public double getRentPrice(){
        return RentPrice;
    }
    public void setRentPrice(double RentPrice){
        this.RentPrice=RentPrice;
    }
      public Date getNgayThueSach() {
        return NgayThueSach;
    }

    public void setNgayThueSach(Date NgayThueSach) {
        this.NgayThueSach = NgayThueSach;
    }
      public Date getNgayTraach() {
        return NgayTraSach;
    }

    public void setNgayTraSach(Date NgayTraSach) {
        this.NgayTraSach = NgayTraSach;
    }
  @Override
    public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
     String dobString = dateFormat.format(Dob);
    String dateString = dateFormat.format(NgayThueSach);
    String dateString1 = dateFormat.format(NgayTraSach);
    return "Rent Book(" +
            "The loai='" + TheLoai +
            "Book Name='" + BookName +
            ", Author Name='" + AuthorName +
             ", Book ID ='" + BookID +
            ", Rent Price='" + RentPrice  +
            ", Day of production='" + dobString  +
            ", Ngay Thue Sach='" + dateString  +
            ", Ngay Tra Sach='" + dateString1  +
            ", So luong trong kho='" + BookNumber +
            '}';
    }
}
