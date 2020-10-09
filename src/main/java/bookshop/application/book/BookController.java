package bookshop.application.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public Iterable<Book> getBooks(){
        return bookService.findAll();
    }

    @GetMapping(value = "books/{name}")
    public Iterable<Book> findByName(@PathVariable String name){
        return bookService.findByName(name);
    }
}

