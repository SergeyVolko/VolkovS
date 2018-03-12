package ru.job4j.chess;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 12.03.2018
 */

public class King extends Figure {
    public King(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int destX = dest.getX() - source.getX();
        int destY = dest.getY() - source.getY();
        if ((Math.abs(destX) + Math.abs(destY) > 0) && (Math.abs(destX) + Math.abs(destY) < 3)) {
            Cell[] massCell = {new Cell(dest.getX(), dest.getY())};
            return massCell;
        } else {
            throw new ImposibleMoveException("Wrong move");
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new King(dest);
    }

}
