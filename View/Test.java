package View;

import java.io.IOException;
import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException, IOException {
        BookStore bookStore = new BookStore<>();
        bookStore.Menu();
    }
}