package View;

import java.util.Scanner;

public abstract class Meun {
    protected Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
      }

    public abstract void executeMenu();

}
