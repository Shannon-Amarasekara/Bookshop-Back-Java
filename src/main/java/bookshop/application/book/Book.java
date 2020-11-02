package bookshop.application.book;


import javax.persistence.*;

@Entity
@Table(name = "books")

@NamedQueries({
        @NamedQuery(name = "find all books", query = "select b from Book b"),
})

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

    public Book() {
    }

    public Book(int id, String name, String author, String image, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.image = image;
        this.genre = genre;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", genre=" + genre +
                '}';
    }
}