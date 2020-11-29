package bookshop.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;
import java.util.List;

@Service
@CrossOrigin("http://localhost:4200")
public class BookService {

    @Autowired
    private EntityManager entityManager;

    private BooksRepository booksRepository;

    public BookService(EntityManager entityManager, BooksRepository booksRepository) {
        this.entityManager = entityManager;
        this.booksRepository = booksRepository;
    }

    @Transactional
    //TODO use domain only
    public void saveBook(bookshop.infrastructure.Book book) {
        entityManager.persist(book);
    }

    public Set<Book> getBooks() {
        return booksRepository.getBooks();
    }

    public Set<Book> findBookByName(String name) {
        return booksRepository.findBookByName(name);
    }

    public Set<Book> findBooksByGenre(Genre genre) {
        return booksRepository.findBooksByGenre(genre);
    }

    public Set<Book> getFiveRandomBestsellers() {

        List<Book> tenBestsellersList = new ArrayList<>(booksRepository.getTenBestsellerBooks());
        Set<Book> fiveBestsellersSet = new HashSet<>();

        while (fiveBestsellersSet.size() < 5) {
            Book book = tenBestsellersList.get(new Random().nextInt(tenBestsellersList.size()));
            fiveBestsellersSet.add(book);
        }

        return fiveBestsellersSet;
    }
}