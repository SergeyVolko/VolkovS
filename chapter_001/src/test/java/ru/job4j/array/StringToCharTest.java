package ru.job4j.array;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 30.12.2017
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StringToCharTest {
    @Test
    public void whenContainsThenEqualsTwoStringTrue() {
        StringToChar ob = new StringToChar();
        String origin = "Привет";
        String sub = "иве";
        boolean result = ob.contains(origin, sub);
        assertThat(true, is(result));
    }
    @Test
    public void whenContainsThenEqualsTwoStringFalse() {
        StringToChar ob = new StringToChar();
        String origin = "Привет";
        String sub = "Пве";
        boolean result = ob.contains(origin, sub);
        assertThat(false, is(result));
    }
    @Test
    public void whenContainsThenEqualsTwoStringLengthTrue() {
        StringToChar ob = new StringToChar();
        String origin = "Привет";
        String sub = "Привет";
        boolean result = ob.contains(origin, sub);
        assertThat(true, is(result));
    }
}
