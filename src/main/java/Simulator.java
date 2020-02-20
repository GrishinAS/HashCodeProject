import model.Book;
import model.Library;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simulator {
    List<Library> simulate(List<Library> libs, int days) {
        Library currentReg = null;
        int daysTillNextReg = 0;
        Set<Book> readyBooks = new HashSet<>();
        List<Library> libRegOrder = new ArrayList<>(libs);
        List<Library> readyLibs = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            System.out.println("Current day: " + i);
            // регаем либы
            if (currentReg == null) { //Если только начали регать
                if (!libRegOrder.isEmpty()) { //если хватило времени всех зарегать
                    currentReg = libRegOrder.remove(0);
                    daysTillNextReg = currentReg.getSignUpProcess();
                }
            }
            if (daysTillNextReg == 0) {
                readyLibs.add(currentReg);
                currentReg=null;
//                currentReg = libRegOrder.remove(0);
//                daysTillNextReg = currentReg.getSignUpProcess();
            }
            daysTillNextReg--;

            readyLibs.forEach(library -> {
                readyBooks.addAll(library.getMostScoreBooks(readyBooks));
            });
        }
        return readyLibs;
    }
}
