package ru.job4j.iterator.generic;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 8.05.2018
 */

import java.util.Iterator;

import org.junit.Test;
import ru.job4j.generic.SimpleArray;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    @Test
    public void whenAddThenAddingElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(new String[1]);
        simpleArray.add("1");
        String expect = "1";
        String result = simpleArray.get(0);
        assertThat(expect, is(result));
    }

    @Test
    public void whenSetThenSettingElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(new String[1]);
        simpleArray.add("1");
        simpleArray.setArray(0, "12");
        String expect = "12";
        String result = simpleArray.get(0);
        assertThat(expect, is(result));
    }

    @Test
    public void whenDeleteThenDeletingElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(new String[1]);
        simpleArray.add("1");
        simpleArray.delete(0);
        String result = simpleArray.get(0);
        assertThat(null, is(result));
    }

    @Test
    public void whenIteratorThenElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(new String[5]);
        simpleArray.add("1");
        simpleArray.add("2");
        simpleArray.add("3");
        simpleArray.add("4");
        simpleArray.add("5");
        Iterator<String> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("3"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("4"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("5"));
        assertThat(iterator.hasNext(), is(false));
    }
}
