import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            // Create ArrayList to store Task objects (to-do list)
            ArrayList<Task> todoList = new ArrayList<Task>();
            while (true) {
                // Display menu options to the user
                System.out.println("Press " + 
                                   "\n1 to add a task " + 
                                   "\n2 to view all the tasks " + 
                                   "\n3 to change status of tasks " + 
                                   "\n4 to delete a task " + 
                                   "\n any other key to exit");
                // read user's choice
                String userAction = scanner.nextLine();
                // Option 1: add a task to the to-do list
                if (userAction.equals("1")) {
                    // prompt user to enter task 
                    System.out.println("Enter the task ");
                    String taskStr = scanner.nextLine();
                    // prompt user to enter task priority
                    System.out.println("Enter Priority - 1 Low, 2 Medium, 3 High ");
                    int priority = Integer.parseInt(scanner.nextLine());
                    // validate the priority (if priority > 3, make it 1. otherwise, keep it).
                    priority = priority > 3 ? 1: priority;
                    // create a new Task object
                    todoList.add(new Task(taskStr, priority));
                    System.out.println("The task has been added to the list.");
                } else if (userAction.equals("2")) { // view all the tasks
                    // user a for-each loop
                    todoList.forEach(task -> System.out.println(task));
                } else if (userAction.equals("3")) { // update a task
                    // Prompt user to enter index of the task to update
                    System.out.println("Enter the index of the status you want to change ");
                    int chgIdx = Integer.parseInt(scanner.nextLine());
                    // check if index is valid
                    if (chgIdx > (todoList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        // Prompt the user to enter the new status for the task
                        System.out.println("Enter the new status for the task P for 'In Progress' or C for 'completed'");
                        String updatedStatus = scanner.nextLine();
                        // Update the task status based on user input
                        if (updatedStatus.equalsIgnoreCase("P")) {
                            todoList.get(chgIdx).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            todoList.get(chgIdx).setStatus(Task.COMPLETED); 
                        }
                    }
                    System.out.println("The task has been changed in the list");
                } else if (userAction.equals("4")) { // Delete a task
                    // Prompt user to enter index of the task to delete 
                    System.out.println("Enter the index of the status you want to delete ");
                    int rmvIdx = Integer.parseInt(scanner.nextLine());
                    // check if index is valid
                    if (rmvIdx > todoList.size() - 1) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        todoList.remove(rmvIdx);
                        System.out.println("The task has been removed from the list");
                    }
               } else {
                    break; // exit program if user enters any other key
               }
	    } 
	} catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
	}
    }
}
