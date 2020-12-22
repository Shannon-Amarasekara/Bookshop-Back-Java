package bookshop.infrastructure;

import bookshop.domain.Book;
import bookshop.domain.BooksRepository;
import bookshop.domain.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class BooksRepositoryImpl implements BooksRepository {

    private JdbcTemplate jdbcTemplate;

    private SqlDataToBookMapper sqlDataToBookMapper;

    public BooksRepositoryImpl(JdbcTemplate jdbcTemplate, SqlDataToBookMapper sqlDataToBookMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.sqlDataToBookMapper = sqlDataToBookMapper;
    }

    @Override
    public void saveBook(Book book) {
        String sql = "INSERT INTO BOOKS (id, author, copies_sold, image, name, genre) VALUES (" +
                book.getId() + ", '" +
                book.getAuthor() + "', " +
                book.getCopiesSold() + ", '" +
                book.getImage() + "', '" +
                book.getName() + "', '" +
                book.getGenre().getGenreName() + "');";

        jdbcTemplate.update(sql);
    }

    @Override
    public void saveBooks(Set<Book> books) {
        for (Book book : books) {
            saveBook(book);
        }
    }

    @Override
    public Set<Book> getTenBestsellerBooks() {
        String sqlQuery = "select * from books order by copies_sold desc limit 10";
        return new HashSet<>(executeSqlQuery(sqlQuery));
    }

    @Override
    public Set<Book> getBooks() {
        String sqlQuery = "select * from books";
        return new HashSet<>(executeSqlQuery(sqlQuery));
    }

    @Override
    public Set<Book> findBookByName(String name) {
        String sqlQuery = "select * from books where name like '%" + name + "%' ";
        return new HashSet<>(executeSqlQuery(sqlQuery));
    }

    @Override
    public Set<Book> findBooksByGenre(Genre genre) {
        String sqlQuery = "select * from books where genre = '" + genre.getGenreName() + "'";
        return new HashSet<>(executeSqlQuery(sqlQuery));
    }

    private List<Book> executeSqlQuery(String sqlQuery) {
        return jdbcTemplate.query(sqlQuery, sqlDataToBookMapper);
    }
}
