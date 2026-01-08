// ContactReader.java
// This program reads contact information from a file and displays it in a formatted way
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ContactReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter the name of the contacts file:"); 
        String fileName = scanner.nextLine(); 
        int contactCount = 0; 
        try {
            // buffered reader is more efficient for reading lines from a file 
            BufferedReader reader = new BufferedReader(new FileReader(fileName)); 
            String line;
            System.out.println("\n======CONTACT LIST======");
            // read each line in file. if not null, read the correctly-formatted lines. 
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(":"); // expected format: Name:PhoneNumber
                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        String phoneNumber = parts[1].trim();
                        System.out.println("Contact: " + name + " | Phone: " + phoneNumber);
                        contactCount++;
                    } else {
                        System.out.println("Warning: Skipping improperly formatted line: " + line);
                    }
                } 
            }
            reader.close(); // close the filereader after last line in file 
            System.out.println("\nTotal contacts read: " + contactCount);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + fileName);
            System.err.println("Please check the file name and path and try again.");
        } catch(IOException e) {
            System.err.println("Error reading from a file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage()); 
        } finally {
            scanner.close(); // close resources 
        }
        
        // Optional Bonus:
        // Step 11: Add a feature to count and display the total number of contacts read
    }
}
