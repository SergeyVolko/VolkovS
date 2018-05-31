package ru.job4j.iterator.listtest;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.05.2018
 */

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.MyLinkedList;
import ru.job4j.list.SimpleQueue;
import ru.job4j.list.SimpleStack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleStackQueueTest {
    private SimpleStack<Integer> simpleStack;
    private SimpleQueue<Integer> simpleQueue;

    @Before
    public void beforeMethod() {
        simpleStack = new SimpleStack<>();
        simpleQueue = new SimpleQueue<>();
        for (int i = 0; i < 3; i++) {
            simpleStack.push(i + 1);
            simpleQueue.push(i + 1);
        }
    }

    @Test
    public void whenPollStackAndQueueThenReturnValue() {
        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }
}
