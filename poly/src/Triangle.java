// Triangle class - a subclass of Shape
public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;
    
    public Triangle(String name, String color, double side1, double side2, double side3) {
        super(name, color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1() {
        return this.side1;
    }
    public double getSide2() {
        return this.side2;
    }
    public double getSide3() {
        return this.side3;
    }
    @Override
    public double area() {
        double s = (this.side1 + this.side2 + this.side3) / 2.;
        return Math.sqrt(s*(s-this.side1)*(s-this.side2)*(s-this.side3));
    }
    @Override
    public double perimeter() {
        return this.side1 + this.side2 + this.side3;
    }
    @Override
    public String toString() {
        return super.toString() + ", Shape type: Triangle, Sides: " + side1 + ", " + side2 + ", " + side3;
    }
}
