import java.util.Scanner;


// Student class implementing Cloneable interface
class Student implements Cloneable {
    // Fields
    private String name;
    private int age;
    private String major;

    // Constructor
    public Student(String name, int age, String major) throws StudentInvalidNameException, StudentUnderAgeException {
        // check if name provided is valid
        if (!name.matches("^[a-zA-Z' -]+$")) {
            throw new StudentInvalidNameException("Invalid name provided");
        }
        this.name = name;
        // check if the provided age is less than 18
        if (age < 18) {
            throw new StudentUnderAgeException("Student age has to be 18 or more");
        }
        this.age = age;
        this.major = major;
    }
    // Getter and setter methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    // Override toString() method to provide a string representation of the object
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", major=" + major + "]";
    }
    // Override clone() method to support cloning
    @Override
    public Student clone() throws CloneNotSupportedException {
        // Call the clone() method of the Object class
        return (Student) super.clone();
    }
}

public class StudentManagement {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Create a student object
            // Student student1 = new Student("John Doe", 20, "Computer Science");
            System.out.println("Enter student name: ");
            String name = scanner.nextLine();
            System.out.println("Enter student age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter student major: ");
            String major = scanner.nextLine();
            // create the student object
            Student student1 = new Student(name, age, major);
	    // Clone the student object
            Student student2 = student1.clone();
            // Print the original and cloned objects
            System.out.println("Original Student: " + student1);
            System.out.println("Cloned Student: " + student2);
            // Modify the cloned object
            student2.setName("Jane Doe");
            student2.setAge(21);
            student2.setMajor("Mathematics");
            // Print the original and cloned objects after modification
            System.out.println("\nAfter modifying the cloned object");
            System.out.println("Original Student: " + student1);
            System.out.println("Cloned Student: " + student2);
        } catch(CloneNotSupportedException cnse) {
            System.out.println("You can't clone this object!");
        } catch(StudentUnderAgeException suae) {
            System.out.println(suae.getMessage());
        } catch(StudentInvalidNameException sine) {
            System.out.println(sine.getMessage());
        }
    }
}

