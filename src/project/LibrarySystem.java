package project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LibrarySystem {
    private ArrayList<Book> books;  // Seznam knih v systému

    public LibrarySystem() {
        books = new ArrayList<>();
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte název knihy:");
        String title = scanner.nextLine();

        System.out.println("Zadejte autora knihy:");
        String author = scanner.nextLine();

        System.out.println("Zadejte rok vydání:");
        int yearPublished = scanner.nextInt();

        System.out.println("Je kniha dostupná? (true/false)");
        boolean isAvailable = scanner.nextBoolean();

        Book newBook = new Book(title, author, yearPublished, isAvailable);
        books.add(newBook);
        System.out.println("Kniha byla přidána: " + newBook);
    }

    public void updateBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Zadejte nového autora:");
                String author = scanner.nextLine();
                book.setAuthor(author);

                System.out.println("Zadejte nový rok vydání:");
                int year = scanner.nextInt();
                book.setYearPublished(year);

                System.out.println("Je kniha dostupná? (true/false)");
                boolean isAvailable = scanner.nextBoolean();
                book.setAvailable(isAvailable);

                System.out.println("Údaje o knize byly aktualizovány.");
                break;
            }
        }
    }

    public void deleteBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        System.out.println("Kniha byla odstraněna.");
    }

    public void toggleBookAvailability(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setAvailable(!book.isAvailable());
                System.out.println("Stav dostupnosti knihy byl změněn.");
                break;
            }
        }
    }

    public void printBooks() {
        books.sort(Comparator.comparing(Book::getTitle));
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                break;
            }
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook();  // Přidání knihy
        library.printBooks();  // Výpis knih
        // další interakce s uživatelem a manipulace s knihami
    }
}


