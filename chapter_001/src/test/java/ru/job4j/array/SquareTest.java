package ru.job4j.array;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 19.12.2017
 */
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
public class SquareTest {
    @Test
    public void whenSquareCalculateThenResult() {
        Square sq = new Square();
        int[] mass = {1, 4, 9};
        int[] result = sq.calculate(3);
        assertArrayEquals(result,mass);
    }
}
