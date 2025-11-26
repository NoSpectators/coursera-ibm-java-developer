public class DataTypes {
    public static void main(String []args) {
        // byte ranges from -128 to 127
        // use for handling file data in binary format
        byte b = 125;
        System.out.println("Byte value " + b);

        // short ranges from -32,768 to 32,767
        // suitable for memory-constrained environments where integers are too large
        // used for game scores, sensor readings, etc.
        short points = 3000;
        System.out.println("Points scored as 'short' value " + points);
        
	// int ranges from -2^31 to (2^31)-1
	// suitable for all general purpose use of numbers
	// suits values that are whole numbers
	int population = 4358000;
	System.out.println("Population as 'int' value " + population);

	// long ranges from -2^63 to (2^63)-1
	// used for large numeric values, timestamps in milliseconds
	// it has to end with l indicating it is a long integer
	long age_in_milliseconds = 788923800000l;
	System.out.println("Age of 25 years in milliseconds as 'long' value " + age_in_milliseconds);

	// char is used to store a character
	// suitable for capturing keyboard input one key at a time
	// used  mostly as a group of arrays for words
	char keyboard_input = 'a';
	System.out.println("Keyboard input is " + keyboard_input);

	// boolean is used for true or false
	// suitable for anything where the values can only be true or false
	boolean isLabCompleted = false;
	System.out.println("The lab is completed " + isLabCompleted);

	// float is used for numbers with decimals, with precision up to 7 decimal digits;
	// suitable for representing money, measurement of area, volume, etc
	// it has to end with f
	float house_value = 4000000.58f;
	System.out.println("The value of the house is " + house_value);

	// double is used for numbers with decimal, with precision up to 15 decimal digits
	// suitable for representing statistical, astronomical measurements
	double pi = 3.14159265359;
	System.out.println("The value of pi is " + pi);
    }
}





