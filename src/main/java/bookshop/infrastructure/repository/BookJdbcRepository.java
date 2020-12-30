package bookshop.infrastructure.repository;

import bookshop.domain.book.BookData;
import bookshop.domain.book.author.Author;
import bookshop.domain.book.Book;
import bookshop.domain.book.BookId;
import bookshop.domain.book.repository.BookRepository;
import bookshop.domain.book.Genre;
import bookshop.domain.user.basket.BookIds;
import bookshop.infrastructure.mapper.SqlDataToBookMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class BookJdbcRepository implements BookRepository {

    private static final String leftJoinSqlQuery = "select b.id, b.author_id, b.name, b.genre, b.copies_sold, b.image, a.first_name, a.last_name, a.synopsis " +
            "from books as b " +
            "left join authors as a " +
            "on b.author_id = a.id ";

    private final JdbcTemplate jdbcTemplate;

    private final SqlDataToBookMapper sqlDataToBookMapper;

    public BookJdbcRepository(JdbcTemplate jdbcTemplate, SqlDataToBookMapper sqlDataToBookMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.sqlDataToBookMapper = sqlDataToBookMapper;
    }

    @Override
    public Set<Book> getTenBestsellerBooks() {
        String sqlQuery = leftJoinSqlQuery + "order by copies_sold desc limit 10";
        return new HashSet<>(getBooksBySqlQuery(sqlQuery));
    }

    @Override
    public Set<Book> getBooks() {
        return new HashSet<>(getBooksBySqlQuery(leftJoinSqlQuery));
    }

    @Override
    public Set<Book> findBooksByIds(BookIds bookIds) {
        String sqlQuery = leftJoinSqlQuery + "where b.id in (" + bookIdsRepresentationForSqlQuery(bookIds) + ")";
        return new HashSet<>(getBooksBySqlQuery(sqlQuery));
    }

    @Override
    public Book findBookByName(String name) {
        String sqlQuery = leftJoinSqlQuery + "where b.name = '" + name + "'";
        List<Book> booksBySqlQuery = getBooksBySqlQuery(sqlQuery);
        return booksBySqlQuery.get(0);
    }

    @Override
    public Set<Book> findBooksByGenre(Genre genre) {
        String sqlQuery = leftJoinSqlQuery + "where b.genre = '" + genre.getGenreName() + "';";
        return new HashSet<>(getBooksBySqlQuery(sqlQuery));
    }

    @Override
    public void saveBook(BookData bookData) {
        String sql = "insert into books (id, name, image, genre, copies_sold, author_id) values (" +
                bookData.getId() + ", " +
                "'" + bookData.getName() + "', " +
                "'" + bookData.getImage() + "', " +
                "'" + bookData.getGenre().getGenreName() + "', " +
                bookData.getCopiesSold() + ", " +
                bookData.getAuthorId() + ")";

        jdbcTemplate.update(sql);
    }

    @Override
    public void saveAuthor(Author author) {
        String sqlQuery = "insert into authors (id, first_name, last_name, synopsis) values (" +
                author.getId() + ", " +
                "'" + author.getFirstName() + "', " +
                "'" + author.getLastName() + "', " +
                "'" + author.getSynopsis() + "')";
        jdbcTemplate.update(sqlQuery);
    }

    private String bookIdsRepresentationForSqlQuery(BookIds bookIds) {
        StringBuilder bookIdString = new StringBuilder();
        List<BookId> bookIdsList = new ArrayList<>(bookIds.getBookIds());

        for (BookId bookId : bookIdsList) {
            int value = bookId.getValue();
            String valueString = value + ", ";
            bookIdString.append(valueString);
        }

        bookIdString.delete(bookIdString.length() - 2, bookIdString.length() - 1);
        return bookIdString.toString();
    }

    private List<Book> getBooksBySqlQuery(String sqlQuery) {
        return jdbcTemplate.query(sqlQuery, sqlDataToBookMapper);
    }
}
