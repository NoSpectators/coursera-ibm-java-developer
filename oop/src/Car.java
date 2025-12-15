public class Car {
    // note: nothing is static here. every car object instatiated
    // on the Car class might have differing values. 
    private String color; // color is private, so it can only be accessed within the Car class
    String model;
    private int year; // year is private, so it can only be accessed within the Car class

    // a static variable keeps track of the total number of Car objects created. 
    // this value is static, meaning it's shared with all instances of the Car class.
    // this can be thought of a "global variable" bound to the Car class.
    static int numberOfCars = 0;

    // default constructor
    public Car() {
        numberOfCars++; // increment this number each time Car is instantiated.
    }


    // private access modifier means this method is ONLY accessible within the class
    // this means this method is not accessable outside of the class
    // called below in displayInfo()
    private void displayCount() {
        System.out.println("Total Cars " + numberOfCars);
    }
    
    // since color is private, it needs a setter
    public void setColor(String color) {
        this.color = color;
    }

    // since year is private, it needs a setter
    public void setYear(int year) {
        this.year = year;
    }
    
    void displayInfo() {
        System.out.println("Car Model: " + model);
        System.out.println("Car Color: " + color);
        System.out.println("Car Year: " + year);
        this.displayCount();
        // this.displayColor();
    }
    // the private access modifier ensures this method can only be called 
    // within the Car class
    private void displayColor() {
        System.out.println("Car color: " + this.color);
    }
}
