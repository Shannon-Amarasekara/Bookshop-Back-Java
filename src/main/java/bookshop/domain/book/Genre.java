package bookshop.domain.book;

public enum Genre {

    Horror("Horror"),
    Fantasy("Fantasy"),
    Romance("Romance"),
    Science("Science"),
    Philosophy("Philosophy");

    private final String genreName;

    Genre(String genreName){
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }
}
