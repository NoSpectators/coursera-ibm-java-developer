import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileSystemManager - A command-line file management system
 * 
 * This class provides a shell-like interface for managing files and directories
 */
public class FileSystemManager {
    
    // The current working directory
    private File currentDirectory;
    
    // Scanner for user input
    private Scanner scanner;
    
    // Date formatter for file timestamps
    private SimpleDateFormat dateFormat;
    
    /**
     * Constructor to initialize the file system manager
     */
    public FileSystemManager() {
        currentDirectory = new File(System.getProperty("user.dir"));        
        Scanner scanner = new Scanner(System.in); 
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * Start the file system manager
     */
    public void start() {
        System.out.println("Welcome to the File System Manager!");
        System.out.println("Type 'help' to see available commands.");
        
        boolean running = true;
        while (running) {
            System.out.println(currentDirectory.getAbsolutePath() + "> ");            
            String command = scanner.nextLine().trim(); 
            if (command.equalsIgnoreCase("exit")) {
                running = false;
            } else {
                running = processCommand(command);
            }
        }
        
        scanner.close();
        System.out.println("Thank you for using File System Manager. Goodbye!");
    }
    
    /**
     * Process a user command
     * 
     * @param command The command entered by the user
     * @return true to continue, false to exit
     */
    private boolean processCommand(String command) {
        if (command.isEmpty()) {
            return true; // skip empty commands
        }
        // trim(): remove any accidental spaces at beginning or end of string
        // .split("\\s+", 2): regex to handle one or more spaces, limiting to two words 
        // parts[0].toLowerCase(): first word is the command (ls, cd, etc) 
        // (parts.length > 1): did user type more than one word
        // if yes, it sets args to everything after the first space. 
        // if no, sets args to empty string
        // example: ls folder/my_file.txt
        String[] parts = command.trim().split("\\s+", 2); 
        String commandName = parts[0].toLowerCase();
        String args = (parts.length > 1) ? parts[1] : "";
        
        switch (commandName) {
            case "help":
                displayHelp();
                break;
            case "ls":
                listFiles(); 
                break;
            case "cd":
                changeDirectory(args); 
                break;
            case "pwd":
                System.out.println(currentDirectory.getAbsolutePath()); 
		break;
            case "mkdir":
                if (args.isEmpty()) {
                    System.out.println("Error: Directory name is required");
                } else {
                    createDirectory(args);
                }
		break;
            case "touch":
                if (args.isEmpty()) {
                    System.out.println("Error: File name is required");
                } else {
                    createFile(args);
                }
                break;
            case "rm":
                if (args.isEmpty()) {
                    System.out.println("Error: File or Directory name is required");
                } else {
                    delete(args);
                }
                break;
            case "rename":
                String[] nameParts = args.split("\\s+", 2);
                if (nameParts.length < 2) {
                    System.out.println("Error: Both old and new names are required");
                } else {
                    rename(nameParts[0], nameParts[1]);
                }
                break;
            case "find":
                if (args.isEmpty()) {
                    System.out.println("Error: search pattern is required"); 
                } else {
                    findFiles(args); 
                }
                break;
            case "info":
                if (args.isEmpty()) {
                    System.out.println("Error: file name is required"); 
                } else {
                    displayFileInfo(args); 
                }
                break;
            case "exit":
                return false;
            default:
                System.out.println("Unknown command: " + commandName);
                System.out.println("Type 'help' for available commands.");
        }
        
        return true;
    }
    
    /**
     * Display help information
     */
    private void displayHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("  help              - Display this help message");
        System.out.println("  ls                - List files in current directory");
        System.out.println("  cd <directory>    - Change to specified directory (use .. for parent)");
        System.out.println("  pwd               - Print current directory path");
        System.out.println("  mkdir <name>      - Create a new directory");
        System.out.println("  touch <name>      - Create a new file");
        System.out.println("  rm <name>         - Delete a file or directory");
        System.out.println("  rename <old> <new> - Rename a file or directory");
        System.out.println("  find <pattern>    - Search for files matching pattern");
        System.out.println("  info <name>       - Display file information");
        System.out.println("  exit              - Exit the program");
    }
    
    /**
     * List files and directories in the current directory
     */
    private void listFiles() {
        // Get the list of files and directories in the current directory
        File[] files = currentDirectory.listFiles(); 
        
	if (files == null || files.length == 0) {
            System.out.println("Directory is empty or cannot be accessed.");
            return;
        }
        System.out.println("Contents of " + currentDirectory.getAbsolutePath() + ":");
        System.out.println("Type | Size (bytes) | Last Modified        | Name");
        System.out.println("-------------------------------------------------");
        for (File file : files) {
            // - 'd' if it's a directory or '-' if it's a file
            char type = file.isDirectory() ? 'd' : '-';
            // format the last modified date
            String lastModified = dateFormat.format(new Date(file.lastModified()));
            // display the file information
            System.out.printf(" %c   | %11d | %s | %s%n", type, file.length(), lastModified, file.getName());
        }
    }
    
    /**
     * Change to a different directory
     * 
     * @param dirName The name of the directory to change to
     */
    private void changeDirectory(String dirName) {
        // TODO: Implement changing to a directory
        // If dirName is "..", go to parent directory
        // Otherwise, change to the specified directory if it exists
    }
    
    /**
     * Create a new directory
     * 
     * @param dirName The name of the directory to create
     */
    private void createDirectory(String dirName) {
        // TODO: Implement creating a new directory
        // Create a new directory with the given name in the current directory
    }
    
    /**
     * Create a new file
     * 
     * @param fileName The name of the file to create
     */
    private void createFile(String fileName) {
        // TODO: Implement creating a new file
        // Create a new empty file with the given name in the current directory
    }
    
    /**
     * Delete a file or directory
     * 
     * @param name The name of the file or directory to delete
     */
    private void delete(String name) {
        // TODO: Implement deleting a file or directory
        // If it's a directory, provide a warning and confirm deletion
    }
    
    /**
     * Rename a file or directory
     * 
     * @param oldName The current name of the file or directory
     * @param newName The new name for the file or directory
     */
    private void rename(String oldName, String newName) {
        // TODO: Implement renaming a file or directory
    }
    
    /**
     * Search for files matching a pattern
     * 
     * @param pattern The pattern to search for
     */
    private void findFiles(String pattern) {
        // TODO: Implement searching for files by name pattern
        // Use recursive method to search through directories
    }
    
    /**
     * Display detailed information about a file
     * 
     * @param fileName The name of the file to display information for
     */
    private void displayFileInfo(String fileName) {
        // TODO: Implement displaying file information
        // Show file size, last modified date, whether it's a directory, etc.
    }
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        FileSystemManager manager = new FileSystemManager();
        manager.start();
    }
}
