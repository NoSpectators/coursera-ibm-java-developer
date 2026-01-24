import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class ZonalDateTimeOperation {
    // entry point for the program 
    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println("\nDefault format: " + dateTime);

        while (true) {
            System.out.println("\n---------Welcome to the Zonal Date Time Operation System-------");
            System.out.println("\nPress 1 to find the difference between two dates," +
                               "\nPress 2 for adding to or deleting from the current date," +
                               "\nAny other key to exit.");
            String userAction = scanner.nextLine();
            if (userAction.equals("1") || userAction.equals("2")) {
                // prompt user for the date format
                System.out.println("Enter the format in which you want to feed the date time along with zone" +
                        "(e.g., dd MM yyyy HH:mm:ss XXX");
                String dateFormatStr = scanner.nextLine();

                // Create a DateTimeFormatter with specified format
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateFormatStr.strip());

                // prompt user to enter first date (NOTE: this is the date needed for both options below)
                System.out.println("Input the date in " + dateFormatStr + " format:");
                String rawDate1 = scanner.nextLine();

                try {
                    // parse the first date (the basis for the options below) as ZonedDateTime
                    ZonedDateTime localDateTime1 = ZonedDateTime.parse(rawDate1, dateFormat);

                    if (userAction.equals("1")) {
                        // prompt user for the second date
                        System.out.println("Input the other date in " + dateFormatStr + " format:");
                        String rawDate2 = scanner.nextLine();

                        // parse the second date as ZonedDateTime
                        ZonedDateTime localDateTime2 = ZonedDateTime.parse(rawDate2, dateFormat);

                        // print the parsed dates
                        System.out.println("\nThe given date is " + localDateTime1.format(dateFormat));
                        System.out.println("\nThe other given date is " + localDateTime1.format(dateFormat));

                        // check if the dates are equal
                        if (localDateTime1.isEqual(localDateTime2)) {
                            System.out.println("both dates are the same");
                        } else  {
                            // calculate the difference in days
                            long diffInDays = ChronoUnit.DAYS.between(localDateTime1, localDateTime2);
                            System.out.println("The difference is " + diffInDays + " day(s)");
                        }
                    } else if (userAction.equals("2")) {
                        // prompt user to select a unit of time to modify
                        System.out.println("Enter which unit of time you want to add/delete:\n" +
                                "d - days, M - months, y - years, w - weeks");
                        String unitToChange = scanner.nextLine();
                        // prompt user to enter the quantity of the selected unit
                        System.out.println("Enter the quantity to change (e.g., 3):");
                        long qtyToChange = Long.parseLong(scanner.nextLine());

                        // prompt user to choose whether to add or delete the selected quantity
                        System.out.println("\nPress 'a' to add, 'd' to delete, +
                                "\nAny other key to back to the main menu");
                    }

                }
            }
        }
        scanner.close();
    }
}
