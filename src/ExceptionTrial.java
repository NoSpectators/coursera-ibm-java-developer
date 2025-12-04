import java.util.Scanner;

public class ExceptionTrial {
    public static void main(String[] args) {
        
        // initialize variables for user input, array, and array index 
        Scanner scanner = new Scanner(System.in);
        String[] strArr = new String[5];
        int strIdx = 0;
        
	while (true) {
            System.out.println(
                "\nPress..." + 
                "\n1 to add String, " + 
                "\n2 to get String from a particular index, " + 
                "\n3 to get the length string in any index, " + 
                "\n4 to get all the strings in the array " + 
                "\nany other key to exit");
            
	    // read the user's choice
	    String userAction = scanner.nextLine();
           
	    // Option 1: add string to array
            if (userAction.equals("1")) {
                if (strIdx == 5) {
                    System.out.println("There are already 5 strings in the array!");
                } else {
                    // prompt the user to enter a string
                    System.out.println("Enter the String: ");
                    String inputStr = scanner.nextLine();
                    // Add the string to the array and increment the index
                    strArr[strIdx++] = inputStr;
                }
            }
	    // Option 2: retrieve a string from a particular index
            else if (userAction.equals("2")) {
                // Prompt the user to enter the index
                System.out.println("Enter the index you want to retrieve ");
                int retIdx = Integer.parseInt(scanner.nextLine());
                // Retrieve and print the string at the specified index
                System.out.println();        
		System.out.println(strArr[retIdx]);
            }
	    // Option 3: get the length of a string at a specific index
            else if (userAction.equals("3")) {
                // Prompt the user to enter the index
                int retIdx = Integer.parseInt(scanner.nextLine());
                // Retrive the string at specified index and print its length
                System.out.println(strArr[retIdx].length());
            }
        }
    } 
}
