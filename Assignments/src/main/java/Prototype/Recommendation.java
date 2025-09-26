package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype{
    private String genre;
    private List<Prototype> bookList = new ArrayList<>();

    public Recommendation() {}

    public Recommendation(String genre, List<Prototype> bookList) {
        this.genre = genre;
        this.bookList = bookList;
    }

    public void addBook(Prototype book) {
        bookList.add(book);
    }

    public String getGenre() {
        return genre;
    }
    public List<Prototype> getBookList() {
        return bookList;
    }


    @Override
    public Recommendation clone() {
        return new Recommendation(genre, bookList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Genre of recommendation set: ").append(genre);
        for (Prototype book : bookList) {
            sb.append("\n").append(book);
        }
        return sb.toString();
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
