package bookshop;

import bookshop.domain.Book;
import bookshop.domain.BookService;
import bookshop.domain.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static bookshop.domain.Genre.*;

@SpringBootApplication
//TODO rename class
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Qualifier
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //TODO move
    @Bean
    CommandLineRunner init(BookService bookService) {
        return args -> {

            Book misery = new Book(0, "Misery", "Stephen King", "https://upload.wikimedia.org/wikipedia/en/6/6f/Stephen_King_Misery_cover.jpg", Horror, 875000);
            Book harryPotter = new Book(0, "Harry Potter", "J.K. Rowling", "https://www.abebooks.com/images/books/harry-potter/philosophers-stone.jpg", Genre.Fantasy, 500000000);
            Book theFaultInOurStars = new Book(0, "The Fault In Our Stars", "John Green", "https://upload.wikimedia.org/wikipedia/en/a/a9/The_Fault_in_Our_Stars.jpg", Genre.Romance, 10700000);
            Book aBriefHistoryOfTime = new Book(0, "A Brief History Of Time", "Stephen Hawking", "https://images-na.ssl-images-amazon.com/images/I/51slEJbyEmL._AC_SY400_.jpg", Genre.Science, 10000000);
            Book lookingForAlaska = new Book(0, "Looking For Alaska", "John Green", "https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg", Genre.Romance, 5388);
            Book theStranger = new Book(0, "The Stranger", "Albert Camus", "https://images-na.ssl-images-amazon.com/images/I/81rNFIU-FxL.jpg", Philosophy, 4400);
            Book theGiver = new Book(0, "The Giver", "Lois Lowry", "https://cdn.waterstones.com/bookjackets/large/9780/0072/9780007263516.jpg", Philosophy, 12000000);
            Book lordOfTheFlies = new Book(0, "Lord Of The Flies", "William Golding", "https://images-na.ssl-images-amazon.com/images/I/81jlbxMyR4L.jpg", Philosophy, 25000000);
            Book theCatcherInTheRye = new Book(0, "The Catcher In The Rye", "J.D.Salinger", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1554406349l/7178._SY475_.jpg", Philosophy, 65000000);
            Book theLightBetweenOceans = new Book(0, "The Light Between Oceans", "M L Stedman", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1385609251l/19012815.jpg", Philosophy, 3000000);

            bookService.saveBook(misery);
            bookService.saveBook(harryPotter);
            bookService.saveBook(theFaultInOurStars);
            bookService.saveBook(aBriefHistoryOfTime);
            bookService.saveBook(lookingForAlaska);
            bookService.saveBook(theStranger);
            bookService.saveBook(theGiver);
            bookService.saveBook(lordOfTheFlies);
            bookService.saveBook(theCatcherInTheRye);
            bookService.saveBook(theLightBetweenOceans);

        };
    }
}