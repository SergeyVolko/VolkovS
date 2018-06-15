package ru.job4j.map;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 15.06.2018
 */

public class Calendar {
    private int day;
    private int month;
    private int year;

    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Calendar{" + "day=" + day + ", month=" + month + ", year=" + year + '}';
    }
}
