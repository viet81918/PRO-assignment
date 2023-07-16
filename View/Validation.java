package View;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import Model.Book;
import Model.Customer;
import java.util.Scanner;
public class Validation {
    public static Scanner scanner = new Scanner(System.in);

    public static int getValidIntegerInput() {
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Invalid input. Please enter a valid positive integer.");
            }
        }
    }
    public boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    
    }

    

    public static double getValidDoubleInput() {
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                return Double.parseDouble(input);
            } else {
                System.out.println("Invalid input. Please enter a valid positive double.");
            }
        }
    }

    public static String getValidStringInput() {
    String input;
    while (true) {
        input = scanner.nextLine();
        if (!input.isEmpty() && Pattern.matches("[a-z A-Z]+", input)) {
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
    String regex = "KH\\d{3}";
    if (ID.matches(regex)) {
        return true;
    } else {
        System.out.println("Invalid ID format. ID must start with 'KH' followed by 3 digits.");
        return false;
    
}
}
 public static boolean checkType(String Type1) {
    String Type = Type1.toUpperCase();
    // Kiểm tra trường hợp empty input
    if (Type.isEmpty()) {
        System.out.println("ID is empty.");
        return false;
    }
    // Kiểm tra ID theo regex
    String regex = "KINH DI";
    String regex1 = "THIEU NHI";
    String regex2 = "LICH SU";
    String regex3 = "THIEU NHI";
    String regex4 = "KHOA HOC";
    if (Type.equalsIgnoreCase(regex) || Type.equalsIgnoreCase(regex1) || Type.equalsIgnoreCase(regex2) || Type.equalsIgnoreCase(regex3) || Type.equalsIgnoreCase(regex4)) {
        return true;
    } else {
        System.out.println("Invalid BOOK TYPE format.");
        return false;
    
}
}

   
    public static String inputDay() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setLenient(false);

    while (true) {
        String dob = scanner.nextLine();

        try {
            dateFormat.parse(dob);
            return dob;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");
        }
    }
}
    
}