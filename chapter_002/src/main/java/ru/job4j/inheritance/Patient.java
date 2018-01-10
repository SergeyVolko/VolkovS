package ru.job4j.inheritance;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.01.2018
 */
public class Patient extends PeopleAndCar {
    private String condition;
    public  Patient(int age, String name, String condition) {
        super(age, name);
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
    public void methodCondition() {
        this.condition = "вылечился";
    }

    public  String health(Doctor doctor) {
        this.methodCondition();
       return ("Пациент " + this.getName() + " лечился у доктора по имени " + doctor.getName() + " и " + this.condition);
    }

}
