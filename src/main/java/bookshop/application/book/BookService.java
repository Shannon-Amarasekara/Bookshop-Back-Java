package bookshop.application.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Service
@CrossOrigin("http://localhost:4200")
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<Book> findAll() {
        return bookDAO.getBooks();
    }

    public void save(Book book) {
        bookDAO.save(book);
    }

    public List<Book> findByName(String name) {
        List<Book> books = findAll();
        ArrayList<Book> booksWithName = new ArrayList<>();

        for (Book book : books ) {
            if (book.getName().toLowerCase().equals(name)) {
                booksWithName.add(book);
            }
        }
        return booksWithName;
    }
}