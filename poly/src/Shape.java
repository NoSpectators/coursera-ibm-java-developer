// Shape class - the superclass
public class Shape {
    private String name;
    private String color;
    
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }
    
    public double area() {
        return 0.0; // overridden by subclasses; 0.0 is default
    }

    public double perimeter() {
        return 0.0; // overridden by subclasses; 0.0 is default
    }

    // toString() is a member of the Object class (already has a toString() builtin)
    @Override
    public String toString() {
        return "Shape Name: " + this.name + ", Color: " + this.color;
    }
}
