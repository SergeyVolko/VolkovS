package ru.job4j.inheritance;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.01.2018
 */
public class Doctor extends Profession {
    public Doctor(int age, String name, String diploma) {
        super(age, name, diploma);
    }
    public String treats(Patient patient) {
        return ("Доктор " + this.getName() + " лечит пациента " + patient.getName());
    }
}
