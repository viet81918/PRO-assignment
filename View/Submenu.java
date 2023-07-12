package View;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;

public class Submenu extends Menu {

    @Override
    public void execute(int n) throws ParseException {
        String subMenu[]={"Nhan Vien","Khach Hang"};
        
        Menu m;
        m = new Menu("----------",subMenu) {

            @Override
            public void execute(int n) throws ParseException {
                switch (n){
                        case 1:{
                            cusRentBuy();
                            break;
                        }
                        case 2:{
                            staffMenu();
                            break;
                        }
                    }
                }
            };
            m.run();
    }

    public void cusRentBuy() throws ParseException{
        String rentBuyMenu[]={"Rent Book","Buy Book","Book review","Exit"};
        
        Menu m;
        m = new Menu("Chọn chức năng",rentBuyMenu) {

            @Override
            public void execute(int n) {
                switch (n){
                        case 1:{
                            
                            break;
                        }
                        case 2:{
                            break;
                        }
                        case 3:{
                            break;
                        }
                        case 4:{
                            System.out.println("Thanks for using!");
                            return;
                        }
                    }
                }
            };
            m.run();
    }

    public void staffMenu() throws ParseException{
        String staffMenu[]={"...","...","..."};

        Menu m;
        m = new Menu("Chọn chức năng",staffMenu) {

            @Override
            public void execute(int n) {
                switch (n){
                        case 1:{
                            
                            break;
                        }
                        case 2:{
                            break;
                        }
                        case 3:{
                            break;
                        }
                }
            }
        };
        m.run();
    }
   

    // private void ReadReviews() {
    //     File f = new File("C:\\Users\\OS\\Desktop\\Text.txt");
    //     try {
    //         BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
    //         String line = null;
    //         while (true) {
    //             line = br.readLine();
    //             if (line == null) {
    //                 break;
    //             } else {
    //                 System.out.println(line);
    //             }
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }   
}