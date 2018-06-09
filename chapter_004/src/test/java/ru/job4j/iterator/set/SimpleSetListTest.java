package ru.job4j.iterator.set;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 2.06.2018
 */

import org.junit.Test;
import ru.job4j.set.SimpleSetList;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetListTest {
    @Test
    public void whenAddOfSimpleSetThenAddingElement() {
        SimpleSetList<Integer> simpleSetList = new SimpleSetList<>();
        simpleSetList.add(1);
        simpleSetList.add(2);
        simpleSetList.add(2);
        simpleSetList.add(3);
        simpleSetList.add(4);
        simpleSetList.add(5);
        Iterator<Integer> iterator = simpleSetList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(false));
    }
}
