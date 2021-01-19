package bookshop.application.port.rest.controller;

import bookshop.application.dto.Book;
import bookshop.application.mapper.BookMapper;
import bookshop.domain.book.service.BookService;
import bookshop.domain.book.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("books/fiveRandomBestsellers")
    public Set<Book> findFiveRandomBestsellers() {
        Set<bookshop.domain.book.Book> fiveRandomBestsellers = bookService.getFiveRandomBestsellers();
        return BookMapper.mapBooks(fiveRandomBestsellers);
    }

    @GetMapping("books")
    public Set<Book> getBooks() {
        Set<bookshop.domain.book.Book> books = bookService.getBooks();
        return BookMapper.mapBooks(books);
    }

    @GetMapping("books/{bookId}")
    public Book findBookByName(@PathVariable int bookId) {
        bookshop.domain.book.Book book = bookService.findBookById(bookId);
        return BookMapper.mapBook(book);
    }

    @GetMapping("books/genre/{genre}")
    public Set<Book> findBooksByGenre(@PathVariable Genre genre) {
        Set<bookshop.domain.book.Book> books = bookService.findBooksByGenre(genre);
        return BookMapper.mapBooks(books);
    }
}

