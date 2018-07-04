package ru.job4j.iterator.tree;

import org.junit.Test;
import ru.job4j.tree.binary.TreeBinary;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.07.2018
 */
public class TreeBinaryTest {

    @Test
    public void whenAddToTreeThenIterator() {
        TreeBinary<Integer> treeBinary = new TreeBinary<>();
        treeBinary.add(5);
        treeBinary.add(4);
        treeBinary.add(6);
        treeBinary.add(7);
        treeBinary.add(3);
        treeBinary.add(8);
        treeBinary.add(2);
        Iterator<Integer> iterator = treeBinary.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(8));
    }
}
