package bookshop.domain.book;

import java.util.Objects;

//TODO delete class
public class BookData {

    private int id;
    private String name;
    private String image;
    private Genre genre;
    private long copiesSold;
    private int authorId;

    public BookData() {
    }

    public BookData(int id, String name, String image, Genre genre, long copiesSold, int authorId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.genre = genre;
        this.copiesSold = copiesSold;
        this.authorId = authorId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public long getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(long copiesSold) {
        this.copiesSold = copiesSold;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookData bookData = (BookData) o;
        return id == bookData.id &&
                copiesSold == bookData.copiesSold &&
                authorId == bookData.authorId &&
                Objects.equals(name, bookData.name) &&
                Objects.equals(image, bookData.image) &&
                genre == bookData.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, genre, copiesSold, authorId);
    }
}