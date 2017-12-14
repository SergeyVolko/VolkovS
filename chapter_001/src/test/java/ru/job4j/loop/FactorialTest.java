package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 14.12.2017
 */
public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial vol = new Factorial();
        int rsl = vol.calc(5);
        assertThat(rsl, is(120));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial vol = new  Factorial();
        int rsl = vol.calc(0);
        assertThat(rsl, is(1));
    }
}
