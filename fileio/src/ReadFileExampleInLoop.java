import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class ReadFileExampleInLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // continue to prompt user to enter file names until 'exit' is typed in by user
        while (true) {
            System.out.println("Enter the name of the file you want to read (or type 'exit' to quit): ");
            String userInput = scanner.nextLine();
            if ("exit".equalsIgnoreCase(userInput)) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }
            try {
                Scanner fileScanner = new Scanner(new FileReader(userInput)); 
                while (fileScanner.hasNext()) {
                    String fileLine = fileScanner.nextLine();
                    System.out.println(fileLine);
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
