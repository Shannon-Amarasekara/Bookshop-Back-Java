package bookshop.infrastructure;

import bookshop.domain.book.Genre;
import bookshop.domain.book.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class SqlDataToBookMapper implements RowMapper<Book>{

    public SqlDataToBookMapper() {
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
        return Genre.valueOf(genre.substring(0,1).toUpperCase() + genre.substring(1).toLowerCase());
    }

}
