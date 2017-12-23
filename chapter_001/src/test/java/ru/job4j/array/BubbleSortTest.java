package ru.job4j.array;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 23.12.2017
 */
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] mass = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] resultMass = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertArrayEquals(resultMass, bubble.sort(mass));
    }
}
