import java.time.ZonedDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateDiffCalculator {
    public static String getDiff(LocalDate d1, LocalDate d2) {
        Period period = d1.until(d2);
        String diffStr = "The difference is ";
        if (period.getYears() != 0) {
            diffStr = diffStr + period.getYears() + " years, ";
        } 
        if (period.getMonths() != 0) {
            diffStr = diffStr + period.getMonths() + " months, ";
        } 
        if (period.getDays() != 0) {
            diffStr = diffStr + period.getDays() + " day(s)";
        }
        return diffStr;
    }
    public static void displayLocalDateFormat(Scanner scanner) {
        System.out.println("Input the LocalDate format you want to feed the dates in:");
        String dateFormatStr = scanner.nextLine();
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern(dateFormatStr);
        try {
            System.out.println("Input the date in " + dateFormatStr + " format:");
            String rawDate1 = scanner.nextLine();
            LocalDate givenDate1 = LocalDate.parse(rawDate1, dateformat);

            System.out.println("Input another date in " + dateFormatStr + " format:");
            String rawDate2 = scanner.nextLine();
            LocalDate givenDate2 = LocalDate.parse(rawDate2, dateformat);

            System.out.println("\nThe given date is " + givenDate1.format(dateformat));
            System.out.println("\nThe other given date is " + givenDate2.format(dateformat));

            if (givenDate1.isEqual(givenDate2)) {
                System.out.println("Both dates are the same.");
            } else {
                // if the first date is before the second date
                if (givenDate1.isBefore(givenDate2)) {
                    System.out.println(getDiff(givenDate1, givenDate2));
                } else {
                    // if the first date is after the second date, calculate the difference
                    System.out.println(getDiff(givenDate2, givenDate1));
                }
            }

        } catch(DateTimeParseException dtpe) {
            System.out.println("Invalid input. Please try again.");
        }
    }
    public static void displayZonedDateTime(Scanner scanner) {
        System.out.println("Input the ZonedDateTime format you want to input the dates in " +
                "e.g., (dd MMM yy HH:mm:ss Z) :");
        String dateFormatStr = scanner.nextLine();
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern(dateFormatStr);

        try {
            System.out.println("Input the date in " + dateFormatStr + " format:");
            String rawDate1 = scanner.nextLine();
            ZonedDateTime givenDate1 = ZonedDateTime.parse(rawDate1, dateformat);

            System.out.println("Input another date in " + dateFormatStr + " format:");
            String rawDate2 = scanner.nextLine();
            ZonedDateTime givenDate2 = ZonedDateTime.parse(rawDate2, dateformat);

            System.out.println("\nThe given date is " + givenDate1.format(dateformat));
            System.out.println("\nThe other given date is " + givenDate2.format(dateformat));

            if (givenDate1.isEqual(givenDate2)) {
                System.out.println("Both dates are the same.");
            } else {
                System.out.println("The diff is " + ChronoUnit.DAYS.between(givenDate1, givenDate2)+" days(s)");
            }
        } catch(DateTimeParseException dtpe) {
            System.out.println("Invalid input. Please try again.");
        }
    }
    // entry point for the program 
    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        System.out.println("\n---------Welcome to the Time Zone Application-------");
        System.out.println("\nPress 1 for ZonedDateTime , " +
                           "\nPress 2 for LocalDate, " +
                           "\nAny other key to quit.");

        String userOption = scanner.nextLine();
        if (userOption.equals("1")) {
            displayZonedDateTime(scanner);
	    } else if (userOption.equals("2")) {
            System.out.println("Input the LocalDate format you want to feed the dates in (dd MMM yy):");

            displayLocalDateFormat(scanner);
        }
        scanner.close();
    }
}
