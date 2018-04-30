package ru.job4j.job;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 30.04.2018
 */
public class TicTacToe {
    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        boolean flag = false;
        for (int i = 0; i < values.length - 2 && !flag; i++) {
            for (int j = 0; j < values.length - 2 && !flag; j++) {
                if (values[i][j] == values[i + 1][j + 1] && values[i + 1][j + 1] == values[i + 2][j + 2] || values[i + 2][j] == values[i + 1][j + 1] && values[i + 1][j + 1] == values[i][j + 2]) {
                    flag = true;
                    break;
                }
                for (int k = 0; k < 3; k++) {
                    if (values[i + k][j] == values[i + k][j + 1] && values[i + k][j + 1] == values[i + k][j + 2]) {
                        flag = true;
                        break;
                    }
                    if (values[i][j + k] == values[i + 1][j + k] && values[i + 1][j + k] == values[i + 2][j + k]) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(new int[][]{{1, 0, 0}, {0, 0, 0}, {1, 0, 1}});
        System.out.println(ticTacToe.hasWinner());
        TicTacToe ticTacToe1 = new TicTacToe(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}});
        System.out.println(ticTacToe1.hasWinner());
    }
}