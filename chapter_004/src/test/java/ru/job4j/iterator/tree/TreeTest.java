package ru.job4j.iterator.tree;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.tree.Tree;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.07.2018
 */

public class TreeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenCreateIterator() {
        exception.expect(NoSuchElementException.class);
        Tree<Integer> tree = new Tree<>();
        System.out.println(tree.add(1, 2));
        System.out.println(tree.add(1, 3));
        System.out.println(tree.add(1, 4));
        System.out.println(tree.add(4, 5));
        System.out.println(tree.add(5, 6));
        System.out.println(tree.add(5, 2));
        Iterator<Integer> it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        System.out.println(it);
        assertThat(it.next(), is(1));
        System.out.println(it);
        assertThat(it.hasNext(), is(true));
        System.out.println(it);
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        System.out.println(it);
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        System.out.println(it);
        assertThat(it.next(), is(4));
        System.out.println(it);
        assertThat(it.hasNext(), is(true));
        System.out.println(it);
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        System.out.println(it);
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        System.out.println(it);
        assertThat(it.next(), is(7));
    }

    @Test
    public void whenNextThenException() {
        exception.expect(ConcurrentModificationException.class);
        Tree<Integer> tree = new Tree<>();
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> iterator = tree.iterator();
        iterator.next();
        tree.add(6, 7);
        iterator.hasNext();
    }
}

