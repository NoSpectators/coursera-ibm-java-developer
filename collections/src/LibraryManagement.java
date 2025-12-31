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
                // Step 6: Implement the addBook functionality
                // Hint: Prompt the user for title, author, and publication year
                case 1 -> addBook(scanner, library);  


                // Step 7: Implement the viewAllBooks functionality
                // Hint: Use a loop or forEach to display all books
        
                // Step 8: Implement the search functionality
                // Hint: Take user input for search term and check each book
        
                // Step 9: Implement the checkOut functionality
                // Hint: Find the book by index and use the checkOut() method
        
                // Step 10: Implement the returnBook functionality
                // Hint: Find the book by index and use the returnBook() method
        
                // Step 11: Implement the sortBooks functionality
                // Hint: Use Collections.sort() with a Comparator
        
                // Step 12: Implement the viewAvailableBooks functionality
                // Hint: Use ArrayList's stream() or loop through to filter
	    }
        
        }
        scanner.close();
    }
    // additional methods
    public static void addBook(Scanner scanner, ArrayList<Book> library) {
        
    }
}
