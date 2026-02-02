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
            if (tempMood.equals(mood)) {
                throw new InvalidMoodException();
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // General object creation patterns:
        // ReferenceType variableName = new ConcreteClass(constructorArgs);
        // InterfaceType variableName = new ConcreteClass();
        // ParentClass variableName = new SubClass();

        Scanner scanner = new Scanner(System.in); // Scanner object for user input
        List<Mood> moodList = new ArrayList<>(); // Use List interface for flexibility
        boolean running = true;
        while (running) {
            System.out.println("=== Welcome to the Mood Tracker! ===\n" +
                               "Press 'a' to add mood\n" +
                               "'d' to delete mood(s)\n" +
                               "'e' to edit mood\n" +
                               "'s' to search for mood(s)\n" +
                               "'M' to get all moods\n" +
                               "'w' to write all moods to file\n" +
                               "'Exit' to quit");
            String menuOption = scanner.nextLine();
            switch (menuOption) {
                case "a":
                    System.out.println("Enter the mood name");
                    String moodName = scanner.nextLine();
                    System.out.println("Are you tracking the mood for a current day? y/n");
                    String isForCurrentDate = scanner.nextLine();
                    Mood moodToAdd = null;
                    if (isForCurrentDate.equalsIgnoreCase("n")) { // mood for a specific date/time
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
                            String moodNotes = scanner.nextLine();
                            // use one of two possible constructors to create a Mood
                            if (moodNotes.strip().equalsIgnoreCase("")) {
                                moodToAdd = new Mood(moodName, moodDate, moodTime);
                            } else {
                                moodToAdd = new Mood(moodName, moodDate, moodTime, moodNotes);
                            }
                        } catch (DateTimeParseException dtpe) {
                            System.out.println("Incorrect format of date or time. Cannot create mood.\n" + dtpe.getMessage());
                            continue;
                        }
                    } else { // mood not attached to a date/time
                        System.out.println("Add notes about this mood");
                        String moodNotes = scanner.nextLine();
                        if (moodNotes.strip().equalsIgnoreCase("")) {
                            moodToAdd = new Mood(moodName);
                        } else {
                            moodToAdd = new Mood(moodName,  moodNotes);
                        }
                    }
                case "d":
                    continue;
                case "e":
                    continue;
                case "s":
                    continue;
                case "M":
                    continue;
                case "w":
                    continue;
                case "Exit":
                    System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    running = false; // alert app to quit
                    break; // exit the switch statement
                default:
                    System.out.println("\n********Not a valid input!********\n");
                    continue;
            }
        }
    }
}