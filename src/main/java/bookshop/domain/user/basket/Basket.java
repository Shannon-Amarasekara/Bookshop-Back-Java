package bookshop.domain.user.basket;

import bookshop.domain.book.Book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Basket {

    private Set<Book> books;

    public Basket(Set<Book> books){
        this.books = books;
    }

    public static Basket createEmptyBasket() {
        return new Basket(new HashSet<>());
    }

    public Set<Book> getBooks() {
        return books;
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
