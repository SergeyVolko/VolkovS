package ru.job4j.lamdatest;

import org.junit.Test;
import ru.job4j.pingpong.lamda.FunctionList;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 28.09.2018
 */
public class FunctionListTest {
    @Test
    public void whenDiapasonThenCorrectList() {
        FunctionList functionList = new FunctionList();
        List<Double> list = functionList.diapason(2, 5,
                (n) -> (2 * n));
        assertThat(list, is(Arrays.asList(4.0, 6.0, 8.0)));
        list = functionList.diapason(1, 4, (n) -> Math.pow(n, 2.0) + 1);
        assertThat(list, is(Arrays.asList(2.0, 5.0, 10.0)));
        list = functionList.diapason(1, 4, (n) -> Math.log(n) + 1);
        assertThat(list, is(Arrays.asList(Math.log(1) + 1, Math.log(2) + 1, Math.log(3) + 1)));
    }
}
