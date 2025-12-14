// StudentRegistry class to test the Student class
public class StudentRegistry {
    public static void main(String[] args) {
        // Create two instances of the Student class
        Student student1 = new Student();
        Student student2 = new Student();

        // populate student's fields with data
        student1.setStudentId("S001");
        student1.setName("John Doe");
        student1.setGrade(85.5);
        student1.setIsActive(true);
        
        student2.setStudentId("S002");
        student2.setName("Jane Smith");
        student2.setGrade(92.0);
        student2.setIsActive(true);
        
        // display student details 
        String student1Details = student1.displayStudentDetails();        
        System.out.println(student1Details); 
       
        // find out who has the higher grade
        Student higherGradeStudent = compareGrades(student1, student2);
        System.out.println(higherGradeStudent.getName() + " has the higher grade with a grade of " +
			higherGradeStudent.getGrade());
       
        // Print out both letter grades 
        System.out.println(student1.getName() + " has a letter grade of " + student1.getLetterGrade());
        System.out.println(student2.getName() + " has a letter grade of " + student2.getLetterGrade());        

        // test the passing status method for both students
        System.out.println(student1.getName() + " is " + (student1.isPassing() ? "passing" : "not passing")); 
        System.out.println(student2.getName() + " is " + (student2.isPassing() ? "passing" : "not passing")); 
       
        // Step 8: Change one student to inactive and display the updated information
        System.out.println("before changing: " + student1.getName() + " is " + (student1.getIsActive() ? "active" : "not active"));
        student1.setIsActive(false);
        System.out.println(); 
	String st1details = student1.displayStudentDetails();
        System.out.println(st1details); // used to confirm the line below
        System.out.println(student1.getName() + " is " + (student1.getIsActive() ? "active" : "not active"));
    }
    public static Student compareGrades(Student student1, Student student2) {
        if (student1.getGrade() >= student2.getGrade()) {
            return student1;
        }
        return student2;
    }
}
