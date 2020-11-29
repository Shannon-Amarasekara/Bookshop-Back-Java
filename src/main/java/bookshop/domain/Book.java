package bookshop.domain;


import java.util.Objects;

public class Book {

    private int id;

    private String name;

    private String author;

    private String image;

    private Genre genre;

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

    public long getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(long copiesSold) {
        this.copiesSold = copiesSold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                copiesSold == book.copiesSold &&
                name.equals(book.name) &&
                author.equals(book.author) &&
                image.equals(book.image) &&
                genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, image, genre, copiesSold);
    }

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