package bookshop.Application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private String image;

    public Book() {
    }

    public Book(int id, String name, String author, String image) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.image = image;
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

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
