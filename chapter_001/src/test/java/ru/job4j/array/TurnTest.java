package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
/**
 * Test.
 *
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 14.12.2017
 */
public class TurnTest {
    @Test
    public void whenBackThenTurnChet() {
        Turn turn = new Turn();
        int[] mass = {1, 2, 3, 4};
        int[] resultMass = {4, 3, 2, 1};
        assertArrayEquals(resultMass, turn.back(mass));
    }
    @Test
    public void whenBackThenTurnNoChet() {
        Turn turn = new Turn();
        int[] mass = {1, 2, 3, 4, 5};
        int[] resultMass = {5, 4, 3, 2, 1};
        assertArrayEquals(resultMass, turn.back(mass));
    }
}
