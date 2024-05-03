package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibrarySystem {
    private List<Book> books;  // Seznam knih

    public LibrarySystem() {
        books = new ArrayList<>();
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        String type = "";
        
        while (!type.equalsIgnoreCase("Roman") && !type.equalsIgnoreCase("Ucebnice")) {
            System.out.println("Zadejte typ knihy ('Roman' nebo 'Ucebnice'):");
            type = scanner.nextLine().trim();
            if (!type.equalsIgnoreCase("Roman") && !type.equalsIgnoreCase("Ucebnice")) {
                System.out.println("Neplatný typ knihy. Prosím, zadejte 'Roman' nebo 'Ucebnice'.");
            }
        }

        System.out.println("Zadejte název knihy:");
        String title = scanner.nextLine();

        System.out.println("Zadejte autora knihy:");
        String author = scanner.nextLine();

        System.out.println("Zadejte rok vydání:");
        int yearPublished = 0;
        boolean validYear = false;
        while (!validYear) {
            try {
                yearPublished = Integer.parseInt(scanner.nextLine());
                validYear = true; // Rok byl úspěšně zadán, opustíme smyčku
            } catch (NumberFormatException e) {
                System.out.println("Neplatný rok vydání. Prosím, zadejte číslo.");
            }
        }

        boolean isAvailable = true; // Nově přidané knihy jsou defaultně dostupné

        scanner.nextLine(); // Clear the buffer

        if (type.equalsIgnoreCase("Roman")) {
            System.out.println("Zadejte žánr:");
            String genre = scanner.nextLine();
            books.add(new Novel(title, author, yearPublished, isAvailable, genre));
        } else if (type.equalsIgnoreCase("Ucebnice")) {
            System.out.println("Zadejte ročník, pro který je učebnice určena:");
            int gradeLevel = 0;
            validYear = false;
            while (!validYear) {
                try {
                    gradeLevel = Integer.parseInt(scanner.nextLine());
                    validYear = true; // Ročník byl úspěšně zadán, opustíme smyčku
                } catch (NumberFormatException e) {
                    System.out.println("Neplatný ročník. Prosím, zadejte číslo.");
                }
            }
            books.add(new Textbook(title, author, yearPublished, isAvailable, gradeLevel));
        }
        System.out.println("Kniha byla přidána.");
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

    public void printBooksByAuthor(String author) {
        books.stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(author))
            .sorted(Comparator.comparingInt(Book::getYearPublished))
            .forEach(System.out::println);
    }

    public void printBooksByGenre(String genre) {
        books.stream()
            .filter(book -> book instanceof Novel && ((Novel)book).getGenre().equalsIgnoreCase(genre))
            .forEach(System.out::println);
    }

    public void printBorrowedBooks() {
        books.stream()
            .filter(book -> !book.isAvailable())
            .forEach(book -> {
                String type = book instanceof Novel ? "Román" : "Učebnice";
                System.out.println(book + " Typ: " + type);
            });
    }
    
    public void saveBookToFile(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                try (FileWriter writer = new FileWriter(title + ".txt")) {
                    writer.write(book.toString());
                    System.out.println("Kniha byla uložena do souboru.");
                } catch (IOException e) {
                    System.out.println("Nepodařilo se uložit knihu do souboru: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Kniha s názvem '" + title + "' nebyla nalezena.");
    }

    public void loadBookFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            System.out.println("Načtená data knihy: " + line);
        } catch (IOException e) {
            System.out.println("Nepodařilo se načíst knihu ze souboru: " + e.getMessage());
        }
    }
}


