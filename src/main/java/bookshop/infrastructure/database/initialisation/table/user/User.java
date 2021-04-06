package bookshop.infrastructure.database.initialisation.table.user;

import bookshop.infrastructure.database.initialisation.table.user.basket.Basket;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 200, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 200, nullable = false)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public User(){
    }

    public User(int id, String firstName, String lastName, Basket basket) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", basket=" + basket +
                '}';
    }
}
