package ru.job4j.chess;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 12.03.2018
 */

public class Lodiy extends Figure {
    public Lodiy(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int destX = dest.getX() - source.getX();
        int destY = dest.getY() - source.getY();
        if ((Math.abs(destX) > 0 && Math.abs(destY) == 0) || (Math.abs(destX) == 0 && Math.abs(destY) > 0)) {
            int signX = (destX > 0) ? (1) : ((destX == 0) ? (0) : (-1));
            int signY = (destY > 0) ? (1) : ((destY == 0) ? (0) : (-1));
            int max = (Math.abs(destX) > Math.abs(destY)) ? (destX) : (destY);
            Cell[] massCell = new Cell[max];
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
        return new Lodiy(dest);
    }
}