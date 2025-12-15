public class Car {
    // note: nothing is static here. every car object instatiated
    // on the Car class might have differing values. 
    String color;
    String model;
    int year;

    void displayInfo() {
        System.out.println("Car Model: " + model);
        System.out.println("Car Color: " + color);
        System.out.println("Car Year: " + year);
    }
}
