public class SampleEmployee {
    // Properties (attributes)
    private int employeeId;
    private String name;
    private String department;
    private String email;
    private int leaveBalance = 20; // annual leave balance in days

    // Constructor
    public SampleEmployee(int employeeId, String name, String department, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.email = email;
    }
    // methods added here
    public void setLeaveBalance(int leaveBalance) {
        if (leaveBalance >= 0) {
            this.leaveBalance = leaveBalance;
        } else {
            System.out.println("Leave balance cannot be negative.");
        }
    }
}
