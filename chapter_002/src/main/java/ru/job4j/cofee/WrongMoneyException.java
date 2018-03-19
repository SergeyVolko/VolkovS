package ru.job4j.cofee;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 20.03.2018
 */
public class WrongMoneyException extends RuntimeException {
    public WrongMoneyException(String msg) {
        super(msg);
    }
}
