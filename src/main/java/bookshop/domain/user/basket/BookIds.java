package bookshop.domain.user.basket;

import bookshop.domain.book.BookId;

import java.util.Objects;
import java.util.Set;

public class BookIds {

    private Set<BookId> bookIds;

    public BookIds(Set<BookId> bookIds) {
        this.bookIds = bookIds;
    }

    public void add(BookId bookId) {
        this.bookIds.add(bookId);
    }

    public void remove(BookId bookId) {
        bookIds.remove(bookId);
    }

    public Set<BookId> getBookIds() {
        return bookIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookIds bookIds1 = (BookIds) o;
        return Objects.equals(bookIds, bookIds1.bookIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookIds);
    }
}
