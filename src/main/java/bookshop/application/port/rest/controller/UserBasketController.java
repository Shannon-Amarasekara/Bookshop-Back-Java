package bookshop.application.port.rest.controller;

import bookshop.application.mapper.basket.BasketMapper;
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
@CrossOrigin(origins = "http://localhost:4200")
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
    public bookshop.application.dto.basket.Basket getBasket() throws UnknownHostException {
        UserId userId = createUserId();
        Basket basket = userBasketService.getBasket(userId);
        return BasketMapper.mapBasket(basket);
    }

    private UserId createUserId() throws UnknownHostException {
        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Ip Address is " + ipAddress);
        return new UserId(ipAddress);
    }
}
