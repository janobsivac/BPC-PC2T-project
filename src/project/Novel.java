package project;

public class Novel extends Book {
    private String genre;

    public Novel(String title, String author, int yearPublished, boolean isAvailable, String genre) {
        super(title, author, yearPublished, isAvailable);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Novel{" +
               "title='" + getTitle() + '\'' +
               ", author='" + getAuthor() + '\'' +
               ", yearPublished=" + getYearPublished() +
               ", isAvailable=" + isAvailable() +
               ", genre='" + genre + '\'' +
               '}';
    }
}


