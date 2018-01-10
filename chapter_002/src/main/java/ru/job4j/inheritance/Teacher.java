package ru.job4j.inheritance;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.01.2018
 */
public class Teacher extends Profession {
    public Teacher(int age, String name, String diploma) {
        super(age, name, diploma);
    }
    public String teach(Student student) {
        return (this.getName() + " учит студента по имени " + student.getName());
    }

}