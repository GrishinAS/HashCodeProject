package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return score == book.score &&
                number == book.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, number);
    }
}
