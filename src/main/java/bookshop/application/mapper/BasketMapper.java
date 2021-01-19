package bookshop.application.mapper;

import bookshop.application.dto.Basket;
import bookshop.domain.book.Book;

import java.math.BigDecimal;

public class BasketMapper {

    public static Basket mapBasket(bookshop.domain.user.basket.Basket basket) {
        return new Basket(
                basket.getBooks(),
                calculateTotalPrice(basket));
    }

    private static BigDecimal calculateTotalPrice(bookshop.domain.user.basket.Basket basket) {
        BigDecimal total = new BigDecimal(0);

        for(Book book: basket.getBooks()){
            total = total.add(book.getPrice());
        }

        return total;
    }


}
