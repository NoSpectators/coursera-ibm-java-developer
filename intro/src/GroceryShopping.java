import java.util.Arrays; // to print array
import java.util.Scanner;

public class GroceryShopping {
    public static int searchItem(String[] items, String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                return i;
            }
        }
        return -1;
    }

    public static float calculateAveragePrice(float totalBill, int totalItems) {
        System.out.println(totalItems+ " items in cart.");
        if (totalItems > 0) {
            return totalBill / (float)totalItems;
        }
        return 0.0f;
    }

    public static void main(String[] args) throws ItemNotFoundException, InsufficientStockException{
        // declare variables
        String[] item = new String[10];
        float[] price = new float[10];
        int[] stock = new int[10];
        Scanner scanner = new Scanner(System.in);

        // Populate the arrays with some sample data
        item[0] = "milk"; price[0] = 5.0f; stock[0] = 5;
        item[1] = "cheese"; price[1] = 3.50f; stock[1] = 10;
        item[2] = "donuts"; price[2] = 6.0f; stock[2] = 8;
        item[3] = "toothpaste"; price[3] = 2.75f; stock[3] = 4;
        item[4] = "ground beef"; price[4] = 6.85f; stock[4] = 6;
        item[5] = "chicken stock"; price[5] = 1.25f; stock[5] = 3;
        item[6] = "tomatoes"; price[6] = 5.0f; stock[6] = 10;
        item[7] = "salad greens"; price[7] = 3.90f; stock[7] = 5;
        item[8] = "apples"; price[8] = 8.0f; stock[8] = 20;
        item[9] = "lunch meat"; price[9] = 5.0f; stock[9] = 10;

        // outer infinite loop for multiple users
        while (true) {
            // inner infinite loop for a single user's shopping
            int totalItems = 0;
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
                    // add quantity to the total items
                    // calculate cost for the item and add it to the total
                    System.out.println("Stock available for purchase: " + stock[itemIndex]);
                    System.out.println("Enter the quantity of the item: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    if (stock[itemIndex] < quantity) {
                        throw new InsufficientStockException("Insufficient stock. Please decrease quantity.");
                    }
                    // decrease stock
                    stock[itemIndex] -= quantity;


                    totalItems += quantity;
                    float itemCost = price[itemIndex] * quantity;
                    totalBill += itemCost;
                    System.out.println("Added " + quantity + " x " + item[itemIndex] + " to the bill. Current total: $" + totalBill);

                    // average price of current cart
                    float averagePrice = calculateAveragePrice(totalBill, totalItems);
                    System.out.println("average cost of items in cart: " + averagePrice);

                    float discountedTotal = 0.0f;
                    if (totalBill > 100.00) {
                        discountedTotal = totalBill - (totalBill * .10f);
                    }
                    System.out.println("discounted total: " + discountedTotal);


                } catch (ItemNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (InsufficientStockException e) {
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
        System.out.println("--------------------------------");
    }
}