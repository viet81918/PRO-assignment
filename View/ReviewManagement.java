package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.Scanner;

import Controller.Admin;
import Controller.CustomerManage;

public class ReviewManagement extends Menu<String> {
    static Scanner scanner = new Scanner(System.in);
    static Validation val = new Validation();
    private Admin admin = new Admin();
    private final CustomerManage cm = new CustomerManage();
    static String subMenu[]={"Hiển thị những review đã viết ", "Viết Review ", "Xuất vào File"};
    public ReviewManagement() {
        super("ReviewTime",subMenu );
    }
        
            @Override
            public void execute(int n) throws ParseException {
                switch (n){
                        case 1:{
                            admin.printBookReview();
                            break;
                        }
                        case 2:{
                            System.out.println("Enter book name: ");
                            String bookname = val.getValidStringInput();
                            System.out.println("Nhap review ve cuon sach nay");
                            String review = val.getValidStringInput();
                            admin.addBookReview(bookname,review);
                            break;}
                        case 3 :
                        {try {
                            admin.writeBookReview();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        }
                        default:{
                            break;
                        }

                        }
                    }
 
}  