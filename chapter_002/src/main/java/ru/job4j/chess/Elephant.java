package ru.job4j.chess;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 12.03.2018
 */

public class Elephant extends Figure {
    public Elephant(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int destX = dest.getX() - source.getX();
        int destY = dest.getY() - source.getY();
        if (Math.abs(destX) == Math.abs(destY)) {
            int signX = (destX > 0) ? (1) : (-1);
            int signY = (destY > 0) ? (1) : (-1);
            Cell[] massCell = new Cell[Math.abs(destX)];
            for (int i = 0; i < massCell.length; i++) {
                massCell[i] = new Cell(source.getX() + signX * (i + 1), source.getY() + signY * (i + 1));
            }
            return massCell;
        } else {
            throw new ImposibleMoveException("Wrong move");
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new Elephant(dest);
    }

}
