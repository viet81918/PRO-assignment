
package model;
public class Customer {
    int customerID;
    String name;
    int Phone;

    public Customer(int customerID, String name, int Phone) {
        this.customerID = customerID;
        this.name = name;
        this.Phone = Phone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", name=" + name + ", Phone=" + Phone + '}';
    }
    
}
