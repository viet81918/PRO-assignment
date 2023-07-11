package View;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import Model.Book;
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

public static boolean checkBookID(String ID) {
    // Kiểm tra trường hợp empty input
    if (ID.isEmpty()) {
        System.out.println("ID is empty.");
        return false;
    }
    // Kiểm tra ID theo regex
    String regex = "TN\\d{2}";
    String regex1 = "LS\\d{2}";
    String regex2 = "KH\\d{2}";
    String regex3 = "KD\\d{2}";
    if (ID.matches(regex) || ID.matches(regex1)|| ID.matches(regex2) || ID.matches(regex3)) {
        return true;
    } else {
        System.out.println("Invalid ID format. ID must start with the first 2 characters of book type followed by 2 digits.");
        return false;
}}
    public static boolean checkSimilarBookAndID(Book b , String ID){
    if (b.getBookType() == "Kinh Di" && ID.matches("KD\\d{2}")){
        return true;
    }
    if (b.getBookType() == "Lich Su" && ID.matches("LS\\d{2}")){
        return true;
    }
    if (b.getBookType() == "Khoa Hoc" && ID.matches("KH\\d{2}")){
        return true;
    }
    if (b.getBookType() == "Thieu Nhi" && ID.matches("TN\\d{2}")){
        return true;
    }
    return false;
}
   
    public static String inputDay() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    dateFormat.setLenient(false);

    while (true) {
        System.out.print("Enter Customer's return day (dd-MM-yyyy): ");
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