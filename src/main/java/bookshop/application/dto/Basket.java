package bookshop.application.dto;

import bookshop.domain.book.Book;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Basket {

    private Set<bookshop.domain.book.Book> books;
    private BigDecimal totalPrice;

    public Basket(Set<bookshop.domain.book.Book> books, BigDecimal totalPrice) {
        this.books = books;
        this.totalPrice = totalPrice;
    }

    public static bookshop.domain.user.basket.Basket createEmptyBasket() {
        return new bookshop.domain.user.basket.Basket(new HashSet<>());
    }

    public Set<Book> getBooks() {
        return books;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(books, basket.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
