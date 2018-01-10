package ru.job4j.inheritance;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.01.2018
 */
public class Student extends PeopleAndCar {
    private String condition;
    public  Student(int age, String name, String condition) {
        super(age, name);
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
    public void methodCondition() {
        this.condition = "получил знания";
    }
    public  String knowledge(Teacher teacher) {
        this.methodCondition();
        return ("Студент " + this.getName() + " учился у учителя по имени " + teacher.getName() + " и " + this.condition);
    }
}
