package bookshop.infrastructure;

import bookshop.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Service
//TODO rename class
//TODO RowMapper<domain Book>
public class BookMapper implements RowMapper<Book>{

    public BookMapper() {
    }

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setAuthor(resultSet.getString("author"));
        book.setCopiesSold(resultSet.getLong("copies_sold"));
        book.setImage(resultSet.getString("image"));
        book.setName(resultSet.getString("name"));
        book.setGenre(convertToGenre(resultSet.getString("genre")));

        return book;
    }

    private Genre convertToGenre(String genre) {
        return Genre.valueOf(genre);
    }

    public Set<bookshop.domain.Book> mapSetOfBooksToBookInDomain(Set<Book> books){
        Set<bookshop.domain.Book> listOfDomainBooks = new HashSet<>();
        for(Book book: books){
            listOfDomainBooks.add(mapToBookInDomain(book));
        }
        return listOfDomainBooks;
    }

    private bookshop.domain.Book mapToBookInDomain(Book book) {
        bookshop.domain.Book domainBook = new bookshop.domain.Book();

        domainBook.setId(book.getId());
        domainBook.setAuthor(book.getAuthor());
        domainBook.setCopiesSold(book.getCopiesSold());
        domainBook.setImage(book.getImage());
        domainBook.setName(book.getName());
        domainBook.setGenre(book.getGenre());

        return domainBook;
    }
}
