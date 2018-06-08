package ru.job4j.iterator.listtest;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.06.2018
 */

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.Cicle;

import javax.xml.soap.Node;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CicleTest {
    private Cicle cicle;

    @Before
    public void initBefore() {
        cicle = new Cicle();
        cicle.init(10000);
    }

    @Test
    public void whenHasCicleThenResultTrueOrFalse() {
        assertThat(cicle.hasCicle(cicle.getFirst()), is(false));
        cicle.chengeElement(1456, 3890);
        assertThat(cicle.hasCicle(cicle.getFirst()), is(true));
        cicle.chengeElement(3891, 3890);
        assertThat(cicle.hasCicle(cicle.getFirst()), is(false));

    }
}
