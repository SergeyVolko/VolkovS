package ru.job4j;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 6.05.2018
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIt implements Iterator<Integer> {
    private int[] values;
    private int index = 0;

    public PrimeIt(int[] values) {
        this.values = values;
    }

    private boolean searchPrime(int value) {
        boolean flag = true;
        if ((value == 1) || ((value % 2 == 0 || value % 5 == 0) && (value != 2) && (value != 5))) {
            flag = false;
        } else {
            for (int i = 4; i <= (int) Math.sqrt(value) + 1; i++) {
                if (value % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.values[index++];
    }

    @Override
    public boolean hasNext() {
        boolean flag = false;
        for (int i = this.index; i < this.values.length; i++) {
            if (this.searchPrime(this.values[i])) {
                this.index = i;
                flag = true;
                break;
            }
        }
        return flag;
    }
}
