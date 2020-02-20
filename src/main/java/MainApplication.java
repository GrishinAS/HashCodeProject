import model.Book;
import model.Library;

import java.io.*;
import java.util.ArrayList;

public class MainApplication {
    ArrayList<Book> allBooks = new ArrayList<>();//TODO init with right lenth
    ArrayList<Library> allLibs = new ArrayList<>(); //TODO init with right lenth
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
                Book newBook = new Book();
                newBook.setScore(Integer.parseInt(score));
                allBooks.add(newBook);
            }
            Library newLib = null;
            for (int i = 2; i <= libsN *2; i++) {
                String[] libLine = br.readLine().split(" ");
                if(i%2==0) {
                    newLib = new Library();
                    newLib.setSignUpProcess(Integer.parseInt(libLine[1]));
                    newLib.setBooksPerDay(Integer.parseInt(libLine[2]));
                }
                if(i%2==1) {
                    ArrayList<Book> booksForLib = new ArrayList<>();
                    for (String value : libLine) {
                        booksForLib.add(allBooks.get(Integer.parseInt(value)));
                    }
                    newLib.setBooks(booksForLib);
                    allLibs.add(newLib);
                }
            }
        }
    }
}

