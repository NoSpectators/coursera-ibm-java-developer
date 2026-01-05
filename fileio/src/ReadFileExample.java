import java.io.IOException; // for trying to read a file
// ! Tools from the NIO.2 library used to locate, create, and manipulate files 
// and directories using modern path-based logic.
import java.nio.file.Files; 
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner; // user input

public class ReadFileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to read.");
        Path filePath = Paths.get(scanner.nextLine());
        try {
            String content = Files.readString(filePath);
            // read the entire content of the file as a single string 
            System.out.println(content);
        } catch(IOException e) {
            // System.err used for official Error messages, warnings, logs
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
