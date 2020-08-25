package bookshop.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class Controller {

    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public Iterable<Book> getBooks(){
        return bookService.findAll();
    }

    @GetMapping(value = "books/name/{bookName}")
    public List<Book> findByName(@PathVariable("bookName") String name){
        return bookService.findByName(name);
    }

    @GetMapping(value = "books/id/{bookId}")
    public Optional<Book> getBook(@PathVariable("bookId") int bookId){
        return bookService.getBook(bookId);
    }
}
