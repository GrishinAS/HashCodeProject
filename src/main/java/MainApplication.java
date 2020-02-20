import model.Book;
import model.Library;

import java.io.*;
import java.util.ArrayList;

public class MainApplication {
    ArrayList<Book> allBooks = new ArrayList<>();
    ArrayList<Library> allLibs;
    int daysToScan;
    public static void main(String... args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("a_example.txt"))))) {
            String line;
            int lineCounter = 0;
            while ((line = br.readLine()) != null) {
                if(lineCounter==0) {
                    String[] firstLine = line.split(" ");

                }
                new Book();
                new Library();
                lineCounter++;
            }
        }
    }
}
