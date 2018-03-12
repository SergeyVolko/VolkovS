package ru.job4j.chess;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 12.03.2018
 */

public abstract class Figure {
    public final Cell position;

    protected Figure(Cell position) {
        this.position = position;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    public abstract Figure copy(Cell dest);
}
