import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookHashMap {
    
    // Method to validate if the name contains only letters, spaces, hyphens, or apostrophes
    // "private" means this method can only be called from inside the class 
    // "static" means it's bound to the class, so it can be called without creating an instance of the class 
    // Note: static methods have less access than non-static (regular) methods. they can't access non-static properties.
    private static boolean isNameValid(String name) {
        if (name.matches("^[a-zA-Z' -]+$") == false) {
            System.out.println("Invalid name!");
            return false;
        }
        return true;
    }

    // Method to validate if the phone number matches a specific format
    public static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}") == false) {
            System.out.println("Invalid phone number!");
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);
            // create a HashMap to store names (keys) and phone numbers (values)
            HashMap<String, String> phonebook = new HashMap<>();
            while (true) {
                // Display the menu options to the user
                System.out.println("\nPress 1 add an entry in the phonebook," + 
                                   "\n2 to view all the entries" + 
                                   "\n3 to search for entries by name" + 
                                   "\n4 to delete an entry" + 
                                   "\nAny other key to exit");
                // Read the user's choice (we use String. won't crash on letters as input.)
                String userAction = scanner.nextLine();
                if (userAction.equals("1")) {
                    // Prompt user to enter name
                    System.out.print("Enter a name: ");
                    String name = scanner.nextLine();
                    // validate name
                    if (!isNameValid(name)) {
                       continue; // skip to next iteration  
                    }
                    if (phonebook.containsKey(name)) {
                        System.out.println("This name already exists! Do you want to replace the phone number? y/n");
                        String repChoice = scanner.nextLine();
                        if (repChoice.equalsIgnoreCase("n")) {
                            continue; 
                        }
                    }
                    // prompt user to enter number
                    System.out.println("Enter the phone number");
                    String phoneNumber = scanner.nextLine();
                    // validate the number format
                    if (!isPhoneNumberValid(phoneNumber)) {
                        continue;
                    } 
                    phonebook.put(name, phoneNumber); // add name and number to phoneBook
                    System.out.println("The name and number have been added to the phonebook.");
                } else if (userAction.equals("2")) { // view all entries
                    for (String name : phonebook.keySet()) {
                        System.out.println(name + ": " + phonebook.get(name));
                    }
                } else if (userAction.equals("3")) { // search for specific entry
                    System.out.println("Enter name you want to search: ");
                    String keyName = scanner.nextLine();
                    if (phonebook.containsKey(keyName)) {
                        System.out.println("The phone number you are looking for is " + 
                                            phonebook.get(keyName));
                    } else {
                        System.out.println("Name not found.");
                    }
                } else if (userAction.equals("4")) { // delete an entry
                    System.out.println("Enter name you want to delete: ");
                    String keyName = scanner.nextLine();
                    if (phonebook.containsKey(keyName)) {
                        phonebook.remove(keyName);
                    } else {
                        System.out.println("Name not found.");
                    }
                } else {
                    System.out.println("Goodbye!");
                    break;
                }
   	    }

	} catch(NumberFormatException nfe) {
            // handle invalid number input (for example, non-integer input for priority or index)
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
