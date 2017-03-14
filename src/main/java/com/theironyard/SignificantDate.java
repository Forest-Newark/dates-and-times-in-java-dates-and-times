package com.theironyard;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

/**
 * This class provides a set of static properties and methods used to calculate
 * when holidays and other significant dates fall and how many days there are
 * until the next occurrence.
 *
 * As a part of this exercise you will have to make use of a number of classes
 * and enumerations in the java.time package.
 *
 * Follow the instructions below to create the class.
 */
public class SignificantDate {

    public static final MonthDay NEW_YEARS_DAY = MonthDay.of(Month.JANUARY,1);
    public static final MonthDay VALENTINES_DAY = MonthDay.of(Month.FEBRUARY,14);
    public static final MonthDay LEAP_YEAR = MonthDay.of(Month.FEBRUARY,29);
    public static final MonthDay FOURTH_OF_JULY = MonthDay.of(Month.JULY,4);
    public static final MonthDay CHRISTMAS = MonthDay.of(Month.DECEMBER,25);
    public static final MonthDay NEW_YEARS_EVE = MonthDay.of(Month.DECEMBER,31);
    public static final MonthDay MY_BIRTHDAY = MonthDay.of(Month.AUGUST,23);
    public static final MonthDay WIFE_BIRTHDAY = MonthDay.of(Month.JUNE,13);
    public static final MonthDay SON_BIRTHDAY = MonthDay.of(Month.NOVEMBER,30);


    /**
     * The next() method returns a LocalDate object that represents the date of
     * the next occurrence of the specified MonthDay. For example, if today were
     * 1/3/2017, the next instance of New Years Day would be 1/1/2018. The next
     * occurrence of leap year would be 2/29/2014.
     *
     * This method should be static.
     *
     * @param date A month and day we're looking for the next occurrence of
     * @return The next occurrence of the specified date
     */
    public static LocalDate next(MonthDay date) {
        LocalDate now = LocalDate.now();
        //Year year = Year.now();
        int year = now.getYear();


        // todo: loop while the MonthDate is not valid for the specified year or the MonthDate for this year is not after today
        while (!date.isValidYear(year) || !date.atYear(year).isAfter(now)){

            //year.plusYears(1);
            year++;

        }


        // todo: increment the year variable so we can try the subsequent year


        // once you've found the next instance of the date, return it!
        // todo: return the next occurrence of the specified date

        //return year.atMonthDay(date);
        return date.atYear(year);


    }
    /**
     * Create a static method name daysTo() that accepts a MonthDay argument
     * named date and returns a long representing the number of days to the next
     * occurrence of the MonthDay.
     *
     * For example, if today is January 3 2017, the next occurrence of New Years
     * Day is Jan 1 2018. This means that there are 362 days to New Years Day.
     *
     * @param date The date to get the number of days until
     * @return The number of days until the specified date
     */
    // todo: create the daysTo() method
    public static long daysTo(MonthDay date) {


        /*
            We already have a method named next() that will give us the next
            occurrence of a specified date. Use that method to get the next
            occurrence of the MonthDay. Store this in a variable named nextDate.
         */
        // todo: create nextDate variable and set it to the next instance of the date

        LocalDate nextDate = next(date);


        /*
            The java.time package has another enumeration (similar to Month)
            called java.time.temporal.ChronoUnit. The ChronoUnit enum has
            definitions for common time units. EG: days, weeks, hours, etc. One
            such example is java.time.temporal.ChronoUnit.DAYS. DAYS has a
            method called between() that returns the number of days between two
            LocalDates.

            https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoUnit.html#between-java.time.temporal.Temporal-java.time.temporal.Temporal-

            Here's an example usage of DAYS.between():

            java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), NEW_YEARS_EVE)

            DAYS.between() returns a long.
         */
        // todo: return the number of days between today and the nextDate

        return java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), nextDate);


    }

}
