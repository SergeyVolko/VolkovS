package ru.job4j.start;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 03.03.2018
 */
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}