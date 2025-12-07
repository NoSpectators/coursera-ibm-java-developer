import java.util.Scanner;

public class GroceryShopping {
    public static int searchItem(String[] items, String item) {
        // int itemIndex = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                // itemIndex = i;
                return i;
            }
        }
        return -1;

//        if (itemIndex == -1) {
//            return "Item " + item + " not found. Please try again.";
//        }
    }
    public static void main(String[] args) throws ItemNotFoundException{
        // declare variables
        String[] item = new String[10];
        float[] price = new float[10];
        Scanner scanner = new Scanner(System.in);

        // Populate the arrays with some sample data
        item[0] = "milk"; price[0] = 5.0f;
        item[1] = "cheese"; price[1] = 3.50f;
        item[2] = "donuts"; price[2] = 6.0f;
        item[3] = "toothpaste"; price[3] = 2.75f;
        item[4] = "ground beef"; price[4] = 6.85f;
        item[5] = "chicken stock"; price[5] = 1.25f;
        item[6] = "tomatoes"; price[6] = 5.0f;
        item[7] = "salad greens"; price[7] = 3.90f;
        item[8] = "apples"; price[8] = 8.0f;
        item[9] = "lunch meat"; price[9] = 5.0f;

        // outer infinite loop for multiple users
        while (true) {
            // inner infinite loop for a single user's shopping
            float totalBill = 0.0f;
            while (true) {
                try {
                    // code for adding grocery items
                    System.out.println("Enter the name of the item (or type 'finish' to end shopping):");
                    String inputItem = scanner.nextLine();

                    // check if user wants to finish shopping
                    if (inputItem.equalsIgnoreCase("finish")) {
                        System.out.println("Your total bill is: $" + totalBill);
                        System.out.println("Thank you for shopping with us!");
                        break;
                    }

                    int itemIndex = searchItem(item, inputItem);
                    if (itemIndex == -1) {
                        throw new ItemNotFoundException("Item " + inputItem + " not found. Please try again.");
                    }

                    // ask for the quantity of the item
                    System.out.println("Enter the quantity of the item: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    // calculate cost for the item and add it to the total
                    float itemCost = price[itemIndex] * quantity;
                    totalBill += itemCost;

                    System.out.println("Added " + quantity + " x " + item[itemIndex] + " to the bill. Current total: $" + totalBill);
                } catch(ItemNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine(); // clear the invalid input
                }
            }
            String userInput = scanner.nextLine();
            // exit the program if the user types "exit"
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the shopping cart. Goodbye!");
                break;
            }
        }
        scanner.close();
    }
}