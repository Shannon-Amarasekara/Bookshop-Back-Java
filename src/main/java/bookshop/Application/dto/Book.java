package bookshop.application.dto;

import bookshop.domain.book.author.Author;
import bookshop.domain.book.BookId;
import bookshop.domain.book.Genre;

public class Book {

    private BookId id;
    private String name;
    private Genre genre;
    private Author author;
    private long copiesSold;
    private String image;

    public Book() {
    }

    public Book(BookId id, String name, Genre genre, Author author, long copiesSold, String image) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.copiesSold = copiesSold;
        this.image = image;
    }

    public BookId getId() {
        return id;
    }

    public void setId(BookId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public long getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(long copiesSold) {
        this.copiesSold = copiesSold;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
