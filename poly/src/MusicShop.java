// abstract class Instrument
// the public class will be called MusicShop, which is the same as the filename!
abstract class Instrument {
    // private and protected fields    
    private String name;
    protected int year; // year of manufacture
    // constructor  
    public Instrument(String name, int year) {
        this.name = name;
        this.year = year;
    }
    // abstract method (forces subclasses to implement their own play() method)
    public abstract String play();
    
    // concrete method (can be implemented as-is by subclasses)
    public String getInstrumentDetails() {
        return "Instrument: " + this.name + ", Year: " + this.year;
    }
    // concrete method
    public String getName() {
        return this.name;
    }
}

// interface Tunable
interface Tunable {
    // abstract methods - no implementation 
    String tune();
    String adjustPitch(boolean up); // up means increase pitch 
}

// Create an interface Maintainable
interface Maintainable {
    String clean();
    String inspect();
}

// concrete class StringedInstrument that extends Instrument
// - implementation of the abstract play() method
// - override getInstrumentDetails() to include number of strings
// can only have one public class per java file
class StringedInstrument extends Instrument {
    // additional field for instrument of this specific type 
    private int numberOfStrings;
    
    public StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year); // do NOT use "this.name" etc here. object doesn't exist yet.
        this.numberOfStrings = numberOfStrings;
    }
    @Override
    public String play() {
        return "Playing the stringed instrument";
    }
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + "Number of strings: " + this.numberOfStrings;
    }
}

// concrete class Guitar that extends StringedInstrument 
// - constructor that initializes all fields
// - implementation of all required interface methods
class Guitar extends StringedInstrument implements Tunable, Maintainable {
    private String guitarType; // acoustic, electric, etc 
   
    // parameters include all fields of class and higher classes
    public Guitar(String name, int year, int numberOfStrings, String guitarType) {
        super(name, year, numberOfStrings); // call parent constructor
        this.guitarType = guitarType;
    } 

    // Tunable interface methods
    @Override
    public String tune() {
        return "Tuning the " + this.guitarType + " guitar";
    }
    @Override 
    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch of the guitar" : "Decreasing pitch of the guitar";     
    }

    // Maintainable interface methods
    @Override
    public String clean() {
        return "Cleaning the " + this.guitarType + " guitar";      
    }
    @Override
    public String inspect() {
        return "Inspecting the " + this.guitarType + "guitar from " + this.year; 
    }
}

// Step 6: Create a concrete class Piano that extends Instrument
// and implements Tunable and Maintainable
// This should include:
// - private boolean isGrand
// - constructor that initializes all fields
// - implementation of the abstract play() method
// - implementation of all required interface methods


// Step 7: Create a public class MusicShop to test the classes
// This should include:
// - main method that:
//   1. Creates an array of Instrument objects including Guitar and Piano instances
//   2. Iterates through the array calling play() for each instrument
//   3. Demonstrates polymorphism by testing if each instrument is Tunable or Maintainable
//      and if so, calls the appropriate methods
