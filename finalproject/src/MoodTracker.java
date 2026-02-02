import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class MoodTracker {

    public static boolean isMoodValid(Mood mood, List<Mood> moodsList) throws InvalidMoodException {
        for (Mood tempMood : moodsList) {
            if (tempMood.equals(mood)) { // check for duplicates
                throw new InvalidMoodException();
            }
        }
        return true;
    }
    // private: only accessible to MoodTracker class
    // static: method is bound to the class, not Mood objects
    private static Mood addMood(Scanner scanner) {
        System.out.println("Enter the mood name");
        String moodName = scanner.nextLine();
        System.out.println("Are you tracking the mood for a specific date/time? y/n");
        String isForCurrentDate = scanner.nextLine().trim().toLowerCase();

        Mood moodToAdd = null;
        if (isForCurrentDate.equals("y")) { // mood for a specific date/time
            try {
                System.out.println("Input the date in MM/dd/yyyy format:");
                String moodDateStr = scanner.nextLine();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // get date format
                LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter); // parse local date from dateFormatter

                System.out.println("Input the time in HH:mm:ss format:");
                String moodTimeStr = scanner.nextLine();
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // get time format
                LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter); // parse local time from timeFormatter

                System.out.println("Add notes about this mood");
                String moodNotes = scanner.nextLine().strip();
                // use one of two possible constructors to create a Mood
                if (moodNotes.strip().equalsIgnoreCase("")) {
                    moodToAdd = new Mood(moodName, moodDate, moodTime);
                } else {
                    moodToAdd = new Mood(moodName, moodDate, moodTime, moodNotes);
                }
            } catch (DateTimeParseException dtpe) {
                System.out.println("Incorrect format of date or time. Cannot create mood.\n" + dtpe.getMessage());
                return null; // failure to create a Mood
            }
        } else { // mood for today
            LocalDate dateToday = LocalDate.now();
            LocalTime timeToday = LocalTime.now();

            System.out.println("Add notes about this mood for today");
            String moodNotes = scanner.nextLine();
            if (moodNotes.strip().equalsIgnoreCase("")) {
                moodToAdd = new Mood(moodName, dateToday, timeToday);
            } else {
                moodToAdd = new Mood(moodName,  dateToday, timeToday, moodNotes);
            }
        }
        return moodToAdd;
    }
    public static void main(String[] args) {
        // General object creation patterns:
        // ReferenceType variableName = new ConcreteClass(constructorArgs);
        // InterfaceType variableName = new ConcreteClass();
        // ParentClass variableName = new SubClass();

        Scanner scanner = new Scanner(System.in); // Scanner object for user input
        List<Mood> moodsList = new ArrayList<>(); // Use List interface for flexibility
        boolean running = true;
        while (running) {
            System.out.println("\n=== Welcome to the Mood Tracker! ===\n" +
                               "Press 'a' to add mood\n" +
                               "'d' to delete mood(s)\n" +
                               "'e' to edit mood\n" +
                               "'s' to search for mood(s)\n" +
                               "'m' to get all moods\n" +
                               "'w' to write all moods to file\n" +
                               "'exit' to quit");
            String menuOption = scanner.nextLine().toLowerCase();
            switch (menuOption) {
                case "a":
                    Mood moodToAdd = addMood(scanner);
                    if (moodToAdd == null) {
                        continue; // skip invalid input
                    }
                    try {
                        boolean isValid = isMoodValid(moodToAdd, moodsList);
                        if (isValid) {
                            moodsList.add(moodToAdd);
                            System.out.println("The mood has been added to the tracker");
                            continue;
                        }
                    } catch (InvalidMoodException ime) {
                        System.out.println("The mood is not valid!");
                    }
                    break; // exit the 'a' case
                case "d":
                    continue;
                case "e":
                    continue;
                case "s":
                    continue;
                case "m":
                    continue;
                case "w":
                    continue;
                case "exit":
                    System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    running = false; // alert app to quit
                    break; // exit the switch statement
                default:
                    System.out.println("\n********Not a valid input!********\n");
                    continue;
            }
        }
        scanner.close(); // cleanup resources
    }
}