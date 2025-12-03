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
    
    private static float volumeOfSphere(float radius) {
        return (4 * pi * radius * radius * radius) / 3;
    }

    private static float volumeOfCube(float length) {
        return length * length * length;
    }

    private static float volumeOfCuboid(float length, float breadth, float height) {
        return length * breadth * height;
    }
    
    public static void main() {
        System.out.println("Welcome to the area and volume calculator!");
        while (true) {
        // Add the menu to get the user input and invoke method here
            System.out.println("\nEnter 1 for area of a circle\n" +
			    "Enter 2 for area of a square\n" + 
			    "Enter 3 for area of a rectangle\n" +
			    "Enter 4 for volume of a sphere\n" + 
                            "Enter 5 for volume of a cube\n" + 
                            "Enter 6 for volume of a cuboid\n");
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
            } else if (choice == 4) {
                System.out.println("Enter the radius of the sphere");
                float radius = Float.parseFloat(scanner.nextLine());
                System.out.println("The volume of a sphere with radius " + radius + " is " + volumeOfSphere(radius));
            } else if (choice == 5) {
                System.out.println("Enter the length of any side of the cube");
                float length = Float.parseFloat(scanner.nextLine());
                System.out.println("The volume of a cube with side length " + length + " is " + volumeOfCube(length));
            } else if (choice == 6) {
                System.out.println("Enter the length of the cuboid");
                float length = Float.parseFloat(scanner.nextLine());
                System.out.println("Enter the breadth of the cuboid");
                float breadth = Float.parseFloat(scanner.nextLine());
                System.out.println("Enter the height of the cuboid");
                float height = Float.parseFloat(scanner.nextLine());
                System.out.println("The volume of a cuboid with length " + 
                                   length + " and breadth " + breadth + 
                                   " and height " + height + " is " + 
                                   volumeOfCuboid(length, breadth, height));
            } else {
                System.out.println("invalid choice");
                break;
            }
        }
    }
}
