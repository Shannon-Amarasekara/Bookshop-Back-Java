package bookshop.infrastructure.mapper;

import bookshop.domain.book.author.Author;
import bookshop.domain.book.Book;
import bookshop.domain.book.BookId;
import bookshop.domain.book.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class SqlDataToBookMapper implements RowMapper<Book> {

    public SqlDataToBookMapper() {
    }

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setId(new BookId(resultSet.getInt("id")));
        book.setName(resultSet.getString("name"));
        book.setCopiesSold(resultSet.getLong("copies_sold"));
        book.setImage(resultSet.getString("image"));
        book.setGenre(convertToGenre(resultSet.getString("genre")));
        book.setPrice(resultSet.getBigDecimal("price"));
        book.setSynopsis(resultSet.getString("synopsis"));
        book.setAuthor(new Author(
                resultSet.getInt("author_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("resume"))
        );
        return book;
    }

    private Genre convertToGenre(String genre) {
        return Genre.valueOf(genre.substring(0, 1).toUpperCase() + genre.substring(1).toLowerCase());
    }
}
