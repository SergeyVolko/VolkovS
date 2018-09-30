package ru.job4j.chess;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 12.03.2018
 */

public class Board {
    int positionFigure = 0;
    public Figure[] figures = new Figure[32];
    public Cell[][] cells = new Cell[8][8];

    private Consumer<Figure> consumerFigure = (figure -> {
        int posX = figure.position.getX();
        int posY = figure.position.getY();
        cells[posX][posY] = new Cell(posX, posY);
        this.figures[positionFigure++] = figure;
    });

    private Function<Cell, Figure> cellFigureFunction = (source -> {
        Figure figure = null;
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i] != null && this.figures[i].position.getX() == source.getX() && this.figures[i].position.getY() == source.getY()) {
                figure = this.figures[i];
                break;
            }
        }
        return figure;
    });

    private Function<Cell[], Boolean> booleanFunction = (massCell -> {
        boolean flag = true;
        for (int i = 0; i < massCell.length; i++) {
            if (this.cells[massCell[i].getX()][massCell[i].getY()] != null) {
                flag = false;
                break;
            }
        }
        return flag;
    });

    Consumer<Cell> consumerDelete = (source -> {
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i] != null && this.figures[i].position.getX() == source.getX() && this.figures[i].position.getY() == source.getY()) {
                this.cells[this.figures[i].position.getX()][this.figures[i].position.getY()] = null;
                for (int j = i; j < positionFigure; j++) {
                    this.figures[j] = this.figures[j + 1];
                    this.figures[j + 1] = null;
                }
                positionFigure--;
                break;
            }
        }
    });

    BiFunction<Cell, Cell, Boolean> moveBiFunction = ((source, dest) -> {
        Figure figure;
        boolean flag = false;
        Cell[] massCell;
        if (cells[source.getX()][source.getY()] != null) {
            figure = this.search(source);
            if (figure != null) {
                massCell = figure.way(source, dest);
                if (searchCell(massCell)) {
                    flag = true;
                } else {
                    throw new OccupiedWayException("Occupie figure");
                }
            }
            return flag;
        } else {
            throw new FigureNotFoundException("No figure");
        }
    });

    BiConsumer<Cell, Cell> movingBiConsumer = ((source, dest) -> {
        Figure figure = null;
        try {
            if (this.move(source, dest)) {
                figure = this.search(source);
                this.figures[positionFigure++] = figure.copy(dest);
                cells[dest.getX()][dest.getY()] = new Cell(dest.getX(), dest.getY());
                deleteFigure(source);
            }
        } catch (FigureNotFoundException e) {
            System.out.println(e);
        } catch (ImposibleMoveException e) {
            System.out.println(e);
        } catch (OccupiedWayException e) {
            System.out.println(e);
        }
    });

    public void add(Figure figure) {
        this.consumerFigure.accept(figure);
    }

    public Figure search(Cell source) {
        return this.cellFigureFunction.apply(source);
    }

    public boolean searchCell(Cell[] massCell) {
        return booleanFunction.apply(massCell);
    }

    public void deleteFigure(Cell source) {
        consumerDelete.accept(source);
    }

    public boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        return moveBiFunction.apply(source, dest);
    }

    public void moving(Cell source, Cell dest) {
        movingBiConsumer.accept(source, dest);
    }

    public static void main(String[] args) {
        System.out.println("Создадим объект класса Board");
        Board board = new Board();
        System.out.println("Создали объект board= " + board);
        System.out.println("Создадим две клетки source и dest.");
        Cell source = new Cell(1, 1);
        System.out.println("Клетка source= " + source + " с координатами x= " + source.getX() + " y= " + source.getY());
        Cell dest = new Cell(5, 5);
        System.out.println("Клетка dest= " + dest + " с координатами x= " + dest.getX() + " y= " + dest.getY());
        System.out.println("Создадим фигуру слона с координатами source");
        Figure figure = new Elephant(source);
        System.out.println("Фигура слон figure =" + figure + " с координатами:(" + figure.position.getX() + ", " + figure.position.getY() + ")");
        System.out.println("Поставим нашу фигуру и еще пешку на шахматную доску.");
        board.add(figure);
        board.add(new Peshka(new Cell(2, 3)));
        System.out.println("Проверим, что наши фигуры стоят на шахматной доске и занимают ее клетки.");
        for (int i = 0; i < board.figures.length; i++) {
            if (board.figures[i] != null) {
                System.out.println("Есть фигура:figures[" + i + "] x= " + board.figures[i].position.getX() + " y= " + board.figures[i].position.getY());
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.cells[i][j] != null) {
                    System.out.println("Занимает клетку доски:cells[" + i + "][" + j + "]: x= " + board.cells[i][j].getX() + " y= " + board.cells[i][j].getY());
                }
            }
        }
        System.out.println("Передвинем нашу фигуру слона на клетку dest:(" + dest.getX() + ", " + dest.getY() + ")");
        board.moving(source, dest);
        System.out.println("Проверим, что наша фигура меняет свои координаты и занимает другую клетку доски.");
        for (int i = 0; i < board.figures.length; i++) {
            if (board.figures[i] != null) {
                System.out.println("Есть фигура:figures[" + i + "] x= " + board.figures[i].position.getX() + " y= " + board.figures[i].position.getY());
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.cells[i][j] != null) {
                    System.out.println("Занимает клетку доски:cells[" + i + "][" + j + "]: x= " + board.cells[i][j].getX() + " y= " + board.cells[i][j].getY());
                }
            }
        }
    }
}
