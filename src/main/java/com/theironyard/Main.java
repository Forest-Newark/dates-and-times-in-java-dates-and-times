package com.theironyard;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

/**
 * For this exercise you will be creating a new class, SignificantDate, that can
 * be used to calculate the days until a given date (such as Valentine's Day,
 * New Years, Leap Year, etc). You should open the SignificantDate class and
 * follow the instructions there.
 *
 * Once you've completed the SignificantDate follow the instructions below to
 * use the SignificantDate class.
 */
public class Main {

    public static void main(String[] args) {

        /*
            In this main() method you should make use of your SignificantDate
            class. Use the next() method to find and print the next instance of
            and number of days to three dates:

            - One of the holiday constants defined in SignificantDate (not Leap Year)
            - Leap Year
            - Any other arbitrary date

            Here is some valid example output:

            There are 354 days until the next occurrence of Christmas on 12/25/2017
            There are 1150 days until the next occurrence of Leap Year on 2/29/2020
            There are 338 days until the next occurrence of my birthday on 12/9/2017

            Be sure to use the DateTimeFormatter class to format the date
            correctly. The date is in the form of month/day/year, without any
            leading zeros on the month or day. For example, February is 2, not
            02.

            https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html

            To create a DateTimeFormatter you must use the ofPattern() method to
            establish the pattern/format to create.

            https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ofPattern-java.lang.String-

            The syntax for defining patterns is documented here:

            https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns

            Once you have your DateTimeFormatter you can use the format() method
            to convert a LocalDate (or any other representation of time in the
            java.time package).

            https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#format-java.time.temporal.TemporalAccessor-

         */

        // todo: create a new DateTimeFormatter in a variable named formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/uuuu");

        // todo: print the number of days to and the date of the next occurrence of a constant date defined in SignificantDate (other than leap year). EG: Valentines Day
        String formattedChristmas = SignificantDate.next(SignificantDate.CHRISTMAS).format(formatter);
        System.out.println("There are " + SignificantDate.daysTo(SignificantDate.CHRISTMAS) + " days until the next occurrence of Christmas on " + formattedChristmas );

        // todo: print the number of days to and date of the next occurrence of leap year
        System.out.println("There are " + SignificantDate.daysTo(SignificantDate.LEAP_YEAR) + " days until the next occurrence of Leap Year on " + SignificantDate.next(SignificantDate.LEAP_YEAR).format(formatter));

        // todo: print the number of days to and date of any arbitrary MonthDate that is not defined as a constant in SignificantDate. EG: your birthday

        System.out.println("There are " + SignificantDate.daysTo(MonthDay.of(Month.AUGUST, 23)) + " days until the next occurrence of my Birthday on " + SignificantDate.next(MonthDay.of(Month.AUGUST, 23)).format(formatter));
    }

}
