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

            Book misery = new Book(new BookId(0), "Misery", Horror, stephenKing, 875000, "https://upload.wikimedia.org/wikipedia/en/6/6f/Stephen_King_Misery_cover.jpg", new BigDecimal(8.99), "Misery Chastain is dead. Paul Sheldon has just killed her - with relief, with joy. Misery has made him rich; she was the heroine of a string of bestsellers. And now he wants to get on to some real writing.");
            Book harryPotter = new Book(new BookId(0), "Harry Potter", Fantasy, jkRowling, 500000000, "https://www.abebooks.com/images/books/harry-potter/philosophers-stone.jpg", new BigDecimal(4.99), "The book that launched a billion young readers feels just as fresh, fun and meticulously rendered as it did over twenty years ago. Hogwarts, Muggles, Diagon Alley, Quidditch; the magical journey all started here, with a wide-eyed young wizard and an old-fashioned battle between good and evil.");
            Book theFaultInOurStars = new Book(new BookId(0), "The Fault In Our Stars", Romance, johnGreen, 10700000, "https://upload.wikimedia.org/wikipedia/en/a/a9/The_Fault_in_Our_Stars.jpg", new BigDecimal(6.99), "Despite the tumour-shrinking medical miracle that has bought her a few years, Hazel has never been anything but terminal, her final chapter inscribed upon diagnosis. But when a gorgeous plot twist named Augustus Waters suddenly appears at Cancer Kid Support Group, Hazels story is about to be completely rewritten.");
            Book aBriefHistoryOfTime = new Book(new BookId(0), "A Brief History Of Time", Science, stephenHawking, 10000000, "https://images-na.ssl-images-amazon.com/images/I/51slEJbyEmL._AC_SY400_.jpg", new BigDecimal(7.99), "Following his passing in March 2018, Stephen Hawkings A Brief History of Time will continue to forever stand as his gift to the world. Few books have carried such a siesmic impact, opening millions of minds to the deep cosmos in language that is both succinct and clear. It begins by reviewing the great theories of the cosmos from Newton to Einstein, before delving into the secrets which still lie at the heart of space and time, from the Big Bang to black holes, via spiral galaxies and strong theory.");
            Book lookingForAlaska = new Book(new BookId(0), "Looking For Alaska", Romance, johnGreen, 5388, "https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg", new BigDecimal(7.39), "BEFORE. Miles Halters whole life has been one big non-event until he starts at anything-but-boring Culver Creek Boarding School and meets Alaska Young. Gorgeous, clever, funny, sexy, screwed up and utterly fascinating she pulls Miles into her world, launches him into a new life, and steals his heart. But when tragedy strikes, and Miles comes face-to-face with death he discovers the value of living and loving unconditionally. AFTER: Nothing will ever be the same.");
            Book theStranger = new Book(new BookId(0), "The Stranger", Philosophy, albertCamus, 4400, "https://images-na.ssl-images-amazon.com/images/I/81rNFIU-FxL.jpg", new BigDecimal(8.17), "The day his mother dies, Meursault notices that it is very hot on the bus that is taking him from Algiers to the retirement home where his mother lived; so hot that he falls asleep. Later, while waiting for the wake to begin, the harsh electric lights in the room make him extremely uncomfortable, so he gratefully accepts the coffee the caretaker offers him and smokes a cigarette. The same burning sun that so oppresses him during the funeral walk will once again blind the calm, reserved Meursault as he walks along a deserted beach a few days later-leading him to commit an irreparable act.");
            Book theGiver = new Book(new BookId(0), "The Giver", Philosophy, loisLowry, 12000000, "https://cdn.waterstones.com/bookjackets/large/9780/0072/9780007263516.jpg", new BigDecimal(4.49), "It is the future. There is no war, no hunger, no pain. No one in the community wants for anything. Everything needed is provided. And at twelve years old, each member of the community has their profession carefully chosen for them by the Committee of Elders. Twelve-year old Jonas has never thought there was anything wrong with his world. But from the moment he is selected as the Receiver of Memory, Jonas discovers that their community is not as perfect as it seems. It is only with the help of the Giver, that Jonas can find what has been lost. And it is only through his personal courage that Jonas finds the strength to do what is right...");
            Book lordOfTheFlies = new Book(new BookId(0), "Lord Of The Flies", Philosophy, williamGolding, 25000000, "https://images-na.ssl-images-amazon.com/images/I/81jlbxMyR4L.jpg", new BigDecimal(5.79), "A plane crashes on a desert island. The only survivors are a group of schoolboys. By day, they discover fantastic wildlife and dazzling beaches, learning to survive; at night, they are haunted by nightmares of a primitive beast. Orphaned by society, it is not long before their innocent childhood games devolve into a savage, murderous hunt ... ");
            Book theCatcherInTheRye = new Book(new BookId(0), "The Catcher In The Rye", Philosophy, jdSalinger, 65000000, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1554406349l/7178._SY475_.jpg", new BigDecimal(4.99), "It is Christmas and Holden Caulfield has just been expelled from yet another school. Fleeing the crooks at Pencey Prep, he pinballs around New York City seeking solace in fleeting encounters - shooting the bull with strangers in dive hotels, wandering alone round Central Park, getting beaten up by pimps and cut down by erstwhile girlfriends. The city is beautiful and terrible, in all its neon loneliness and seedy glamour, its mingled sense of possibility and emptiness. Holden passes through it like a ghost, thinking always of his kid sister Phoebe, the only person who really understands him, and his determination to escape the phonies and find a life of true meaning.");
            Book theLightBetweenOceans = new Book(new BookId(0), "The Light Between Oceans", Philosophy, mlStedman, 3000000, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1385609251l/19012815.jpg", new BigDecimal(7.49), "They break the rules and follow their hearts. What happens next will break yours. Shattered by his experiences in the World War I trenches, veteran Tom Sherbourne returns to his home in Australia to his wife Isabel. Looking for restoration and peace the couple move to an isolated lighthouse where they try to rebuild their lives and long for a child that never comes. Then, one day, a boat washes ashore with a baby inside – a gift that offers the hope of a future they have longed for but the consequences of their actions may be more far-reaching than they could have ever imagined.");

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