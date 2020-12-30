package bookshop.infrastructure.database.initialisation.table.author;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "id", length = 10, nullable = false)
    private int id;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "synopsis", length = 300, nullable = false)
    private String synopsis;

    public Author(){}

    public Author(int id, String firstName, String lastName, String synopsis){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.synopsis = synopsis;
    }

}
