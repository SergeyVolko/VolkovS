package ru.job4j.inheritance;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.01.2018
 */
public class Profession extends PeopleAndCar {
    private  String diploma;


    public Profession(int age, String name, String diploma) {
        super(age, name);
        this.diploma = diploma;

    }
    public String getDiploma() {
        return diploma;
    }
}
