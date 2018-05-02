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
    private int index1 = 0, index2 = 0;

    public IteratorArrayDuo(int[][] value) {
        this.value = value;
    }

    @Override
    public Integer next() {
        if (this.value.length == 0) {
            throw new NoSuchElementException();
        }
        if (this.value[index1].length == this.index2) {
            index2 = 0;
            index1++;
        }
        return this.value[this.index1][this.index2++];
    }

    @Override
    public boolean hasNext() {
        return (this.index1 != this.value.length - 1) || (this.index2 != this.value[index1].length);
    }
}
