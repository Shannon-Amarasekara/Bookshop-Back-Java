package bookshop.domain.book.author;

import java.util.Objects;

public class Author {

    private int id;
    private String firstName;
    private String lastName;
    private String resume;

    public Author() {
    }

    public Author(int id, String firstName, String lastName, String resume) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resume = resume;
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getResume() {
        return resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(resume, author.resume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, resume);
    }
}
