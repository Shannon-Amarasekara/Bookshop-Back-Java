package bookshop.infrastructure.database.initialisation.table.user.basket;

import bookshop.infrastructure.database.initialisation.table.user.User;

import javax.persistence.*;

@Entity
@Table(name = "baskets")
public class Basket {

    @Id
    @Column(name = "id", length = 200, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_ids", length = 200, nullable = false)
    private String bookIds;

    @OneToOne(mappedBy = "basket")
    private User user;

    public Basket(){
    }

    public Basket(int id, String bookIds) {
        this.id = id;
        this.bookIds = bookIds;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", bookIds='" + bookIds + '\'' +
                ", user=" + user +
                '}';
    }
}
