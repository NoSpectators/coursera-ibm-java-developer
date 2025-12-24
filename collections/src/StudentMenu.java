import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/*
 * Create a console menu to add, update, delete items in the list and sort the students by age.
 */
public class StudentMenu {
    public static void main(String[] args) {
        // Create an array list to store Student objects
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display menu options
            System.out.println("\nMenu:");
            System.out.println("\n1. Add a student");
            System.out.println("\n2. Update a student");
            System.out.println("\n3. Delete a student");
            System.out.println("\n4. View all students");
            System.out.println("\n5. Sort students by age");
            System.out.println("\n6. Exit");
            System.out.println("\nEnter your choice: ");
           
            // read the user's choice
            int choice = Integer.parseInt(scanner.nextLine());

	}
        scanner.close(); 
    }
}
