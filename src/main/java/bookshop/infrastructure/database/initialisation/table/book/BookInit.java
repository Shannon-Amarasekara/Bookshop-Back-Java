package bookshop.infrastructure.database.initialisation.table.book;
import bookshop.domain.book.Genre;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class BookInit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "image", length = 200, nullable = false)
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", length = 25)
    private Genre genre;

    @Column(name = "copies_sold", length = 100, nullable = false)
    private long copiesSold;

    @Column(name = "author_id", length = 200, nullable = false)
    private int authorId;

    public BookInit() {
    }

    public BookInit(int id, String name, String image, Genre genre, long copiesSold, int authorId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.genre = genre;
        this.copiesSold = copiesSold;
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "BookData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", genre=" + genre +
                ", copiesSold=" + copiesSold +
                ", authorId=" + authorId +
                '}';
    }
}


