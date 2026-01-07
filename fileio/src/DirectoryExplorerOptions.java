import java.io.File; // metadata: create, delete, rename, check existence of files and directories
import java.util.Scanner; // a text parser to get data from the keyboard, files, or strings (here its for user input)
import java.io.IOException;

public class DirectoryExplorerOptions {

   private static void directoryList(File dirObj) {
        System.out.println("Printing " + dirObj + " recursively");
        File[] files = dirObj.listFiles();
        // guard for null object before listing 
        if (files == null) {
            System.out.println("Access denied or is not a directory: " + dirObj.getAbsolutePath());
            return;
        }
        // there are contents in array
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) { // base case: item in array is a file
                System.out.println(files[i].getAbsolutePath());
            } else {
                directoryList(files[i]); // recursive case: if item is a subdirectory, recursively list contents
            }
        }
    }

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
        System.out.println("\nPress 1 to list the directory," +
                           "\nPress 2 to rename the directory," +
                           "\nPress 3 to delete the directory," +
                           "\nPress 4 to recursively list the directory," + 
                           "\nAny other key to exit");
        String userChoice = scanner.nextLine();
        if (userChoice.equals("1")) {
            // list the directory contents
            String[] fileNames = dirObj.list();
            if (fileNames.length == 0) {
                System.out.println("The directory is empty!");
            } else {
                for (int i = 0; i < fileNames.length; i++) {
                    System.out.println(fileNames[i]);
                }
            }
        } else if (userChoice.equals("2")) {
            // rename the directory
            System.out.println("Enter the new name for the directory " + dirObj.getName());
            String newDirName = scanner.nextLine();
            boolean changed = dirObj.renameTo(new File(dirObj.getParent(), newDirName));
            if (changed) {
                System.out.println("Directory name successfully changed");
            } else {
                System.out.println("Directory name couldn't be changed!");
            }
        } else if (userChoice.equals("3")) {
            // delete the directory
            boolean deleted = dirObj.delete();
            if (deleted) {
                System.out.println("Directory successfully deleted");
            } else {
                System.out.println("Directory couldn't be deleted! It might not be empty");	    
            }
        } else if (userChoice.equals("4")) {
            directoryList(dirObj);
        }
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
