package View;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import Model.Customer;
import java.util.Scanner;
public class Validation {
    public static Scanner scanner;
    
    public static String getValidStringInput() {
    String input;
    while (true) {
        input = scanner.nextLine();
        if (!input.isEmpty() && Pattern.matches("[a-zA-Z]+", input)) {
            return input;
        } else {
            System.out.println("Invalid input. Please enter a valid non-empty string without special characters or digits.");
        }
    }
}
    public static boolean checkID(String ID) {
    // Kiểm tra trường hợp empty input
    if (ID.isEmpty()) {
        System.out.println("ID is empty.");
        return false;
    }
    // Kiểm tra ID theo regex
    String regex = "KH\\d{2}";
    if (ID.matches(regex)) {
        return true;
    } else {
        System.out.println("Invalid ID format. ID must start with 'KH' followed by 2 digits.");
        return false;
    
}
}
    public static boolean checkPhone(String phone) {
    // Kiểm tra trường hợp empty input
    if (phone.isEmpty()) {
        System.out.println("Phone number is empty.");
        return false;
    }
    
    // Kiểm tra số điện thoại theo regex
    String regex = "09\\d{8}";
    if (phone.matches(regex)) {
        return true;
    } else {
        System.out.println("Invalid phone number format. Phone number must start with '09' followed by 8 digits.");
        return false;
    }
}
    public static String inputDay() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    dateFormat.setLenient(false);

    while (true) {
        System.out.print("Enter Customer's rent day (dd-MM-yyyy): ");
        String dob = scanner.nextLine();

        try {
            dateFormat.parse(dob);
            return dob;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in dd-MM-yyyy format.");
        }
    }
    
}
}