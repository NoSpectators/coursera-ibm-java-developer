import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryRecursiveList {
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPress 1 to recursively list a directory," + 
                               "\nAny other key to exit");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                System.out.println("Enter the full path to the directory");
                String dirName = scanner.nextLine();
                File dirObj = new File(dirName);
                if (dirObj.exists() && dirObj.isDirectory()) {
                    directoryList(dirObj);
                } else {
                    System.out.println(dirName + " is not a valid directory");
                    continue;
                }
            } else {
                System.out.println("Bye!");
                break;
            }
        }
    }
}
