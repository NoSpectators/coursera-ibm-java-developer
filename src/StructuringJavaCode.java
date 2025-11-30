public class StructuringJavaCode {
    public static void main(String []args) {
        System.out.println("Hello, world!");
        // This is a single-line comment
        int number = 10; // this variable stores the number 10
        /* this is a multi-line comment*/
        /* int sum = 0;
            this variable will hold the sum of numbers */
        /**
         * This is documentation comments used for generating documentation 
         * This method calculates the square of a number.
         * @param number The number to be squared
         * @return The square of the input number
         */
	public int square(int number) {
            return number * number;
        }
        
    }
}
