// Rectangle class - a subclass of Shape
public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String name, String color, double length, double width) {
        super(name, color);
        this.length = length;
        this.width = width;
    } 
    public double getLength() {
        return this.length;
    }
    public double getWidth() {
        return this.width;
    }
    @Override
    public double area() {
        return this.length * this.width;
    }
    @Override
    public double perimeter() {
        return 2 * (this.length + this.width);
    }
    @Override
    public String toString() {
        return super.toString() + ", Shape type: Rectangle, Length: " + this.length + ", " + ", Width: " + this.width;
    }
}
