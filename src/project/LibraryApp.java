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
            System.out.println("7. Výpis knih daného autora");
            System.out.println("8. Výpis knih daného žánru");
            System.out.println("9. Výpis všech vypůjčených knih");
            System.out.println("10. Uložit knihu do souboru");
            System.out.println("11. Načíst knihu ze souboru");
            System.out.println("12. Ukončit program");
            System.out.print("Zvolte možnost: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                scanner.nextLine(); // Odstranění přebytečného konce řádku
            }
            
            catch (NumberFormatException e) {
                System.out.println("Neplatná volba. Zkuste to znovu.");
                continue;
            }

                switch (choice) {
                    case 1:
                    	try {
                            library.addBook();
                        } catch (Exception e) {
                            System.out.println("Chyba při přidávání knihy: " + e.getMessage());
                        }
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
                        System.out.print("Zadejte autora: ");
                        String author = scanner.nextLine();
                        library.printBooksByAuthor(author);
                        break;
                    case 8:
                        System.out.print("Zadejte žánr: ");
                        String genre = scanner.nextLine();
                        library.printBooksByGenre(genre);
                        break;
                    case 9:
                        library.printBorrowedBooks();
                        break;
                    case 10:
                        System.out.print("Zadejte název knihy k uložení: ");
                        String titleToSave = scanner.nextLine();
                        library.saveBookToFile(titleToSave);
                        break;
                    case 11:
                        System.out.print("Zadejte název souboru k načtení: ");
                        String filename = scanner.nextLine();
                        library.loadBookFromFile(filename);
                        break;
                    case 12:
                        System.out.println("Ukončení programu...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Neplatná volba. Zkuste to znovu.");
                }
            }
            
        }
    }

