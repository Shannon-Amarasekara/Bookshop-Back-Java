package bookshop.application.mapper.book;


import bookshop.application.dto.book.Book;

import java.util.HashSet;
import java.util.Set;

public class BookMapper {

    public static Set<Book> mapBooks(Set<bookshop.domain.book.Book> books) {
        Set<Book> booksForDisplay = new HashSet<>();

        for (bookshop.domain.book.Book book : books) {
            Book bookForDisplay = mapBook(book);
            booksForDisplay.add(bookForDisplay);
        }
        return booksForDisplay;
    }

    public static Book mapBook(bookshop.domain.book.Book book) {
        return new Book(book.getId(),
                book.getName(),
                book.getGenre(),
                book.getAuthor(),
                book.getCopiesSold(),
                book.getImage(),
                book.getPrice(),
                book.getSynopsis());
    }
}
