package ru.job4j.ext;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 20.03.2018
 */

import org.junit.Test;
import ru.job4j.cofee.CofeMashine;

import static org.junit.Assert.assertArrayEquals;

public class CofeMashineTest {
    @Test
    public void whenChengeThenMassSdacha() {
        int[] expect = {10, 10, 10, 10, 10, 10, 5, 2, 1};
        CofeMashine cofeMashine = new CofeMashine();
        int[] result = cofeMashine.changes(100, 32);
        assertArrayEquals(expect, result);
    }
}
