import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimePrinter {
    public static void main(String[] args) {
        // prompt user to enter preferred date format
        LocalDate todayDate = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the format you would like to print the date in\n" + 
                           "dd for date, \n" + 
                           "M for month, MM for zero-padded month, MMM for abbreviated month, MMMM for full name, \n" + 
                           "yy or yyyy for year");
        String strDateFormat = scanner.nextLine();
        DateTimeFormatter newdateformat = DateTimeFormatter.ofPattern(strDateFormat);
        System.out.println("\nThe date is " + todayDate.format(newdateformat)); 
        
        // prompt user to enter the preferred time format
        LocalTime nowTime = LocalTime.now();
        System.out.println("\nEnter the format you would like to print the time in\n" + 
        "H for Hour of day (0-23), HH for Zero-padded hour of day (00-23), \n" + 
        "h for Hour of am/pm (1-12), hh for Zero-padded hour of am/pm (01-12) \n" + 
        "m for Minute of hour (0-59)\n" + 
        "mm for Zero-padded minute of hour (00-59)\n" + 
        "s for Second of minute (0-59), ss for Zero-padded second of minute (00-59)");
        String strTimeFormat = scanner.nextLine();
        DateTimeFormatter newtimeformat = DateTimeFormatter.ofPattern(strTimeFormat);
        System.out.println("The time is " + nowTime.format(newtimeformat));

        // prompt the user to enter the preferred date and time format
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("\n\nEnter the format you would like to print the date and time in\n");
        String strDateTimeFormat = scanner.nextLine();
        DateTimeFormatter newDateTimeformat = DateTimeFormatter.ofPattern(strDateTimeFormat);
        System.out.println("The date and time is " + nowDateTime.format(newDateTimeformat));

    }
}
