package bookshop.domain.book;

import bookshop.domain.book.author.Author;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {

    private BookId id;
    private String name;
    private Genre genre;
    private Author author;
    private long copiesSold;
    private String image;
    private BigDecimal price;
    private String synopsis;

    public Book() {
    }

    public Book(BookId bookId, String name, Genre genre, Author author, long copiesSold, String image, BigDecimal price, String synopsis) {
        this.id = bookId;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.copiesSold = copiesSold;
        this.image = image;
        this.price = price;
        this.synopsis = synopsis;
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

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public String getSynopsis() { return synopsis; }

    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return copiesSold == book.copiesSold &&
                Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                genre == book.genre &&
                Objects.equals(author, book.author) &&
                Objects.equals(image, book.image) &&
                Objects.equals(price, book.price) &&
                Objects.equals(synopsis, book.synopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, author, copiesSold, image, price, synopsis);
    }
}
