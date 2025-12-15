public class CarMenu {
    // entry point of the program 
    public static void main(String[] args) {
        // create an object of the Car class 
        Car myCar = new Car();
        myCar.color = "Red";
        myCar.model = "Toyota";
        myCar.year = 2020;
    
        // display car info by calling the displayInfo() method
        myCar.displayInfo();
    }
}
