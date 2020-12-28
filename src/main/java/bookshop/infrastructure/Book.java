package bookshop.infrastructure;


import bookshop.domain.book.Genre;

import javax.persistence.*;

@Entity
@Table(name = "books")

public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "author", length = 200, nullable = false)
    private String author;

    @Column(name = "image", length = 200, nullable = false)
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", length = 25)
    private Genre genre;

    @Column(name = "copies_sold", length = 100, nullable = false)
    private long copiesSold;

    public Book() {
    }

    public Book(int id, String name, String author, String image, Genre genre, long copiesSold) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.image = image;
        this.genre = genre;
        this.copiesSold = copiesSold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public long getCopiesSold() { return copiesSold; }

    public void setCopiesSold(long copiesSold) { this.copiesSold = copiesSold; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", genre=" + genre +
                ", copiesSold=" + copiesSold +
                '}';
    }
}