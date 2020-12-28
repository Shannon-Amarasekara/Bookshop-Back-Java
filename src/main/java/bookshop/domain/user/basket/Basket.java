package bookshop.domain.user.basket;

import bookshop.domain.book.BookId;

import java.util.Objects;
import java.util.Set;

public class Basket {

    private Set<BookId> bookIds;

    public Basket(Set<BookId> bookIds) {
        this.bookIds = bookIds;
    }

    public void add(BookId bookId) {
        this.bookIds.add(bookId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(bookIds, basket.bookIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookIds);
    }
}
