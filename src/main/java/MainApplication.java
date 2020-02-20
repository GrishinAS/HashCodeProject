import model.Book;
import model.Library;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {
    ArrayList<Book> allBooks = new ArrayList<>();//TODO init with right lenth
    ArrayList<Library> allLibs = new ArrayList<>(); //TODO init with right lenth
    int booksN;
    int libsN;
    int daysToScan;
    private static String INPUT_FILENAMEa = "a_example.txt";
    private static String INPUT_FILENAMEb = "b_read_on.txt";
    private static String INPUT_FILENAMEc = "c_incunabula.txt";
    private static String INPUT_FILENAMEd = "d_tough_choices.txt";
    private static String INPUT_FILENAMEe = "e_so_many_books.txt";
    private static String INPUT_FILENAMEf = "f_libraries_of_the_world.txt";
    static Simulator simulator;


    public static void main(String... args) throws Exception {
        List<String> files = Arrays.asList(
                //INPUT_FILENAMEa,
                //INPUT_FILENAMEb,
                //INPUT_FILENAMEc
                INPUT_FILENAMEd
//                INPUT_FILENAMEe,
//                INPUT_FILENAMEf
        );
        MainApplication mainApplication = new MainApplication();
        simulator = new Simulator();
        for(String file: files){
            mainApplication.parse(file);
            mainApplication.sumbit(file);
        }
    }

    private void sumbit(String file) {
        try (PrintWriter writer = new PrintWriter(file + "_submission.txt", "UTF-8")){
            List<Library> readyLibs = simulator.simulate(allLibs, daysToScan);
            writer.println(readyLibs.size());
            for(Library library: readyLibs){
                writer.print(library.getNumber()+" ");
                writer.println(library.getAlreadyGivenBooks().size());
                for (Book alreadyGivenBook : library.getAlreadyGivenBooks()) {
                    writer.print(alreadyGivenBook.getNumber()+" ");
                }
                if(library.getAlreadyGivenBooks().size()==0){
                    System.out.println("");
                }
                writer.print(" \n");
                //writer.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parse(String filename) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))))) {
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
            for (int i = 0; i <= libsN *2 - 1; i++) {
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

