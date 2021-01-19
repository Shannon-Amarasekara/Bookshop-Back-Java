package bookshop.domain.book.service;

import bookshop.domain.book.author.Author;
import bookshop.domain.book.Book;
import bookshop.domain.book.repository.BookRepository;
import bookshop.domain.book.Genre;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book) {
        bookRepository.saveBook(book);
    }

    public Set<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public Book findBookById(int bookId) {
        return bookRepository.findBookById(bookId);
    }

    public Set<Book> findBooksByGenre(Genre genre) {
        return bookRepository.findBooksByGenre(genre);
    }

    public Set<Book> getFiveRandomBestsellers() {
        List<Book> bestsellers = new ArrayList<>(bookRepository.getTenBestsellerBooks());
        Random random = new Random();

        while (bestsellers.size() > 5) {
            Book book = bestsellers.get(random.nextInt(bestsellers.size()));
            bestsellers.remove(book);
        }

        return new HashSet<>(bestsellers);
    }

    public void saveAuthor(Author author) {
        bookRepository.saveAuthor(author);
    }
}