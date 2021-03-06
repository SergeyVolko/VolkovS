package ru.job4j.search;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 29.03.2018
 */
public class User {
    private int id;
    private String name;
    private String city;
    private int age;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public User(int age, String name) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

}
