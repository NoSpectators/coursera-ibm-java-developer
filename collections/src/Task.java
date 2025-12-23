public class Task {
    // "public static" means a global property that is a class property (not instance)
    // if it weren't static, it would be an instance property (created upon each instantiation).
    // typically these static variables are values that all instances can use repeatedly.
    // global class values (accessible) 
    public static int HIGH = 3;
    public static int MEDIUM = 2;
    public static int LOW = 1;

    public static String COMPLETED = "Completed";
    public static String IN_PROGRESS = "In Progress";
    public static String NEW = "New";

    // encapsulated class variables
    private String taskName;
    private int priority = LOW;
    private String status = NEW;

    // constructors
    public Task(String taskName) {
        this.taskName = taskName; 
    }

    public Task(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    // setters for private fields
    public void setPriority(int priority) {
        this.priority = priority; 
    }
   
    public void setStatus(String status) {
        this.status = status;
    }

    // getters for private fields
    public int getPriority() {
        return this.priority;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return this.taskName.concat(" ").concat((priority+"")).concat(" ").concat(status);
    }
}
