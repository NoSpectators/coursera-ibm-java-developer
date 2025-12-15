// final means the class cannot be extended (inherited) 
// no subclasses can be created from Vehicle 
public final class Vehicle {
    // final non-access modifier makes these variables CONSTANTS 
    final int maxSpeed = 120;
    // in the case of a final method, it means displayMaxSpeed() 
    // cannot be overriden by subclasses, ensuring the behavior
    // remains the same in all instances of the class (objects)
    // if this was not final, then you could have @Override above it. 
    // however, technically this is redundant, since the entire class is final!!
    final void displayMaxSpeed() {
        System.out.println("Max Speed: " + maxSpeed); 
    }

}
