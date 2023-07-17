package View;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T> {

    protected static String title;
    protected ArrayList<T> mChon;

    protected Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public Menu(String td, String[] mc) {
        title = td;
        mChon = new ArrayList<>();
        for (String s : mc) {
            mChon.add((T) s);
        }

    }

    public void display() {
        System.out.println(title);
        System.out.println("---------------------------------");
        for (int i = 0; i <= mChon.size(); i++) {
            // Adjust the numbering to start from 1 and display "Exit" for 0
            if (i == mChon.size()) {
                System.out.println(i + 1 + ". Exit");
            } else {
                System.out.println((i + 1) + ". " + mChon.get(i));
            }
        }
        System.out.println("---------------------------------");
    }

    public int getSelected() {
        display();
        System.out.print("Enter selection: ");
        int input = Validation.getValidIntegerInput();
        return input;
    }

    public void run() throws ParseException {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n == mChon.size() + 1) {
                System.out.println("Thanks for using our app.");
                break;
            } else if (n > mChon.size() + 1) {
                System.out.println("Ivalid input, please enter again.");
                continue;
            }
        }
    }

    public abstract void execute(int n) throws ParseException;

}