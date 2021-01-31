package bookshop.infrastructure.database.initialisation.table.author;

import javax.persistence.*;

//@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "id", length = 10, nullable = false)
    private int id;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "resume", length = 300, nullable = false)
    private String resume;

    public Author(){}

    public Author(int id, String firstName, String lastName, String resume){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", resume='" + resume + '\'' +
                '}';
    }
}
