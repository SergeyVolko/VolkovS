package ru.job4j.iterator.listtest;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.05.2018
 */

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.MyLinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyLinkedListTest {
    private MyLinkedList<Integer> myLinkedList;

    @Before
    public void beforeTest() {
        myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            myLinkedList.add(i + 1);
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddThenAddingElementOfList() {
        beforeTest();
        Iterator<Integer> iterator = myLinkedList.iterator();
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
        assertThat(myLinkedList.get(3), is(3));
        assertThat(myLinkedList.getSize(), is(5));
        myLinkedList.add(6);
        assertThat(myLinkedList.delete(), is(1));
        assertThat(myLinkedList.delete(), is(2));
        assertThat(myLinkedList.delete(), is(3));
        assertThat(myLinkedList.delete(), is(4));
        assertThat(myLinkedList.delete(), is(5));
        iterator.hasNext();

    }
}
