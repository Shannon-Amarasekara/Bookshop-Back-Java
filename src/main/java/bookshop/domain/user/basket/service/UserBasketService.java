package bookshop.domain.user.basket.service;

import bookshop.domain.user.basket.Basket;
import bookshop.domain.book.BookId;
import bookshop.domain.user.UserId;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;


@Service
public class UserBasketService {

    private HashMap<UserId, Basket> basketsAndIds;

    public UserBasketService() {
        this.basketsAndIds = new HashMap<>();
    }

    public void addBookToBasket(BookId bookId, UserId userId) {
        createNewBasketIfInexistent(userId);
        addBookToExistingBasket(userId, bookId);
    }

    public Basket getBasket(UserId userId) {
        createNewBasketIfInexistent(userId);
        return findExistingBasket(userId);
    }

    private void addBookToExistingBasket(UserId userId, BookId bookId) {
        findExistingBasket(userId).add(bookId);
    }

    private void createNewBasketIfInexistent(UserId userId) {
        if (!basketExists(userId)) {
            createNewBasket(userId);
        }
    }

    private Basket findExistingBasket(UserId userId) {
        return basketsAndIds.get(userId);
    }

    private void createNewBasket(UserId userId) {
        this.basketsAndIds.put(userId, new Basket(new HashSet<>()));
    }

    private boolean basketExists(UserId userId) {
        return this.basketsAndIds.containsKey(userId);
    }
}
