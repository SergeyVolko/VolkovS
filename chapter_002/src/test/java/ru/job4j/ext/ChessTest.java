package ru.job4j.ext;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 12.03.2018
 */

import org.junit.Test;
import ru.job4j.chess.*;

import static org.junit.Assert.assertArrayEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChessTest {
    @Test
    public void whenMovingElephantThenNewPosition() {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(5, 5);
        Figure figure = new Elephant(source);
        String sourcepos = String.format("Old position: (%s, %s)", figure.position.getX(), figure.position.getY());
        board.add(figure);
        board.moving(source, dest);
        figure = board.search(dest);
        String destpos = String.format("New position: (%s, %s)", figure.position.getX(), figure.position.getY());
        String result = String.format("%s %s", sourcepos, destpos);
        String expect = "Old position: (1, 1) New position: (5, 5)";
        assertThat(result, is(expect));
    }

    @Test
    public void whenMovingPeshkaThenNewPosition() {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(1, 2);
        Figure figure = new Peshka(source);
        String sourcepos = String.format("Old position: (%s, %s)", figure.position.getX(), figure.position.getY());
        board.add(figure);
        board.moving(source, dest);
        figure = board.search(dest);
        String destpos = String.format("New position: (%s, %s)", figure.position.getX(), figure.position.getY());
        String result = String.format("%s %s", sourcepos, destpos);
        String expect = "Old position: (1, 1) New position: (1, 2)";
        assertThat(result, is(expect));
    }

    @Test
    public void whenMovingLodiyThenNewPosition() {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(1, 5);
        Figure figure = new Lodiy(source);
        String sourcepos = String.format("Old position: (%s, %s)", figure.position.getX(), figure.position.getY());
        board.add(figure);
        board.moving(source, dest);
        figure = board.search(dest);
        String destpos = String.format("New position: (%s, %s)", figure.position.getX(), figure.position.getY());
        String result = String.format("%s %s", sourcepos, destpos);
        String expect = "Old position: (1, 1) New position: (1, 5)";
        assertThat(result, is(expect));
    }

    @Test
    public void whenMovingKonyThenNewPosition() {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(2, 3);
        Figure figure = new Kony(source);
        String sourcepos = String.format("Old position: (%s, %s)", figure.position.getX(), figure.position.getY());
        board.add(figure);
        board.moving(source, dest);
        figure = board.search(dest);
        String destpos = String.format("New position: (%s, %s)", figure.position.getX(), figure.position.getY());
        String result = String.format("%s %s", sourcepos, destpos);
        String expect = "Old position: (1, 1) New position: (2, 3)";
        assertThat(result, is(expect));
    }

    @Test
    public void whenMovingFerzThenNewPosition() {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(6, 1);
        Figure figure = new Ferz(source);
        String sourcepos = String.format("Old position: (%s, %s)", figure.position.getX(), figure.position.getY());
        board.add(figure);
        board.moving(source, dest);
        figure = board.search(dest);
        String destpos = String.format("New position: (%s, %s)", figure.position.getX(), figure.position.getY());
        String result = String.format("%s %s", sourcepos, destpos);
        String expect = "Old position: (1, 1) New position: (6, 1)";
        assertThat(result, is(expect));
    }

    @Test
    public void whenMovingKingThenNewPosition() {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(0, 0);
        Figure figure = new King(source);
        String sourcepos = String.format("Old position: (%s, %s)", figure.position.getX(), figure.position.getY());
        board.add(figure);
        board.moving(source, dest);
        figure = board.search(dest);
        String destpos = String.format("New position: (%s, %s)", figure.position.getX(), figure.position.getY());
        String result = String.format("%s %s", sourcepos, destpos);
        String expect = "Old position: (1, 1) New position: (0, 0)";
        assertThat(result, is(expect));
    }

    @Test
    public void whenMoveElephantThenException() {
        String[] exception = new String[3];
        String[] expect = {"ru.job4j.chess.FigureNotFoundException: No figure false", "ru.job4j.chess.ImposibleMoveException: Wrong move false", "ru.job4j.chess.OccupiedWayException: Occupie figure false"};
        int position = 0;
        boolean flag = false;
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(5, 5);
        Cell posotherfigure = new Cell(5, 5);
        board.add(new Elephant(source));
        board.add(new Peshka(posotherfigure));
        try {
            flag = board.move(new Cell(0, 0), dest);
        } catch (FigureNotFoundException e1) {
            exception[position++] = String.format("%s %s", e1, flag);
            try {
                flag = board.move(source, new Cell(2, 3));
            } catch (ImposibleMoveException e2) {
                exception[position++] = String.format("%s %s", e2, flag);
                try {
                    flag = board.move(source, posotherfigure);
                } catch (OccupiedWayException e3) {
                    exception[position++] = String.format("%s %s", e3, flag);
                }
            }
        }
        assertArrayEquals(expect, exception);
    }

    @Test
    public void whenMovePeshkaThenException() {
        String[] exception = new String[3];
        String[] expect = {"ru.job4j.chess.FigureNotFoundException: No figure false", "ru.job4j.chess.ImposibleMoveException: Wrong move false", "ru.job4j.chess.OccupiedWayException: Occupie figure false"};
        int position = 0;
        boolean flag = false;
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(5, 5);
        Cell posotherfigure = new Cell(1, 2);
        board.add(new Peshka(source));
        board.add(new Peshka(posotherfigure));
        try {
            flag = board.move(new Cell(0, 0), posotherfigure);
        } catch (FigureNotFoundException e1) {
            exception[position++] = String.format("%s %s", e1, flag);
            try {
                flag = board.move(source, dest);
            } catch (ImposibleMoveException e2) {
                exception[position++] = String.format("%s %s", e2, flag);
                try {
                    flag = board.move(source, posotherfigure);
                } catch (OccupiedWayException e3) {
                    exception[position++] = String.format("%s %s", e3, flag);
                }
            }
        }
        assertArrayEquals(expect, exception);
    }

    @Test
    public void whenMoveLodiyThenException() {
        String[] exception = new String[3];
        String[] expect = {"ru.job4j.chess.FigureNotFoundException: No figure false", "ru.job4j.chess.ImposibleMoveException: Wrong move false", "ru.job4j.chess.OccupiedWayException: Occupie figure false"};
        int position = 0;
        boolean flag = false;
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(5, 5);
        Cell posotherfigure = new Cell(1, 2);
        board.add(new Lodiy(source));
        board.add(new Peshka(posotherfigure));
        try {
            flag = board.move(new Cell(0, 0), new Cell(1, 5));
        } catch (FigureNotFoundException e1) {
            exception[position++] = String.format("%s %s", e1, flag);
            try {
                flag = board.move(source, dest);
            } catch (ImposibleMoveException e2) {
                exception[position++] = String.format("%s %s", e2, flag);
                try {
                    flag = board.move(source, new Cell(1, 5));
                } catch (OccupiedWayException e3) {
                    exception[position++] = String.format("%s %s", e3, flag);
                }
            }
        }
        assertArrayEquals(expect, exception);
    }

    @Test
    public void whenMoveKonyThenException() {
        String[] exception = new String[3];
        String[] expect = {"ru.job4j.chess.FigureNotFoundException: No figure false", "ru.job4j.chess.ImposibleMoveException: Wrong move false", "ru.job4j.chess.OccupiedWayException: Occupie figure false"};
        int position = 0;
        boolean flag = false;
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(5, 5);
        Cell posotherfigure = new Cell(2, 3);
        board.add(new Kony(source));
        board.add(new Peshka(posotherfigure));
        try {
            flag = board.move(new Cell(0, 0), posotherfigure);
        } catch (FigureNotFoundException e1) {
            exception[position++] = String.format("%s %s", e1, flag);
            try {
                flag = board.move(source, dest);
            } catch (ImposibleMoveException e2) {
                exception[position++] = String.format("%s %s", e2, flag);
                try {
                    flag = board.move(source, posotherfigure);
                } catch (OccupiedWayException e3) {
                    exception[position++] = String.format("%s %s", e3, flag);
                }
            }
        }
        assertArrayEquals(expect, exception);
    }

    @Test
    public void whenMoveFerzThenException() {
        String[] exception = new String[3];
        String[] expect = {"ru.job4j.chess.FigureNotFoundException: No figure false", "ru.job4j.chess.ImposibleMoveException: Wrong move false", "ru.job4j.chess.OccupiedWayException: Occupie figure false"};
        int position = 0;
        boolean flag = false;
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(2, 5);
        Cell posotherfigure = new Cell(5, 5);
        board.add(new Ferz(source));
        board.add(new Peshka(posotherfigure));
        try {
            flag = board.move(new Cell(0, 0), posotherfigure);
        } catch (FigureNotFoundException e1) {
            exception[position++] = String.format("%s %s", e1, flag);
            try {
                flag = board.move(source, dest);
            } catch (ImposibleMoveException e2) {
                exception[position++] = String.format("%s %s", e2, flag);
                try {
                    flag = board.move(source, posotherfigure);
                } catch (OccupiedWayException e3) {
                    exception[position++] = String.format("%s %s", e3, flag);
                }
            }
        }
        assertArrayEquals(expect, exception);
    }

    @Test
    public void whenMoveKingThenException() {
        String[] exception = new String[3];
        String[] expect = {"ru.job4j.chess.FigureNotFoundException: No figure false", "ru.job4j.chess.ImposibleMoveException: Wrong move false", "ru.job4j.chess.OccupiedWayException: Occupie figure false"};
        int position = 0;
        boolean flag = false;
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(2, 5);
        Cell posotherfigure = new Cell(2, 2);
        board.add(new King(source));
        board.add(new Peshka(posotherfigure));
        try {
            flag = board.move(new Cell(0, 0), posotherfigure);
        } catch (FigureNotFoundException e1) {
            exception[position++] = String.format("%s %s", e1, flag);
            try {
                flag = board.move(source, dest);
            } catch (ImposibleMoveException e2) {
                exception[position++] = String.format("%s %s", e2, flag);
                try {
                    flag = board.move(source, posotherfigure);
                } catch (OccupiedWayException e3) {
                    exception[position++] = String.format("%s %s", e3, flag);
                }
            }
        }
        assertArrayEquals(expect, exception);
    }
}