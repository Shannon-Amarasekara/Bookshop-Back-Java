package bookshop.application.book;

public enum Genre {

    Horror("Horror"),
    Fantasy("Fantasy"),
    Romance("Romance"),
    Science("Science");

    private final String genreName;

    Genre(String genreName){
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }
}
