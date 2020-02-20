import model.Book;
import model.Library;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    void simulate(List<Library> libs, int days) {
        Library currentReg = null;
        int daysTillNextReg = 0;
        List<Book> readyBooks = new ArrayList<>();
        List<Library> libRegOrder = new ArrayList<>(libs);
        List<Library> readyLibs = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            // регаем либы
            if (currentReg == null) {
                if (!libRegOrder.isEmpty()) {
                    currentReg = libRegOrder.remove(0);
                    daysTillNextReg = currentReg.getSignUpProcess() - 1;
                }
            } else {
                if (daysTillNextReg == 0) {
                    readyLibs.add(currentReg);
                    currentReg = libRegOrder.remove(0);
                } else {
                    daysTillNextReg--;
                }
            }
            readyLibs.forEach(library -> {
                readyBooks.addAll(library.getMostScoreBooks(readyBooks));
            });
        }
    }
}
