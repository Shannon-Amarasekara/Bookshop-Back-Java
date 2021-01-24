package bookshop.application.mapper.basket;

import bookshop.application.dto.basket.Basket;

public class BasketMapper {

    public static Basket mapBasket(bookshop.domain.user.basket.Basket basket) {
        return new Basket(basket.getBooks());
    }


}
