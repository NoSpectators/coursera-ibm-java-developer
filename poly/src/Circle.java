// Circle class - a subclass of Shape
public class Circle extends Shape {
    private double radius;

    public Circle(String name, String color, double radius) {
        super(name, color); // call superclass constructor
        this.radius = radius;
    }

    public double getRadious() {
        return this.radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;        
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    // toString() method to include circle-specific information
    @Override
    public String toString() {
        return super.toString() + ", Shape type: Circle, Radius: " + this.radius;
    }
}
