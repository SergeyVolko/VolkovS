package ru.job4j.chess;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 12.03.2018
 */

public class Peshka extends Figure {
    public Peshka(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int destX = dest.getX() - source.getX();
        int destY = dest.getY() - source.getY();
        if (destX == 0 && destY == 1) {
            Cell[] massCell = new Cell[destY];
            for (int i = 0; i < massCell.length; i++) {
                massCell[i] = new Cell(source.getX(), source.getY() + (i + 1));
            }
            return massCell;
        } else {
            throw new ImposibleMoveException("Wrong move");
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new Peshka(dest);
    }
}