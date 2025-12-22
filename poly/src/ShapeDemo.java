import java.util.Scanner;

// ShapeDemo class to demonstrate polymorphism with Shapes
public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];         
        Scanner scanner = new Scanner(System.in);  
        int shapeCount = 0;
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Shape Management System =====");
            System.out.println("Press.." + 
                               "\n1 to add a circle, " + 
			       "\n2 to add a rectangle, " + 
			       "\n3 to add a triangle, " +
			       "\n4 to display all shapes, " + 
			       "\n5 to exit");
            System.out.print("Enter your choice (1-5) ");
            int userAction = 0; 
            try {
                userAction = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number."); 
            }
                   
            switch(userAction) {
                case 1: // Circle
                    if (shapeCount < shapes.length) {
                        System.out.println("Enter circle name: ");
                        String name = scanner.nextLine();
                       
                        System.out.println("Enter circle color: ");
                        String color = scanner.nextLine();
                       
                        System.out.println("Enter circle radius: ");
                        double radius = Double.parseDouble(scanner.nextLine());
                       
                        // create the circle and add to the Shape array
                        shapes[shapeCount] = new Circle(name, color, radius);
                        // display the added shape
                        System.out.println("\nCircle Details: ");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].area());
                        System.out.println("Perimeter: " + shapes[shapeCount].perimeter());
                        // increment shapecount
                        shapeCount++;
		    } else {
                        System.out.println("Cannot add more shapes. Array is full!");
		    }
                    break; // each case statement gets a break statement
                case 2: // Rectangle
                    if (shapeCount < shapes.length) {
                        System.out.println("Enter rectangle name: ");
                        String name = scanner.nextLine();
                        
			System.out.println("Enter rectangle color: ");
                        String color = scanner.nextLine();
                        
			System.out.println("Enter rectangle length: ");
                        double length = Double.parseDouble(scanner.nextLine());
                        
			System.out.println("Enter rectangle width: ");
                        double width = Double.parseDouble(scanner.nextLine());
                       
			// Create rectangle and add to shape array
                        shapes[shapeCount] = new Rectangle(name, color, length, width);
                        // display the added shape
                        System.out.println("\nRectangle Details: ");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].area());
                        System.out.println("Perimeter: " + shapes[shapeCount].perimeter());
                        // increment shapeCount 
                        shapeCount++;
		    } else {
                        System.out.println("Cannot add more shapes. Array is full!");
		    }
                    break;
                case 3: // Triangle
                    if (shapeCount < shapes.length) {
                        System.out.println("Enter triangle name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter triangle color:");
                        String color = scanner.nextLine();
                        System.out.println("Enter side1 length: ");
                        double side1 = Double.parseDouble(scanner.nextLine()); 
                        System.out.println("Enter side2 length: ");
                        double side2 = Double.parseDouble(scanner.nextLine()); 
                        System.out.println("Enter side3 length: ");
                        double side3 = Double.parseDouble(scanner.nextLine()); 
                        // Create Triangle and add shape to array
                        shapes[shapeCount] = new Triangle(name, color, side1, side2, side3);
                        // Display the added shape
                        System.out.println("\nTriangle Details: ");
                        System.out.println(shapes[shapeCount].toString());
                        System.out.println("Area: " + shapes[shapeCount].area());
                        System.out.println("Perimeter: " + shapes[shapeCount].perimeter());
                        // increment shapeCount
                        shapeCount++;
		    } else {
                        System.out.println("Cannot add more shapes. Array is full!");
		    }
                    break; 
                case 4: // display all shapes
                    if (shapeCount > 0) {
                        System.out.println("\n======All Shapes======");
                        for (int i = 0; i < shapeCount; i++) { // needs to iterate up to shapeCount (might be less than array max size)
                            System.out.println("\nShape " + (i + 1) + ":");
                            System.out.println(shapes[i].toString());
                            System.out.println("Area: " + shapes[i].area());
                            System.out.println("Perimeter: " + shapes[i].perimeter());
                            System.out.println("------------------------"); 
			}
		    } else {
                        System.out.println("No shapes to display. Please add some shapes first.");
		    }
                    break;
                case 5: // exit
                    exit = true;
                    System.out.println("Thank you for using the Shape Management System.");
                    break;
	    }
	}
        scanner.close(); // close the scanner
    }
}
