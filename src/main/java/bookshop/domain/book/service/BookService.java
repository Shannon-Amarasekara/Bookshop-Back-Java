package bookshop.domain.book.service;

import bookshop.domain.book.Book;
import bookshop.domain.book.repository.BooksRepository;
import bookshop.domain.book.Genre;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

@Service
public class BookService {

    private BooksRepository booksRepository;

    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void saveBook(Book book) {
        booksRepository.saveBook(book);
    }

    public void saveBooks(Set<Book> books) {
        booksRepository.saveBooks(books);
    }

    public Set<Book> getBooks() {
        return booksRepository.getBooks();
    }

    public Set<Book> findBookByName(String name) {
        return booksRepository.findBookByName(name);
    }

    public Set<Book> findBooksByGenre(Genre genre) {
        return booksRepository.findBooksByGenre(genre);
    }

    public Set<Book> getFiveRandomBestsellers() {
        List<Book> bestsellers = new ArrayList<>(booksRepository.getTenBestsellerBooks());
        Random random = new Random();

        while (bestsellers.size() > 5) {
            Book book = bestsellers.get(random.nextInt(bestsellers.size()));
            bestsellers.remove(book);
        }

        return new HashSet<>(bestsellers);
    }
}