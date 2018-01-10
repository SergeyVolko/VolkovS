package ru.job4j.inheritance;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.01.2018
 */
public class Engineer extends Profession {
    public Engineer(int age, String name, String diploma) {
        super(age, name, diploma);
    }
    public String repair(Car car) {
        return (this.getName() + " чинит машину марки " + car.getName());
    }
}
