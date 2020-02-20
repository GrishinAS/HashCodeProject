package model;

import java.util.ArrayList;

public class Library {
    private int number;
    private ArrayList<Book> books = new ArrayList<Book>();
    private int signUpProcess;
    private int booksPerDay;

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
