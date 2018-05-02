package ru.job4j;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 2.05.2018
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] numbers;
    private int index = 0;
    private int countEven = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    private int sumEven() {
        int sum = 0;
        for (int i : numbers) {
            if (i % 2 == 0) {
                sum++;
            }
        }
        return sum;
    }

    @Override
    public Integer next() {
        boolean flag = false;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                flag = true;
                countEven++;
                break;
            }
            index++;
        }
        if (!flag) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }

    @Override
    public boolean hasNext() {
        int sum = this.sumEven();
        return sum != countEven;
    }
}
