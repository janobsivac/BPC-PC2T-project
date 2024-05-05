package project;

public class Textbook extends Book {
    private int gradeLevel;

    public Textbook(String title, String author, int yearPublished, boolean isAvailable, int gradeLevel) {
        super(title, author, yearPublished, isAvailable);
        this.gradeLevel = gradeLevel;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public String toString() {
        return "Textbook{" +
               "title='" + getTitle() + '\'' +
               ", author='" + getAuthor() + '\'' +
               ", yearPublished=" + getYearPublished() +
               ", isAvailable=" + isAvailable() +
               ", gradeLevel=" + gradeLevel +
               '}';
    }
}


