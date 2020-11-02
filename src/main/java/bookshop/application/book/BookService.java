package bookshop.application.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@CrossOrigin("http://localhost:4200")
public class BookService implements BookDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Book> getBooks() {
        TypedQuery<Book> namedQuery = entityManager.createNamedQuery("find all books", Book.class);
        return namedQuery.getResultList();
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public List<Book> findBook(String name) {
        List<Book> books = getBooks();
        ArrayList<Book> booksWithName = new ArrayList<>();

        for (Book book : books) {
            if (book.getName().toLowerCase().contains(name.toLowerCase())) {
                booksWithName.add(book);
            }
        }
        return booksWithName;
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        List<Book> books = getBooks();
        List<Book> booksWithGenre = new ArrayList<>();

        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                booksWithGenre.add(book);
            }
        }
        return booksWithGenre;
    }

    @Override
    public List<Book> findByGenres(Genre[] genres) {
        List<Book> books = getBooks();
        List<Book> booksWithGenres = new ArrayList<>();

        for(Book book: books){
            for(Genre genre: genres){
                if(book.getGenre().equals(genre)){
                    booksWithGenres.add(book);
                }
            }
        }
        return booksWithGenres;
    }

}