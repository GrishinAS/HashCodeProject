import model.Book;
import model.Library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    ArrayList<Book> allBooks = new ArrayList<>();//TODO init with right lenth
    ArrayList<Library> allLibs = new ArrayList<>(); //TODO init with right lenth
    int booksN;
    int libsN;
    int daysToScan;
    private String INPUT_FILENAME = "a_example.txt";
    private String OUTPUT_FILENAME = INPUT_FILENAME + "_submission.txt";
    static Simulator simulator;


    public static void main(String... args) throws Exception {
        MainApplication mainApplication = new MainApplication();
        mainApplication.parse();
        simulator = new Simulator();
        mainApplication.sumbit();
    }

    private void sumbit() {
        try (PrintWriter writer = new PrintWriter(OUTPUT_FILENAME, "UTF-8")){
            List<Library> simulateResultLibs = simulator.simulate(allLibs, daysToScan);
            writer.println(simulateResultLibs.size());
            for(Library library: simulateResultLibs){
                writer.print(library.getNumber());
                writer.println(library.getAlreadyGivenBooks().size());
                for (Book alreadyGivenBook : library.getAlreadyGivenBooks()) {
                    writer.print(alreadyGivenBook.getNumber());
                    writer.print("\n");
                }

                writer.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parse() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(INPUT_FILENAME))))) {
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
            for (int i = 2; i <= libsN *2 + 1; i++) {
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

