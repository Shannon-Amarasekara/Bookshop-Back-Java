package bookshop.application.controller;

import bookshop.domain.book.Book;
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

    @GetMapping("books")
    public Set<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("books/{name}")
    public Set<Book> findBookByName(@PathVariable String name) {
        return bookService.findBookByName(name);
    }

    @GetMapping("books/genre/{genre}")
    public Set<Book> findBooksByGenre(@PathVariable Genre genre) {
        return bookService.findBooksByGenre(genre);
    }

    @GetMapping("books/fiveRandomBestsellers")
    public Set<Book> findFiveRandomBestsellers() {
        return bookService.getFiveRandomBestsellers();
    }
}

