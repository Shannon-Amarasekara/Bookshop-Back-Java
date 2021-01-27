package bookshop.domain.user.basket.service;

import bookshop.domain.book.Book;
import bookshop.domain.book.repository.BookRepository;
import bookshop.domain.user.basket.Basket;
import bookshop.domain.user.basket.BookIds;
import bookshop.domain.book.BookId;
import bookshop.domain.user.UserId;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@Service
public class UserBasketService {

    private HashMap<UserId, BookIds> basketsAndIds;

    private BookRepository bookRepository;

    public UserBasketService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.basketsAndIds = new HashMap<>();
    }

    public void addBookToBasket(BookId bookId, UserId userId) {
        createNewBasketBookIdsIfInexistent(userId);
        addBookToExistingBasket(userId, bookId);
    }

    public Basket getBasket(UserId userId) {

        if (basketExists(userId)) {
            BookIds bookIds = findExistingBasketBookIds(userId);

            if (bookIds.getBookIds().isEmpty()) {
                return emptyBasket();
            } else {
                return createBasketFromBookIds(bookIds);
            }
        }
        return emptyBasket();
    }

    private Basket emptyBasket() {
        return Basket.createEmptyBasket();
    }

    private Basket createBasketFromBookIds(BookIds bookIds) {
        Set<Book> books = bookRepository.findBooksByIds(bookIds);
        return new Basket(books);
    }

    public BookIds getBasketBookIds(UserId userId) {
        createNewBasketBookIdsIfInexistent(userId);
        return findExistingBasketBookIds(userId);
    }

    private void addBookToExistingBasket(UserId userId, BookId bookId) {
        findExistingBasketBookIds(userId).add(bookId);
    }

    public void removeBookFromBasket(BookId bookId, UserId userId) {
        findExistingBasketBookIds(userId).remove(bookId);
    }

    private void createNewBasketBookIdsIfInexistent(UserId userId) {
        if (!basketExists(userId)) {
            createNewBasket(userId);
        }
    }

    private BookIds findExistingBasketBookIds(UserId userId) {
        return basketsAndIds.get(userId);
    }

    private void createNewBasket(UserId userId) {
        this.basketsAndIds.put(userId, new BookIds(new HashSet<>()));
    }

    private boolean basketExists(UserId userId) {
        return this.basketsAndIds.containsKey(userId);
    }
}
