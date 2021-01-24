package bookshop.infrastructure.database.initialisation.table.book;
import bookshop.domain.book.Genre;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @Column(name = "price", length = 10, nullable = false, precision = 4, scale = 2)
    private BigDecimal price;

    @Column(name = "synopsis", length = 1000, nullable = false)
    private String synopsis;

    public BookInit() {
    }

    public BookInit(int id, String name, String image, Genre genre, long copiesSold, int authorId, BigDecimal price, String synopsis) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.genre = genre;
        this.copiesSold = copiesSold;
        this.authorId = authorId;
        this.price = price;
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "BookInit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", genre=" + genre +
                ", copiesSold=" + copiesSold +
                ", authorId=" + authorId +
                ", price=" + price +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}


