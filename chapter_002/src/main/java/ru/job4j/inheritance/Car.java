package ru.job4j.inheritance;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.01.2018
 */
public class Car extends PeopleAndCar {
    private String condition;
    public  Car(int age, String name, String condition) {
        super(age, name);
        this.condition = condition;
    }
    public String getCondition() {
        return condition;
    }
    public void methodCondition() {
        this.condition = "она исправна";
    }
    public  String recovery(Engineer engineer) {
        this.methodCondition();
        return ("Машина марки " + this.getName() + " ремонтировалась у инженера по имени " + engineer.getName() + " и теперь " + this.condition);
    }

}
