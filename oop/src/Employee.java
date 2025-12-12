 // Employee class to demonstrate encapsulation
public class Employee implements Cloneable {
    String name;
    int age;
    double salary;

    // default constructor 
    public Employee() {
        this.name = "Unknown";
        this.age = 18;
        this.salary = 0.0;
    }

    // overloaded constructor that initializes all three variables
    public Employee(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    // public getter methods 
    public String getName() {
        return this.name;
    }

    public int getAge()  {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("cannot be null or empty. Setting to 'unknown'");
            this.name = "Unknown";
        } 
    }

    public void setAge(int age) {
        if (age < 18 || age > 65) {
            System.out.println("Error: age must be between 18 and 65. Setting to default (18)");
            this.age = 18;
        } else {
           this.age = age;
        }
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Error: salary cannot be negative. Setting to 0.");
            this.salary = 0;
        } else {
            this.salary = salary;
        }
    }
    
    public double calculateAnnualSalary() {
        return this.salary * 12;
    }


    public void giveRaise(double percentage) {
        if (percentage > 0) {
            double raiseAmount = this.salary * (percentage / 100);
	    this.salary += raiseAmount;
            System.out.println(this.name + " received a raise of " + percentage + "%");
        } else {
            System.out.println("Raise percentage must be positive");
        }
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Monthly salary: $" + String.format("%.2f", this.salary));
        System.out.println("-------------------------");
    }

    // Override the clone method to make Employee objects cloneable
    // Return super.clone() to create a shallow copy of the object
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
