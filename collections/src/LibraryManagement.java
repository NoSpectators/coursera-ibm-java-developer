import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// LibraryManagement class to manage the book collection
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        
        ArrayList<Book> library = new ArrayList<>(); 
 
        // Step 4: Create the main menu loop
        // Hint: Use a while loop with a boolean flag or a while(true) with a break
        boolean running = true;
        while (running) {
            System.out.println("\n======Library Management System======");
            System.out.println("1. Add a book" + 
                         "\n2. View all books" + 
                         "\n3. Search for a book by title" + 
                         "\n4. Check out a book" + 
                         "\n5. Return a book" + 
                         "\n6. Sort books (by title, author, or publication year)" + 
                         "\n7. View available books only" + 
                         "\n8. Exit");
	
            int choice; 
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1 -> addBook(scanner, library);  
                case 2 -> viewAllBooks(library);
                case 3 -> searchBooks(scanner, library);
                case 4 -> checkOutBook(scanner, library);
                case 5 -> returnBook(scanner, library);
                case 6 -> sortBooks(scanner, library);
                case 7 -> viewAvailableBooks(library);
                case 8 -> {
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    running = false;
                } 
                default -> System.out.println("Invalid choice. Please try again.");
        
            }
        }
        scanner.close();
    }

    // Note: some methods need the Scanner instance for additional user engagement
    public static void addBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n------ Add a New Book ------");     
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        // use try / catch within a forever loop for correct user input
        int year = 0;
        while (true) {
            System.out.print("Enter publication year: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                if (year < 0 || year > 2025) {
                    System.out.println("Year must be between 0 and 2025");
                } else {
                    break; // success! exit loop
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a number.");
            }
        }
        Book newBook = new Book(title, author, year);
        library.add(newBook); // use the add() method defined on ArrayList instance (library) to add the book
        System.out.println("Book added successfully: " + newBook);
    }

    public static void viewAllBooks(ArrayList<Book> library) {
        System.out.println("\n------ All Books in Library ------"); 
        if (library.isEmpty()) {
            System.out.println("The library is empty");
            return;
        }
        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + ". " + library.get(i));
        }
    }

    public static void searchBooks(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n------ Search Books ------");
        System.out.print("Enter search term (title or author): ");
        String searchTerm = scanner.nextLine().toLowerCase();
        System.out.println("Search results:");
        boolean found = false;
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            if (book.getBookTitle().toLowerCase().contains(searchTerm) || 
                book.getAuthor().toLowerCase().contains(searchTerm)) {
                System.out.println((i+1) + ". " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found matching \"" + searchTerm + "\"");
        }
    }
    public static void checkOutBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n------ Check Out a Book ------");
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        System.out.println("Available books:");
        boolean isAvailable = false;
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            if (book.getIsAvailable()) {
                System.out.println((i+1) + ". " + book);
                isAvailable = true;
            }
        }
        if (!isAvailable) {
            System.out.println("No books are currently available.");
            return;
        }
        System.out.print("Enter the number of the book to check out: ");
        try {
            int bookNumber = Integer.parseInt(scanner.nextLine());
            if (bookNumber < 1 || bookNumber > library.size()) {
                System.out.println("Invalid book number.");
                return; 
            }
            Book book = library.get(bookNumber-1); // arraylist starts at 0 index
            if (book.checkOut()) {
                System.out.println("Book checked out successfully: " + book);
            } else {
                System.out.println("Book is already checked out.");
            }
        } catch(NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    public static void returnBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n------ Return a Book ------");
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        System.out.println("Checked out books:");
        boolean isCheckedOut = false; // flag to determine if all books are checked out or not
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            if (!book.getIsAvailable()) { // not available to check out = checked out already
                System.out.println((i+1) + ". " + book);
                isCheckedOut = true;
            }
        }
        if (!isCheckedOut) {
            System.out.println("No books are currently checked out.");
            return; 
        }
        System.out.println("Enter the number of the book to return: ");
        try {
            int bookNumber = Integer.parseInt(scanner.nextLine());
            if (bookNumber < 1 || bookNumber > library.size()) {
                System.out.println("Invalid book number.");
                return;
            }
            Book book = library.get(bookNumber-1); // arraylist stores starting at index 0
            if (book.returnBook()) {
                System.out.println("Book returned successfully: " + book);
            } else {
                System.out.println("Book was not checked out");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        
    }
    public static void sortBooks(Scanner scanner, ArrayList<Book> library) {
        
    }
    public static void viewAvailableBooks(ArrayList<Book> library) {
        
    }
    
}
