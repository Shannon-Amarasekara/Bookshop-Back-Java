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

    private BookMapper bookMapper = new BookMapper();

    public BooksRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Set<Book> getTenBestsellerBooks() {
        String sqlQuery = "select * from books order by copies_sold desc limit 10";
        List<bookshop.infrastructure.Book> books = jdbcTemplate.query(sqlQuery, new BookMapper());
        return convertToDomainObject(new HashSet<>(books));
    }

    @Override
    public Set<Book> getBooks() {
        String sqlSelectAll = "select * from books";
        List<bookshop.infrastructure.Book> books = jdbcTemplate.query(sqlSelectAll, new BookMapper());
        return convertToDomainObject(new HashSet<>(books));
    }

    @Override
    public Set<Book> findBookByName(String name) {
        String sqlQuery = "select * from books where name like '%" + name + "%' ";
        List<bookshop.infrastructure.Book> books = jdbcTemplate.query(sqlQuery, new BookMapper());
        return convertToDomainObject(new HashSet<>(books));
    }

    @Override
    public Set<Book> findBooksByGenre(Genre genre) {
        String sqlQuery = "select * from books where genre = '" + genre.getGenreName() + "'";
        List<bookshop.infrastructure.Book> books = jdbcTemplate.query(sqlQuery, new BookMapper());
        return convertToDomainObject(new HashSet<>(books));
    }

    private Set<Book> convertToDomainObject(Set<bookshop.infrastructure.Book> fiveRandomBestSellersFromBookTable) {
        return bookMapper.mapSetOfBooksToBookInDomain(fiveRandomBestSellersFromBookTable);
    }
}
