package bookshop.domain;

import java.util.Set;

public interface BooksRepository {

    void saveBook(Book book);

    void saveBooks(Set<Book> books);

    Set<Book> getTenBestsellerBooks();

    Set<Book> getBooks();

    Set<Book> findBookByName(String name);

    Set<Book> findBooksByGenre(Genre genre);

}
