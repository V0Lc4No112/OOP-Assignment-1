import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private final ArrayList<Book> books;
    private final Scanner scanner;

    public LibraryApp() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("=================================");
            System.out.println("Welcome to Library App!");
            System.out.println("=================================");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                choice = -1;
            }

            // handle choice
            switch (choice) {
                case 1:
                    printAllBooks();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    searchBooksByTitle();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBookById();
                    break;
                case 7:
                    System.out.println("Thank you for using Library App. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private void printAllBooks() {
        System.out.println("\n--- All Books ---");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void addNewBook() {
        System.out.println("\n--- Add New Book ---");

        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine());

            Book newBook = new Book(title, author, year);
            books.add(newBook);

            System.out.println("Book added successfully!");
            System.out.println(newBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        }
    }

    private void searchBooksByTitle() {
        System.out.println("\n--- Search Books by Title ---");
        System.out.print("Enter title (or part of title): ");
        String search = scanner.nextLine();

        ArrayList<Book> found = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(search.toLowerCase())) {
                found.add(book);
            }
        }

        if (found.isEmpty()) {
            System.out.println("No books found with that title.");
        } else {
            System.out.println("Found " + found.size() + " book(s):");
            for (Book book : found) {
                System.out.println(book);
            }
        }
    }

    private void borrowBook() {
        System.out.println("\n--- Borrow a Book ---");
        System.out.print("Enter book ID: ");

        try {
            int id = Integer.parseInt(scanner.nextLine());

            Book book = null;
            for (Book value : books) {
                if (value.getId() == id) {
                    book = value;
                    break;
                }
            }

            if (book == null) {
                System.out.println("Book not found with ID: " + id);
            } else if (!book.isAvailable()) {
                System.out.println("This book is already borrowed.");
            } else {
                book.markAsBorrowed();
                System.out.println("Book borrowed successfully!");
                System.out.println(book);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid ID.");
        }
    }

    private void returnBook() {
        System.out.println("\n--- Return a Book ---");
        System.out.print("Enter book ID: ");

        try {
            int id = Integer.parseInt(scanner.nextLine());

            Book book = null;
            for (Book value : books) {
                if (value.getId() == id) {
                    book = value;
                    break;
                }
            }

            if (book == null) {
                System.out.println("Book not found with ID: " + id);
            } else if (book.isAvailable()) {
                System.out.println("This book was not borrowed.");
            } else {
                book.markAsReturned();
                System.out.println("Book returned successfully!");
                System.out.println(book);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid ID.");
        }
    }

    private void deleteBookById() {
        System.out.println("\n--- Delete a Book ---");
        System.out.print("Enter book ID: ");

        try {
            int id = Integer.parseInt(scanner.nextLine());

            Book bookToDelete = null;
            for (Book book : books) {
                if (book.getId() == id) {
                    bookToDelete = book;
                    break;
                }
            }

            if (bookToDelete == null) {
                System.out.println("Book not found with ID: " + id);
            } else {
                books.remove(bookToDelete);
                System.out.println("Book deleted successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid ID.");
        }
    }

    static void main() {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}