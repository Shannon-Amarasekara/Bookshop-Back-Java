package bookshop.domain.book;

import java.util.Objects;

public class BookId {

    private int value;

    public BookId(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookId bookId = (BookId) o;
        return value == bookId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
