import model.Book;
import model.Library;

import java.io.*;
import java.util.ArrayList;

public class MainApplication {
    ArrayList<Book> allBooks = new ArrayList<>();
    ArrayList<Library> allLibs;
    int booksN;
    int libsN;
    int daysToScan;


    public static void main(String... args) throws Exception {
        MainApplication mainApplication = new MainApplication();
        mainApplication.run();
        System.out.println("Finish");
    }

    private void run() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("a_example.txt"))))) {
            String[] s = br.readLine().split(" ");
            booksN = Integer.parseInt(s[0]);
            libsN = Integer.parseInt(s[1]);
            daysToScan = Integer.parseInt(s[2]);
            String[] secondLine = br.readLine().split(" ");
            for (String score : secondLine) {
                Book e = new Book();
                e.setScore(Integer.parseInt(score));
                allBooks.add(e);
            }
            for (int i = 2; i < libsN * 2; i++) {
                String[] libLine = br.readLine().split(" ");
                if(i%2==0) {
                    Library e = new Library();

                    allLibs.add(e)
                }
            }
        }
    }
}

