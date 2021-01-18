package bookshop.application.port.rest.controller;

import bookshop.domain.user.UserId;
import bookshop.domain.book.BookId;
import bookshop.domain.book.service.BookService;
import bookshop.domain.user.basket.Basket;
import bookshop.domain.user.basket.BookIds;
import bookshop.domain.user.basket.service.UserBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@RequestMapping
public class UserBasketController {

    @Autowired
    private UserBasketService userBasketService;

    @Autowired
    private BookService bookService;

    @GetMapping("addBookToBasket/{bookIdValue}")
    public void addBookToBasket(@PathVariable int bookIdValue) throws UnknownHostException {
        BookId bookId = new BookId(bookIdValue);
        UserId userId = createUserId();
        userBasketService.addBookToBasket(bookId, userId);
    }

    @GetMapping("getBasketBookIds")
    public BookIds getBasketBookIds() throws UnknownHostException {
        UserId userId = createUserId();
        return userBasketService.getBasketBookIds(userId);
    }

    @GetMapping("viewBasket")
    public Basket getBasket() throws UnknownHostException {
        UserId userId = createUserId();
        return userBasketService.getBasket(userId);
    }

    private UserId createUserId() throws UnknownHostException {
        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Ip Address is " + ipAddress);
        return new UserId(ipAddress);
    }
}
