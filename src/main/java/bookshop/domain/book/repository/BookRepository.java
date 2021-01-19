package bookshop.domain.book.repository;

import bookshop.domain.book.author.Author;
import bookshop.domain.book.Book;
import bookshop.domain.book.Genre;
import bookshop.domain.user.basket.BookIds;

import java.util.Set;

public interface BookRepository {

    Set<Book> findBooksByIds(BookIds bookIds);

    Set<Book> getTenBestsellerBooks();

    Set<Book> getBooks();

    Book findBookById(int bookId);

    Set<Book> findBooksByGenre(Genre genre);

    void saveBook(Book book);

    void saveAuthor(Author author);
}
