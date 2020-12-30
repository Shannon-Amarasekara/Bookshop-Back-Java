package bookshop;

import bookshop.domain.book.BookData;
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

            BookData misery = new BookData(0, "Misery", "https://upload.wikimedia.org/wikipedia/en/6/6f/Stephen_King_Misery_cover.jpg", Horror, 875000, 1);
            BookData harryPotter = new BookData(0, "Harry Potter", "https://www.abebooks.com/images/books/harry-potter/philosophers-stone.jpg", Genre.Fantasy, 500000000, 2);
            BookData theFaultInOurStars = new BookData(0, "The Fault In Our Stars", "https://upload.wikimedia.org/wikipedia/en/a/a9/The_Fault_in_Our_Stars.jpg", Genre.Romance, 10700000, 3);
            BookData aBriefHistoryOfTime = new BookData(0, "A Brief History Of Time", "https://images-na.ssl-images-amazon.com/images/I/51slEJbyEmL._AC_SY400_.jpg", Genre.Science, 10000000, 4);
            BookData lookingForAlaska = new BookData(0, "Looking For Alaska", "https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg", Genre.Romance, 5388, 3);
            BookData theStranger = new BookData(0, "The Stranger", "https://images-na.ssl-images-amazon.com/images/I/81rNFIU-FxL.jpg", Philosophy, 4400, 5);
            BookData theGiver = new BookData(0, "The Giver", "https://cdn.waterstones.com/bookjackets/large/9780/0072/9780007263516.jpg", Philosophy, 12000000, 6);
            BookData lordOfTheFlies = new BookData(0, "Lord Of The Flies", "https://images-na.ssl-images-amazon.com/images/I/81jlbxMyR4L.jpg", Philosophy, 25000000, 7);
            BookData theCatcherInTheRye = new BookData(0, "The Catcher In The Rye", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1554406349l/7178._SY475_.jpg", Philosophy, 65000000, 8);
            BookData theLightBetweenOceans = new BookData(0, "The Light Between Oceans", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1385609251l/19012815.jpg", Philosophy, 3000000, 9);

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