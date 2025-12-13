// Student class to store and manage student information
public class Student {
    private String studentId;
    private String name;
    private double grade;
    private boolean isActive;

    // getters
    public String getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public double getGrade() {
        return this.grade;
    }

    public boolean getIsActive() {
        return this.isActive;
    }
   
    // setters
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
   
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        if (grade > 0 && grade <= 100)  {
            this.grade = grade;
        } else {
            System.out.println("Error: Grade must be between 0 and 100");
        }
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String displayStudentDetails() {
        return "ID: " + this.studentId + 
               "\nName: " + this.name + 
               "\nGrade: " + this.grade + 
               "\nIsActive: " + (this.isActive ? "Active" : "Inactive");
    }
    
    public String getLetterGrade() {
        double grade = this.grade;
        if (grade >= 90 && grade <= 100) {
            return "A";
        } else if (grade >= 80 && grade <= 89) {
            return "B";
        } else if (grade >= 70 && grade <= 79) {
            return "C";
        } else if (grade >= 60 && grade <= 69) {
            return "D";
        }
        return "F";
   
    }
    
    public boolean isPassing() {
        return this.grade >= 60;
    }
}
