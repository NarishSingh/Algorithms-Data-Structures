package main.hackerrank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dayOfTheProgrammer {

    /**
     * Find the 256th day of the year in russia between 1700 - 2700
     * Note: Anything after 1917 - use the gregorian calendar, not the julian calender
     * Leap year = Julian -> every 4, Gregorian -> divisble by 400 or /4 but not /100
     *
     * @param year int for the year
     * @return output the date as a string in MM/DD/YYYY format
     */
    public static String dayOfProgrammer(int year) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(year + "-01-01");

        if (year == 1918) {
            //after 1/31 became 2/14 ->
            date = LocalDate.parse(year + "-02-14"); //set to 32nd day for convenience
            date = date.plusDays(255 - 32); //add 255-32
        } else if (year > 1917) {
            //gregorian = follows the ISO used by java's LocalDate
            date = date.plusDays(255);
        } else {
            //julian = does not follow the ISO
            if (year % 4 == 0) {
                date = date.plusDays(254);
            } else {
                date = date.plusDays(255);
            }
        }

        return date.format(format);
    }

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1918));
        System.out.println(dayOfProgrammer(1984));
        System.out.println(dayOfProgrammer(2017));
        System.out.println(dayOfProgrammer(2016));
        System.out.println(dayOfProgrammer(1800));
        System.out.println(dayOfProgrammer(1916)); // FIXME: 5/24/2021 I don't get why this test is failing
    }
}
