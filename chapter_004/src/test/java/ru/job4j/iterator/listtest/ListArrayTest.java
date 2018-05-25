package ru.job4j.iterator.listtest;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 22.05.2018
 */

import org.junit.Test;
import org.junit.Before;
import ru.job4j.list.ListArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ListArrayTest {
    private ListArray<Integer> listArray;

    @Before
    public void beforeTest() {
        listArray = new ListArray<>();
        for (int i = 0; i < 10; i++) {
            listArray.add(i + 1);
        }
    }

    @Test
    public void whenAddElementToContainerThenAdding() {
        this.beforeTest();
        String expect = "ListArray{container=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}";
        assertThat(expect, is(listArray.toString()));
    }

    @Test
    public void whenNoMoreSize() {
        this.beforeTest();
        listArray.add(11);
        String expect = "ListArray{container=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, null, null, null, null, null, null, null, null, null]}";
        assertThat(expect, is(listArray.toString()));
    }

    @Test
    public void whenGetThenElement() {
        this.beforeTest();
        int expect = 5;
        assertThat(expect, is(listArray.get(4)));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCreateIteratorAndException() {
        this.beforeTest();
        Iterator<Integer> iterator = listArray.iterator();
        listArray.add(11);
        iterator.hasNext();
    }
}
