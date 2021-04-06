package bookshop.domain.book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Genre {

    Horror("Horror"),
    Fantasy("Fantasy"),
    Romance("Romance"),
    Science("Science"),
    Philosophy("Philosophy");

    private final String genreName;

    Genre(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }

    public static Set<Genre> getGenres() {
        return new HashSet<>(Arrays.asList(
                Horror,
                Fantasy,
                Romance,
                Science,
                Philosophy
        ));
    }
}
