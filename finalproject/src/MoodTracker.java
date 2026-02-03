import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class MoodTracker {

    public static void searchMoodsByDate(LocalDate moodDate, List<Mood> moodsList) {
        boolean found = false;
        for (Mood tempMood : moodsList) {
            if (tempMood.getDate().equals(moodDate)) {
                found = true;
                System.out.println(tempMood);
            }
        }
        if (!found) {
            System.out.println("No matching moods found!");
        }
    }

    public static void searchMoods(String moodName, LocalDate moodDate, LocalTime moodTime, List<Mood> moodsList) {
        boolean found = false;
        for (Mood tempMood : moodsList) {
            if (tempMood.getName().equalsIgnoreCase(moodName)
                    && tempMood.getDate().equals(moodDate)
                    && tempMood.getTime().equals(moodTime)) {
                found = true;
                System.out.println(tempMood); // leave out break statement in case more than 1 match
            }
        }
        if (!found) {
            System.out.println("No matching moods found");
        }
    }

    public static boolean editMood(String moodName, LocalDate moodDate, LocalTime moodTime,
                                   String moodNotes, List<Mood> moodsList) {
        if (moodNotes == null || moodNotes.strip().isEmpty()) {
            System.out.println("No notes entered.");
            return false;
        }

        boolean moodEdited = false;
        for (Mood tempMood : moodsList) {
            if (tempMood.getName().equalsIgnoreCase(moodName)
                && tempMood.getDate().equals(moodDate)
                && tempMood.getTime().equals(moodTime)) {
                tempMood.setNotes(moodNotes);
                moodEdited = true;
                break; // stop after first match
            }
        }
        return moodEdited;
    }

    // Because Mood uses UUID-based identity, deletion must operate on existing Mood instances rather than newly constructed objects.
    public static boolean deleteMoodByDate(LocalDate moodDate, List<Mood> moodsList) {
        // optional lambda syntax
        //  return moodsList.removeIf(mood -> mood.getDate().equals(moodDate));

        // backwards iteration classic style syntax
        boolean removed = false;
        for (int i = moodsList.size() - 1; i >= 0; i--) {
            Mood mood = moodsList.get(i);
            if (mood.getDate().equals(moodDate)) {
                moodsList.remove(i);
                removed = true;
            }
        }
        return removed;
    }
    public static boolean deleteMood(String moodName, List<Mood> moodsList) {
        // optional lambda syntax
        // return moodsList.removeIf(mood -> mood.getName().equalsIgnoreCase(moodName)); // equals() is uuid-based so this works
        boolean removed = false;
        for (int i = moodsList.size() - 1; i >= 0; i--) {
            Mood mood = moodsList.get(i);
            if (mood.getName().equalsIgnoreCase(moodName)) {
                moodsList.remove(i);
                removed = true;
            }
        }
        return removed;
    }

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
                LocalDate moodDate = LocalDate.parse(scanner.nextLine(),
                        DateTimeFormatter.ofPattern("MM/dd/yyyy")); // parse local date from dateFormatter

                System.out.println("Input the time in HH:mm:ss format:");
                LocalTime moodTime = LocalTime.parse(scanner.nextLine(),
                        DateTimeFormatter.ofPattern("HH:mm:ss")); // parse local time from timeFormatter

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
                        continue;
                    }
                    break; // exit the 'a' case
                case "d":
                    System.out.println("Enter '1' to delete all moods by date\n"+
                                       "Enter '2' to delete a specific mood");
                    String deleteVariant = scanner.nextLine().toLowerCase();
                    if (deleteVariant.equals("1")) {
                        try {
                            System.out.println("Input the date in MM/dd/yyyy format");
                            LocalDate moodDate = LocalDate.parse(scanner.nextLine(),
                                    DateTimeFormatter.ofPattern("MM/dd/yyyy")); // parse date based on given pattern

                            boolean moodsDeleted = deleteMoodByDate(moodDate, moodsList);
                            if (moodsDeleted) {
                                System.out.println("The moods have been deleted");
                            } else {
                                System.out.println("No matching moods found");
                            }
                        } catch (DateTimeParseException dtpe) {
                            System.out.println("Incorrect format. Cannot delete mood.");
                            continue;
                        }
                    } else if (deleteVariant.equals("2")) {
                        try {
                            System.out.println("Enter the mood name");
                            String moodName = scanner.nextLine();
                            boolean moodDeleted = deleteMood(moodName, moodsList);
                            if (moodDeleted) {
                                System.out.println("The mood has been deleted");
                            } else {
                                System.out.println("No matching mood found.");
                            }
                        } catch (Exception e) {
                            System.out.println("unexpected error: " + e.getMessage());
                        }
                    }
                    break;
                case "e":
                    try {
                        System.out.println("Enter the mood name: ");
                        String moodName = scanner.nextLine();

                        System.out.println("Enter the date (MM/dd/yyyy)");
                        LocalDate moodDate = LocalDate.parse(scanner.nextLine(),
                                DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                        System.out.println("Enter the time (HH:mm:ss):");
                        LocalTime moodTime = LocalTime.parse(scanner.nextLine(),
                                DateTimeFormatter.ofPattern("HH:mm:ss"));

                        System.out.println("Add new notes about this mood");
                        String moodNotes = scanner.nextLine();

                        boolean moodEdited = editMood(moodName, moodDate, moodTime, moodNotes, moodsList);
                        if (moodEdited) {
                            System.out.println("The mood has been edited");
                        } else {
                            System.out.println("No matching mood found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error editing mood: " + e.getMessage());
                        continue;
                    }
                    break;
                case "s":
                    System.out.println("Enter '1' to search all moods by date\n" +
                                       "Enter '2' to search for a specific mood");
                    String searchVariant = scanner.nextLine();
                    if (searchVariant.equals("1")) {
                        try {
                            System.out.println("Input the date in MM/dd/yyy format:");
                            LocalDate moodDate = LocalDate.parse(scanner.nextLine(),
                                    DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                            searchMoodsByDate(moodDate, moodsList);
                        } catch (DateTimeParseException dtpe) {
                            System.out.println("Incorrect format for date. Cannot search mood.");
                            continue;
                        }
                    } else if (searchVariant.equals("2")) {
                        try {
                            System.out.println("Enter the mood name");
                            String moodName = scanner.nextLine();

                            System.out.println("Input the date in MM/dd/yyy format:");
                            LocalDate moodDate = LocalDate.parse(scanner.nextLine(),
                                    DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                            System.out.println("Input the time in HH:mm:ss format:");
                            LocalTime moodTime = LocalTime.parse(scanner.nextLine(),
                                    DateTimeFormatter.ofPattern("HH:mm:ss"));

                            searchMoods(moodName, moodDate, moodTime, moodsList);
                        } catch (DateTimeParseException dtpe) {
                            System.out.println("Incorrect format for date or time. Cannot search mood.");
                            continue;
                        }
                    }
                    break;
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