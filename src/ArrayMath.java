public class ArrayMath {
    public static void main(String []args) {
	
        int[] arr = {30, 20, 100, 95, 1, -10, 8, 2000, 9, 878};
	System.out.println("arr.length = " + arr.length);
        
	// addition
        System.out.println("arr[0] - arr[1] = " + (arr[0] - arr[1]));

        // subtraction
        System.out.println("arr[2] - arr[3] = " + (arr[2] - arr[3]));

        // multiplication
        System.out.println("arr[4] * arr[5] = " + (arr[4] * arr[5]));

        // division
        System.out.println("arr[6] / arr[7] = " + (arr[6] / arr[7]));

        // modulus
        System.out.println("arr[8] % arr[9] = " + (arr[8] % arr[9]));
        
         
        for (int i = 0; i < arr.length-1; i++) {
            // ternary operator
            String greater = (arr[i] > arr[i+1]) ? "greater" : "not greater!";
	    System.out.println(arr[i] + " > " + arr[i+1] + " ?? " + greater);
        }
    }
} 
