package model;

public class Book {
    int score;
    int number;
    static int indexOfBook;

    public Book() {
        number = indexOfBook++;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
