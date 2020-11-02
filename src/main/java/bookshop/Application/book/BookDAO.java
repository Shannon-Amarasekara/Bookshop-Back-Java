package bookshop.application.book;

import javax.persistence.PersistenceContext;
import java.util.List;

public interface BookDAO {

    @PersistenceContext

    List<Book> getBooks();

    void saveBook(Book book);

    List<Book> findBook(String name);

    List<Book> findByGenre(Genre genre);

    List<Book> findByGenres(Genre[] genres);

}
