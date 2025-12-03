// import Scanner to read user input
import java.util.Scanner;

public class AreaCalculator {
    private static float pi = 3.142f;
    
    // Add the methods to calculate area here
    private static float circle(float radius) {
        return pi * radius * radius;
    }

    private static float square(float length) {
        return length * length;
    }

    private static float rectangle(float length, float breadth) {
        return length * breadth;
    }


    public static void main() {
        System.out.println("Welcome to the area calculator!");
        while (true) {
        // Add the menu to get the user input and invoke method here
            System.out.println("\nEnter 1 for circle\n" +
			    "Enter 2 for square\n" + 
			    "Enter 3 for rectangle");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("Enter the radius of the circle");
                float radius = Float.parseFloat(scanner.nextLine());
                System.out.println("The area of circle with radius " + radius + " is " + circle(radius));
	    } else if (choice == 2) {
                System.out.println("Enter the length of the square");
                float length = Float.parseFloat(scanner.nextLine());
                System.out.println("The area of square with side length " + length + " is " + square(length));
            } else if (choice == 3) {
                System.out.println("Enter the length of the rectangle");
                float length = Float.parseFloat(scanner.nextLine());
                System.out.println("Enter the breadth of the rectangle");
                float breadth = Float.parseFloat(scanner.nextLine());
                System.out.println("The area of the rectangle with length " +
				length + " and breadth of " + 
				breadth + " is " + rectangle(length, breadth));
            } else {
                System.out.println("invalid choice");
                break;
            }
        }
    }
}
