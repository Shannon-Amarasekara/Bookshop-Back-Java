package bookshop.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Qualifier
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init(BookService bookService) {
        return args -> {
            jdbcTemplate.execute("DROP TABLE IF EXISTS Book");

            jdbcTemplate.execute("CREATE TABLE Book (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(100)," +
                    "author VARCHAR (100)," +
                    "image BLOB" +
                    ");"
            );

            bookService.save(new Book(1, "Misery", "Stephen King", "/assets/images/misery.jpg"));
            bookService.save(new Book(2, "Harry Potter", "J.K.Rowling", "/assets/images/harry-potter.jpg"));
            bookService.save(new Book(3, "The Golden Compass", "Philip Pullman", "/assets/images/the-golden-compass.jpg"));

            bookService.findAll().forEach(System.out::println);

            log.info("Table library added.");
        };
    }
}