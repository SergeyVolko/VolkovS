package ru.job4j.tictactoe;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.05.2018
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        int vert, gor, diagLR, diagRL;
        boolean flag = false;
        for (int i = 0; i < table.length; i++) {
            vert = 0;
            gor = 0;
            diagLR = 0;
            diagRL = 0;
            for (int j = 0; j < table.length; j++) {
                if (this.table[i][j].hasMarkX()) {
                    vert++;
                }
                if (this.table[j][i].hasMarkX()) {
                    gor++;
                }
                if (i == 0 && this.table[i + j][j].hasMarkX()) {
                    diagLR++;
                }
                if (i == 0 && this.table[i + j][2 - j].hasMarkX()) {
                    diagRL++;
                }
                if (diagLR == 3 || diagRL == 3 || gor == 3 || vert == 3) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }

    public boolean isWinnerO() {
        int vert, gor, diagLR, diagRL;
        boolean flag = false;
        for (int i = 0; i < table.length; i++) {
            vert = 0;
            gor = 0;
            diagLR = 0;
            diagRL = 0;
            for (int j = 0; j < table.length; j++) {
                if (this.table[i][j].hasMarkO()) {
                    vert++;
                }
                if (this.table[j][i].hasMarkO()) {
                    gor++;
                }
                if (i == 0 && this.table[i + j][j].hasMarkO()) {
                    diagLR++;
                }
                if (i == 0 && this.table[i + j][2 - j].hasMarkO()) {
                    diagRL++;
                }
                if (diagLR == 3 || diagRL == 3 || gor == 3 || vert == 3) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }

    public boolean hasGap() {
        boolean flag = false;
        for (Figure3T[] i : this.table) {
            for (Figure3T j : i) {
                if (!j.hasMarkO() && !j.hasMarkX()) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
