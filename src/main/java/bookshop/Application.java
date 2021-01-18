package bookshop;

import bookshop.domain.book.Book;
import bookshop.domain.book.BookId;
import bookshop.domain.book.author.Author;
import bookshop.domain.book.Genre;
import bookshop.domain.book.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

import static bookshop.domain.book.Genre.*;

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

            Author stephenKing = new Author(1, "Stephen", "King", "writes scary books");
            Author jkRowling = new Author(2, "JK", "Rowling", "famous for harry potter books");
            Author johnGreen = new Author(3, "John", "Green", "fcghvjbnklm,");
            Author stephenHawking = new Author(4, "Stephen", "Hawking", "space guy");
            Author albertCamus = new Author(5, "Albert", "Camus", "philosophy guy ");
            Author loisLowry = new Author(6, "Lois", "Lowry", "dont know");
            Author williamGolding = new Author(7, "William", "Golding", "went to war");
            Author jdSalinger = new Author(8, "JD", "Salinger", "depressing books");
            Author mlStedman = new Author(9, "ML", "Stedman", "his name is ml stedman");

            bookService.saveAuthor(stephenKing);
            bookService.saveAuthor(jkRowling);
            bookService.saveAuthor(johnGreen);
            bookService.saveAuthor(stephenHawking);
            bookService.saveAuthor(albertCamus);
            bookService.saveAuthor(loisLowry);
            bookService.saveAuthor(williamGolding);
            bookService.saveAuthor(jdSalinger);
            bookService.saveAuthor(mlStedman);

            Book misery = new Book(new BookId(0), "Misery", Horror, stephenKing, 875000, "https://upload.wikimedia.org/wikipedia/en/6/6f/Stephen_King_Misery_cover.jpg", new BigDecimal(8.99));
            Book harryPotter = new Book(new BookId(0), "Harry Potter", Fantasy, jkRowling, 500000000, "https://www.abebooks.com/images/books/harry-potter/philosophers-stone.jpg", new BigDecimal(4.99));
            Book theFaultInOurStars = new Book(new BookId(0), "The Fault In Our Stars", Romance, johnGreen, 10700000, "https://upload.wikimedia.org/wikipedia/en/a/a9/The_Fault_in_Our_Stars.jpg", new BigDecimal(6.99));
            Book aBriefHistoryOfTime = new Book(new BookId(0), "A Brief History Of Time", Science, stephenHawking, 10000000, "https://images-na.ssl-images-amazon.com/images/I/51slEJbyEmL._AC_SY400_.jpg", new BigDecimal(7.99));
            Book lookingForAlaska = new Book(new BookId(0), "Looking For Alaska", Romance, johnGreen, 5388, "https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg", new BigDecimal(7.39));
            Book theStranger = new Book(new BookId(0), "The Stranger", Philosophy, albertCamus, 4400, "https://images-na.ssl-images-amazon.com/images/I/81rNFIU-FxL.jpg", new BigDecimal(8.17));
            Book theGiver = new Book(new BookId(0), "The Giver", Philosophy, loisLowry, 12000000, "https://cdn.waterstones.com/bookjackets/large/9780/0072/9780007263516.jpg", new BigDecimal(4.49));
            Book lordOfTheFlies = new Book(new BookId(0), "Lord Of The Flies", Philosophy, williamGolding, 25000000, "https://images-na.ssl-images-amazon.com/images/I/81jlbxMyR4L.jpg", new BigDecimal(5.79));
            Book theCatcherInTheRye = new Book(new BookId(0), "The Catcher In The Rye", Philosophy, jdSalinger, 65000000, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1554406349l/7178._SY475_.jpg", new BigDecimal(4.99));
            Book theLightBetweenOceans = new Book(new BookId(0), "The Light Between Oceans", Philosophy, mlStedman, 3000000, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1385609251l/19012815.jpg", new BigDecimal(7.49));

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