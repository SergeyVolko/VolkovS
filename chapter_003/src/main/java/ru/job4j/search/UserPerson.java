package ru.job4j.search;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.03.2018
 */
public class UserPerson implements Comparable<UserPerson> {
    private int age;
    private String name;

    public UserPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserPerson(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserPerson{" + "age=" + age + ", name='" + name + '\'' + '}';
    }

    @Override
    public int compareTo(UserPerson o) {
        return (this.getAge() > o.getAge()) ? (1) : ((this.getAge() - o.getAge() == 0) ? (0) : (-1));
    }
}