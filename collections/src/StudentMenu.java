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
            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter student age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter student major: ");
                String major = scanner.nextLine();
                students.add(new Student(name, age, major));
                System.out.println("\nStudent added successfully!");
            } else if (choice == 2) {
                if (students == null || students.isEmpty()) {
                    System.out.println("\nError: The student list is empty.");
                } else { 
                    System.out.print("\nEnter the index of the student to update: ");
                    int stIdx = Integer.parseInt(scanner.nextLine());
                    // check if index is valid
                    if (stIdx >= 0 && stIdx < students.size()) {
                        System.out.print("Enter new name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new major: ");
                        String major = scanner.nextLine();
                        // update the students details
                        students.get(stIdx).setName(name);
                        students.get(stIdx).setAge(age);
                        students.get(stIdx).setMajor(major);
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Invalid index. No student found.");
                    }
                }
            } else if (choice == 3) {
                if (students == null || students.isEmpty()) {
                    System.out.println("\nError: The student list is empty.");
                } else { 
                    System.out.print("Enter the index of the student to delete: ");
                    int stIdx = Integer.parseInt(scanner.nextLine());
                    if (stIdx >= 0 && stIdx <= students.size()) {
                        students.remove(stIdx);
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Invalid index. No student found.");
                    }
                }
            } else if (choice == 4) { // display all students
                 if (students == null || students.isEmpty()) {
                     System.out.println("\nError. The student list is empty."); 
                 } else {
                     System.out.println("\n=======Students=======");
                     for (int i = 0; i < students.size(); i++) {
                         System.out.println(i + ". " + students.get(i));
		     }
                 }
            } else if (choice ==5) {
                // sort the students using a custom Comparator
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        // sort in ascending order of age
                        return Integer.compare(s1.getAge(), s2.getAge());
                    }
                });

                System.out.println("=====Students sorted by age (ascending):");
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(i + ". " + students.get(i));
                }
            } else if (choice == 6) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close(); 
    }
}
