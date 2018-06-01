package ru.job4j.iterator.listtest;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.06.2018
 */

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.Cicle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CicleTest {
    private Cicle<Integer> cicle;

    @Before
    public void initBefore() {
        cicle = new Cicle<>(new Cicle.Node<>(1), new Cicle.Node<>(2), new Cicle.Node<>(3), new Cicle.Node<>(4));
        cicle.init();
    }

    @Test
    public void whenHasCicleThenResultTrueOrFalse() {
        assertThat(cicle.hasCicle(cicle.getFirst()), is(true));
        cicle.setFour(new Cicle.Node<>(6));
        assertThat(cicle.hasCicle(cicle.getFirst()), is(false));
        cicle.setThird(cicle.getTwo());
        assertThat(cicle.hasCicle(cicle.getFirst()), is(true));
    }
}
