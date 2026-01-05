import java.io.FileReader; // character stream
import java.util.Scanner; // user input
import java.io.FileNotFoundException; 

// package-private class (no "public" keyword) 
class ReadFileExampleWithScanner {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            // FileReader looks for the directory of where the terminal is running the file (if only filename given).
            System.out.println("Enter the name of the file you want to read.");
            Scanner fileScanner = new Scanner(new FileReader(scanner.nextLine()));
            while (fileScanner.hasNext()) {
                String fileLine = fileScanner.nextLine();
                System.out.println(fileLine);
            }
            // close the file scanner
            fileScanner.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        scanner.close(); // close scanner
    }
}

