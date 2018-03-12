package ru.job4j.chess;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 12.03.2018
 */

public class ImposibleMoveException extends RuntimeException {
    public ImposibleMoveException(String msg) {
        super(msg);
    }
}
