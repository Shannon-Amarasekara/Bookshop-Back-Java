package bookshop.domain.book.repository;

import bookshop.domain.book.author.Author;
import bookshop.domain.book.Book;
import bookshop.domain.book.BookData;
import bookshop.domain.book.Genre;
import bookshop.domain.user.basket.BookIds;

import java.util.Set;

public interface BookRepository {

    Set<Book> findBooksByIds(BookIds bookIds);

    Set<Book> getTenBestsellerBooks();

    Set<Book> getBooks();

    Book findBookByName(String name);

    Set<Book> findBooksByGenre(Genre genre);

    void saveBook(BookData bookData);

    void saveAuthor(Author author);
}
