package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 22.12.2017
 */
public class FindLoopTest {
    @Test
    public void whenIndexOfthenMassResult() {
        FindLoop fl = new FindLoop();
        int[] mass = {7, 1, 6, 9};
        int element = 6;
        int result = 2;
        assertThat(result, is(fl.indexOF(mass, element)));
    }
    @Test
    public void whenIndexOfthenMassNoResult() {
        FindLoop fl = new FindLoop();
        int[] mass = {7, 1, 6, 9};
        int element = 10;
        int result = -1;
        assertThat(result, is(fl.indexOF(mass, element)));
    }
}
