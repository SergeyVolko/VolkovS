package ru.job4j;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 2.05.2018
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorArrayDuo implements Iterator<Integer> {
    private int[][] value;
    private int row = 0, cell = 0;

    public IteratorArrayDuo(int[][] value) {
        this.value = value;
    }

    @Override
    public Integer next() {
        if (this.value.length == 0) {
            throw new NoSuchElementException();
        }
        if (this.value[row].length == this.cell) {
            cell = 0;
            row++;
        }
        return this.value[this.row][this.cell++];
    }

    @Override
    public boolean hasNext() {
        return (this.row != this.value.length - 1) || (this.cell != this.value[row].length);
    }
}
