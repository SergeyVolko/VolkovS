package ru.job4j.pseudo;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 09.02.2018
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++\n");
        pic.append("+  +\n");
        pic.append("+  +\n");
        pic.append("++++\n");
        return pic.toString();
    }
}
