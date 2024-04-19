package project;

import java.util.Scanner;

public class LibraryApp {
    private static LibrarySystem library = new LibrarySystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*** Knihovní systém ***");
            System.out.println("1. Přidat knihu");
            System.out.println("2. Aktualizovat knihu");
            System.out.println("3. Smazat knihu");
            System.out.println("4. Změnit dostupnost knihy");
            System.out.println("5. Vypsat všechny knihy");
            System.out.println("6. Vyhledat knihu");
            System.out.println("7. Ukončit program");
            System.out.print("Zvolte možnost: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Odstranění přebytečného konce řádku

            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    System.out.print("Zadejte název knihy pro aktualizaci: ");
                    String titleToUpdate = scanner.nextLine();
                    library.updateBook(titleToUpdate);
                    break;
                case 3:
                    System.out.print("Zadejte název knihy k odstranění: ");
                    String titleToDelete = scanner.nextLine();
                    library.deleteBook(titleToDelete);
                    break;
                case 4:
                    System.out.print("Zadejte název knihy pro změnu dostupnosti: ");
                    String titleToToggle = scanner.nextLine();
                    library.toggleBookAvailability(titleToToggle);
                    break;
                case 5:
                    library.printBooks();
                    break;
                case 6:
                    System.out.print("Zadejte název knihy k vyhledání: ");
                    String titleToFind = scanner.nextLine();
                    library.findBook(titleToFind);
                    break;
                case 7:
                    System.out.println("Ukončení programu...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Neplatná volba. Zkuste to znovu.");
            }
        }
    }
}

