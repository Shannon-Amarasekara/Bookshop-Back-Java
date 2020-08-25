package bookshop.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@CrossOrigin("http://localhost:4200")
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        Iterable<Book> books = bookRepository.findAll();
        ArrayList<Book> bookArrayList = new ArrayList<>();
        books.forEach(bookArrayList::add);
        return bookArrayList;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findByName(String name) {
        Iterable<Book> books = bookRepository.findAll();
        List<Book> booksWithName = new ArrayList<>();

        for (Book book : books) {
            if (book.getName().equals(name)) {
                booksWithName.add(book);
            }
        }
        return booksWithName;
    }

    public Optional<Book> getBook(int bookId){
        return bookRepository.findById(bookId);
    }
}