package model;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private int number;
    private ArrayList<Book> books = new ArrayList<>();

    public Set<Book> getAlreadyGivenBooks() {
        return alreadyGivenBooks;
    }

    public void setAlreadyGivenBooks(Set<Book> alreadyGivenBooks) {
        this.alreadyGivenBooks = alreadyGivenBooks;
    }

    private Set<Book> alreadyGivenBooks = new HashSet<>();
    private int signUpProcess;
    private int booksPerDay;
    static int indexOfLib;

    public Library() {
        number = indexOfLib++;
    }

    public List<Book> getMostScoreBooks(Set<Book> alreadyScannedBooks){
        List<Book> collect = books.stream()
                .filter(e -> !alreadyScannedBooks.contains(e))
                .sorted(Comparator.comparingInt(book->-book.number))
                .limit(booksPerDay)
                .collect(Collectors.toList());

        if(collect.isEmpty()){
                    collect = books.stream()
                    .sorted(Comparator.comparingInt(book->-book.number))
                    .limit(booksPerDay)
                    .collect(Collectors.toList());
        }
        alreadyGivenBooks.addAll(collect);
        return collect;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public int getSignUpProcess() {
        return signUpProcess;
    }

    public void setSignUpProcess(int signUpProcess) {
        this.signUpProcess = signUpProcess;
    }

    public int getBooksPerDay() {
        return booksPerDay;
    }

    public void setBooksPerDay(int booksPerDay) {
        this.booksPerDay = booksPerDay;
    }
}
