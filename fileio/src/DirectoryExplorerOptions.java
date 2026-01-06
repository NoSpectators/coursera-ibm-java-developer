import java.io.File; // metadata: create, delete, rename, check existence of files and directories
import java.util.Scanner; // a text parser to get data from the keyboard, files, or strings (here its for user input)
import java.io.IOException;

public class DirectoryExplorerOptions {
    // rename or delete file 
    public static void fileManagement(File file, Scanner scanner) {
        System.out.println("\nPress 1 to rename the file," + 
                           "\nPress 2 to delete the file," + 
                           "\nAny other key to exit");
        String userChoice = scanner.nextLine();
        if (userChoice.equals("1")) {
            System.out.println("Enter the new name for the file " + file.getName());
            String newfileName = scanner.nextLine();
            boolean changed = file.renameTo(new File(file.getParent(), newfileName));
            if (changed) {
                System.out.println("Filename successfully changed!");
            } else {
                System.out.println("Filename couldn't be changed!");
            }
        } else if (userChoice.equals("2")) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("Filename successfully deleted");
            } else {
                System.out.println("Filename couldn't be deleted!");
            }
        }
    }
    // list, rename, or delete directory   
    public static void directoryManagement(File dirObj, Scanner scanner) {
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPress 1 for File Management," + "\nAny other key to exit");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                System.out.println("Enter the name of the file or directory with the path");
                String fileName = scanner.nextLine();
                File file = new File(fileName);
                // use case 1: file or directory already exists
                if (file.exists()) {
                    if (file.isFile()) {
                        System.out.println("\n" + fileName + " is a file");
                        fileManagement(file, scanner);
                    } else {
                        System.out.println("\n" + fileName + " is a directory");
                        directoryManagement(file, scanner);
                    }
                // use case 2: file or directory does not exist
                } else {
                    // if the file or directory does not exist, prompt user to create it
                    System.out.println("\n" + fileName + " is not a valid file or directory");
                    System.out.println("To create a file with given name press 1\n" +
                                       "To create a directory with a given name press 2\n" + 
                                       "To do nothing and continue, press any other key");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        // unless user types in absolute path, this might be a null pointer exception 
                        File absoluteFile = file.getAbsoluteFile();
                        String parentDirStr = absoluteFile.getParent();
                        File parentDir = new File(parentDirStr);
                        // create the parent directory if it does not exist
                        if (!parentDir.exists()) {
                            boolean created = parentDir.mkdirs();
                            if (!created) {
                                System.out.println("The parent directory could not be created");
                                continue;
                            }
                        }
                        // create the file
                        try {
                            file.createNewFile();
                            System.out.println("File successfully created!");
                        } catch (IOException e) {
                            System.out.println("Unable to create file. " + e.getMessage());
                        }
                    } else if (choice.equals("2")) {
                        // create the directory
                        boolean created = file.mkdirs();
                        if (created) {
                            System.out.println("The directory has been created");
                        } else {
                            System.out.println("The directory could not be created");	
                        }
                    }
                }
            } else {
                // exit the program
                System.out.println("Bye!");
                break;
            }
        }
        scanner.close();
    }
}
