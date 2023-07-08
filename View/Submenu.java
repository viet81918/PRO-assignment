package view;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Submenu extends Menu {

    @Override
    public void executeMenu() {
        while (true) {
            System.out.println("**********Menu**********");
            System.out.println("1. Buy book");
            System.out.println("2. Rent book");
            System.out.println("3. Read book reviews");
            System.out.println("4. Exit");
            System.out.println("************************");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    ReadReviews();
                case 4:
                    System.out.println("Thanks for choosing!!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }

    }

    private void ReadReviews() {
        File f = new File("C:\\Users\\OS\\Desktop\\Text.txt");
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = null;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
