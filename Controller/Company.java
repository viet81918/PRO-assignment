
package Controller;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class Company {
    private List<Customer> customers;
    public List<Customer> getCustomers() {
        return customers;
    }

    public Company() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void printCustomers() {
    int totalCustomers = customers.size();
    for (Customer customer : customers) {
        System.out.println(customer.toString());
    }
       System.out.println("Total : " + totalCustomers + " Customers." );
       System.out.println("------------------");
}

    public List<Customer> searchCustomersByCriteria(String criteria) {
        List<Customer> matchedCustomers = new ArrayList<>();
        for (Customer customer : customers) {
 if (customer.getName().equalsIgnoreCase(criteria) || 
    (isNumeric(criteria) && (customer.getPhone() == Integer.parseInt(criteria) || customer.getCustomerID() == Integer.parseInt(criteria)))) {
    matchedCustomers.add(customer);
}

        }
        return matchedCustomers;
    }
    private static boolean isNumeric(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

}