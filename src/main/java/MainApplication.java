import model.Book;
import model.Library;

import java.io.*;
import java.util.ArrayList;

public class MainApplication {
    ArrayList<Book> allBooks = new ArrayList<>();
    public static void main(String... args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("a_example.txt"))))) {
            String line;
            while ((line = br.readLine()) != null) {
                new Book();
                new Library();
            }
        }
    }
}
