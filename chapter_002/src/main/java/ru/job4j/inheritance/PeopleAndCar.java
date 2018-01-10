package ru.job4j.inheritance;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.01.2018
 */
public class PeopleAndCar {
    private String name;
    private int age;

    public PeopleAndCar(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
