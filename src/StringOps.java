public class StringOps {
    public static void main(String args[]) {
        String s1 = "Hello World";
        String s2 = new String("Hello World");
        String s3 = "Hello World";
        System.out.println("s1 and s2 comparison " + (s1 == s2)); // false 
        System.out.println("s2 and s3 comparison " + (s2 == s3)); // false // s2 is a String object
        System.out.println("s1 and s3 comparison " + (s1 == s3)); // true (because both are string literals) 

        String s4 = "The quick brown fox jumped over the lazy dog";
        System.out.println(s4.length());
        char[] strAsArr = s4.toCharArray();
        System.out.println(strAsArr);
        System.out.println("The first char of the string is " + strAsArr[0]);
        System.out.println("The last char of the string is " + strAsArr[strAsArr.length-1]);

        System.out.println("The index of T is " + s4.indexOf('T'));
        System.out.println("The index of g is " + s4.indexOf('g'));

        String s5 = "Washington";
        String s6 = new String("Washington");
        String s7 = "WASHINGTON";
        System.out.println("Equality check s5 and s6 - " + s5.equals(s6)); 
        System.out.println("Equality check s5 and s7 - " + s5.equals(s7));
        System.out.println("Equality check s5 and s7 ignoring case - " + s5.equalsIgnoreCase(s7));

        System.out.println("s5 in lowercase - " + s5.toLowerCase());
        System.out.println("s7 in lowercase - " + s7.toLowerCase());
        
        String s8 = "50F1A";
        System.out.println("s8 in lowercase - " + s8.toLowerCase());
        
        String regexStr = "^W.*";
        System.out.println("s5 matches regex ^W.* - " + s5.matches(regexStr));
        System.out.println("s7 matches regex ^W.* - " + s7.matches(regexStr));
        
        String s9 = "    WASHINGTON    ";
        System.out.println("Equality check s7 and s9 - " + s7.equals(s9));
        s9 = s9.strip();
        System.out.println("Equality check after stripping s9 - " + s7.equals(s9)); 

        String s10 = "Washington";
        String s11 = " DC";
        s10 = s10.concat(s11);
        System.out.println("s10 " + s10);
        s10 = s10.substring(0, 10);
        System.out.println("s10 " + s10);

        System.out.println("s10.substring(7, 10) " + s10.substring(7, 10));
        System.out.println("s10.substring(7) " + s10.substring(7));

        String s12 = "Maple Tree";
        String s13 = "Maple Tree";
        System.out.println("Equality check s12 and s13 - " + s12.equals(s13));
        System.out.println("Equality check s12 and s13 - " + (s12 == s13));
        
        String maple = s12.substring(0, 6); // includes space
        String tree = s12.substring(6);
        System.out.println("String maple = " + maple);
        System.out.println("String tree = " + tree);
        String concatted = maple.concat(tree);
        System.out.println("concatted = " + concatted);
        System.out.println("s12.toLowerCase() = " + s12.toLowerCase());
        System.out.println("s12.toUpperCase() = " + s12.toUpperCase());
    }
}
