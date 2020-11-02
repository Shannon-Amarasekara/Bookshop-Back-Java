package bookshop.application;

import bookshop.application.book.Book;
import bookshop.application.book.BookService;
import bookshop.application.book.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static bookshop.application.book.Genre.*;

@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    @Qualifier
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init(BookService bookService) {
        return args -> {

            Book misery = new Book(0, "Misery", "Stephen King", "https://upload.wikimedia.org/wikipedia/en/6/6f/Stephen_King_Misery_cover.jpg", Horror);
            Book harryPotter = new Book(0, "Harry Potter", "J.K. Rowling", "https://www.abebooks.com/images/books/harry-potter/philosophers-stone.jpg", Genre.Fantasy);
            Book theFaultInOurStars = new Book(0, "The Fault In Our Stars", "John Green", "https://upload.wikimedia.org/wikipedia/en/a/a9/The_Fault_in_Our_Stars.jpg", Genre.Romance);
            Book aBriefHistoryOfTime = new Book(0, "A Brief History Of Time", "Stephen Hawking", "https://images-na.ssl-images-amazon.com/images/I/51slEJbyEmL._AC_SY400_.jpg", Genre.Science);

            bookService.saveBook(misery);
            bookService.saveBook(harryPotter);
            bookService.saveBook(theFaultInOurStars);
            bookService.saveBook(aBriefHistoryOfTime);

            List<Book> books = bookService.getBooks();
            System.out.println("The books: " + books);

            Genre[] genres = {Horror, Romance};
            List<Book> byGenres = bookService.findByGenres(genres);
            System.out.println(byGenres);
        };
    }
}