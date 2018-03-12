package ru.job4j.chess;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 12.03.2018
 */

public class Ferz extends Figure {
    public Ferz(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        Cell[] massCell;
        int signX, signY;
        int destX = dest.getX() - source.getX();
        int destY = dest.getY() - source.getY();
        if (Math.abs(destX) == Math.abs(destY)) {
            signX = (destX >= 0) ? (1) : (-1);
            signY = (destY >= 0) ? (1) : (-1);
            massCell = new Cell[Math.abs(destX)];
            for (int i = 0; i < massCell.length; i++) {
                massCell[i] = new Cell(source.getX() + signX * (i + 1), source.getY() + signY * (i + 1));
            }
        } else {
            if ((Math.abs(destX) > 0 && Math.abs(destY) == 0) || (Math.abs(destX) == 0 && Math.abs(destY) > 0)) {
                signX = (destX > 0) ? (1) : ((destX == 0) ? (0) : (-1));
                signY = (destY > 0) ? (1) : ((destY == 0) ? (0) : (-1));
                int max = (Math.abs(destX) > Math.abs(destY)) ? (destX) : (destY);
                massCell = new Cell[max];
                for (int i = 0; i < massCell.length; i++) {
                    massCell[i] = new Cell(source.getX() + signX * (i + 1), source.getY() + signY * (i + 1));
                }
            } else {
                throw new ImposibleMoveException("Wrong move");
            }
        }
        return massCell;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Ferz(dest);
    }
}