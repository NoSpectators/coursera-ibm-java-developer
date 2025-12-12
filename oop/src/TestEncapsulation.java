// TestEncapsulation class to test the Employee class
public class TestEncapsulation {
    public static void main(String[] args) {
        // default constructor 
        System.out.println("--------DEFAULT CONSTRUCTOR---------");
        Employee emp1 = new Employee();
        emp1.setName("John Smitherton");
        emp1.setAge(28);
        emp1.setSalary(5600.0);

        // parameterized constructor
	System.out.println("\n--------PARAMETERIZED CONSTRUCTOR---------"); 
        Employee emp2 = new Employee("Frank Jennings", 50, 7000.0);

        // Print details of both employees
        System.out.println("\n----------DETAILS--------");
        emp1.displayDetails();
        emp2.displayDetails();

        // Step 3: Try setting invalid values (null name, age outside range, negative salary)
        // and see if your validation works
        System.out.println("\n--------TESTING INVALID VALUES----------");
        emp1.setName("");
        emp1.setAge(5);
        emp1.setSalary(-1.00);
        System.out.println("\n--------RETURNING EMPLOYEE1 TO STARTING VALUES--------");
        emp1.setName("John Smitherton");
        emp1.setAge(28);
        emp1.setSalary(5600.);

        // Step 4: Give both employees a 10% raise and display their details again
        emp1.giveRaise(10);
        emp2.giveRaise(10);
        emp1.displayDetails();
        emp2.displayDetails();

        // Step 5: Clone the first employee and display the cloned employee details
        try {
            Employee emp3 = (Employee)emp1.clone(); 
            System.out.println("\n----------Cloned Employee Details:-----------");
            emp3.displayDetails();
            System.out.println("\n----------Modifying Original Employee Salary------");
            emp1.setSalary(6850.0);
            System.out.println("-----------Original Employee After Modification--------");
            emp1.displayDetails();
            System.out.println("-----------Cloned Employee After Original Was Modified---------");
        } catch(CloneNotSupportedException e) {
            System.out.println("Cloning not supported: " + e.getMessage()); 
        }
        // Step 7: Create a method that compares the salaries of two employees
        // and returns the name of the employee with the higher salary
        // If salaries are equal, return "Equal salaries"
        String result = compareSalaries(emp1, emp2);
        System.out.println("Salary comparison result: " + result);
    }
    public static String compareSalaries(Employee emp1, Employee emp2) {
        if (emp1.getSalary() > emp2.getSalary()) {
            return emp1.getName() + " has a higher salary";
        } else if (emp2.getSalary() > emp1.getSalary()) {
            return emp2.getName() + " has a higher salary";
        }
        return "Equal Salaries";
    } 
}
