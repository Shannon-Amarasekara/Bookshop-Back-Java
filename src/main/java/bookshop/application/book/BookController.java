package bookshop.application.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public Iterable<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(value = "books/{name}")
    public Iterable<Book> findByName(@PathVariable String name) { return bookService.findBook(name); }

    @GetMapping(value = "books/genre/{genre}")
    public Iterable<Book> findByGenre(@PathVariable Genre genre) {
        return bookService.findByGenre(genre);
    }

//    @GetMapping(value = "books/genres/{genreList}")
//    public String findByGenres(@RequestParam Genre[] genres) {
//        return "dummy";
////        return bookService.findByGenres(genres);
//    }
}

