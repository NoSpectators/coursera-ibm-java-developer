public class CarMenu {
    // entry point of the program 
    public static void main(String[] args) {
        // create an object of the Car class 
        Car myCar = new Car();
        // myCar.color = "Red"; // color is Private to it needs to be set using setColor("Red");
        myCar.setColor("Red");
        myCar.model = "Toyota";
        // myCar.year = 2020; // year is Private, so it needs to be set using setYear(2020)
        myCar.setYear(2020);
    
        // display car info by calling the displayInfo() method
        myCar.displayInfo();

	// so far, there should be only 1 Car created. 
        // create another car and note now there are 2 cars.
        Car myCar2 = new Car();
        myCar2.setColor("Blue");
        myCar2.model = "Nissan";
        myCar2.setYear(2000);
        
        myCar2.displayInfo();
       
        // this should not work
        // myCar2.displayColor(); // correct it doesn't work
    }
}
