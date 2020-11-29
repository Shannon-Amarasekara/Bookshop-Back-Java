package bookshop.domain;

import java.util.Set;

public interface BooksRepository {

    Set<Book> getTenBestsellerBooks();

    Set<Book> getBooks();

    Set<Book> findBookByName(String name);

    Set<Book> findBooksByGenre(Genre genre);
}
