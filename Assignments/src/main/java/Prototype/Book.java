package Prototype;

public class Book implements Prototype{
    private final String name;
    private final String author;
    private final String genre;
    private final int length;

    public Book(String name, String author, String genre, int length) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.length = length;
    }

    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public int getLength() {
        return length;
    }

    @Override
    public Book clone() {
        return new Book(name, author, genre, length);
    }

    @Override
    public String toString() {
        return "Book name: "+name+", author: "+author+", page length: "+length;
    }
}
