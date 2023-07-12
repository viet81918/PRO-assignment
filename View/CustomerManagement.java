package View;

import java.util.Scanner;


public class CustomerManagement {
    private static Scanner sc;

    //
    //
    public CustomerManagement() {
        sc = new Scanner(System.in);
    }

    public void cusMenu() {
        String search[] = { "Tìm kiếm thể loại", "Tìm kiếm tên sách", "Tìm kiếm theo tác giả", "Tìm kiếm theo giá tiền",
                "Tìm kiếm theo năm xuất bản" };

        Menu m;
        m = new Menu("Finding Book", search) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1: {
                        bookType();
                        break;
                    }
                    case 2: {
                        System.out.print("Enter book's name:");
                        String Bname= sc.nextLine();
                        break;
                    }
                    case 3: {
                        System.out.print("Enter author:");
                        String author= sc.nextLine();
                        break;
                    }
                    case 4: {
                        bokkPrice();
                        break;
                    }
                    case 5: {
                        System.out.print("Enter year:");
                        int Byear= sc.nextInt();
                        break;
                    }
                }
            }
        };
        m.run();
    }

    public void bookType() {
        String bookType[] = { "Thieu Nhi", "Khoa Hoc", "Lich Su", "Kinh Di", "Quay Lai" };

        Menu m;
        m = new Menu("Choose type", bookType) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 5: {
                        cusMenu();
                        break;
                    }
                }
            }
        };
        m.run();
    }
    public void bokkPrice(){
        String bookPrice[] = {"20k -> 50k","50k -> 70k","70k -> 100k","Tren 100k","Quay lai"};

        Menu m;
        m = new Menu("Choose type", bookPrice) {
            @Override
            public void execute(int n) {
                switch () {
                    case 1: {
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 5: {
                        cusMenu();
                        break;
                    }
                }
            }
        };
        m.run();
    }
}