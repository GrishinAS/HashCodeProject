package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private int number;
    private ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getAlreadyGivenBooks() {
        return alreadyGivenBooks;
    }

    public void setAlreadyGivenBooks(ArrayList<Book> alreadyGivenBooks) {
        this.alreadyGivenBooks = alreadyGivenBooks;
    }

    private ArrayList<Book> alreadyGivenBooks = new ArrayList<Book>();
    private int signUpProcess;
    private int booksPerDay;
    static int indexOfLib;

    public Library() {
        number = indexOfLib++;
    }

    List<Book> getMostScoreBooks(List<Book> alreadyScannedBooks){
        List<Book> resultBooks = new ArrayList<>();
        for(Book book: this.books){
            if(!alreadyScannedBooks.contains(book)){
                resultBooks.add(book);
            }
        }
        alreadyGivenBooks.addAll(resultBooks);
        return resultBooks;
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
