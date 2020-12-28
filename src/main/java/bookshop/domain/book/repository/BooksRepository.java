package bookshop.domain.book.repository;

import bookshop.domain.book.Book;
import bookshop.domain.book.Genre;

import java.util.Set;

public interface BooksRepository {

    void saveBook(Book book);

    void saveBooks(Set<Book> books);

    Set<Book> getTenBestsellerBooks();

    Set<Book> getBooks();

    Set<Book> findBookByName(String name);

    Set<Book> findBooksByGenre(Genre genre);
}
