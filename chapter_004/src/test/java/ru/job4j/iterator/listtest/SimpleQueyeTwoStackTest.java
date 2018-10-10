package ru.job4j.iterator.listtest;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.SimpleQueueTwoStack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.10.2018
 */

public class SimpleQueyeTwoStackTest {
    private SimpleQueueTwoStack<Integer> integerSimpleQueueTwoStack = new SimpleQueueTwoStack<>();

    @Before
    public void beforeMethod() {
        for (int i = 0; i < 5; i++) {
            integerSimpleQueueTwoStack.push(i + 1);
        }
    }

    @Test
    public void whenPollTwoStackThenQueue() {
        for (int i = 0; i < 5; i++) {
            assertThat(integerSimpleQueueTwoStack.poll(), is(i + 1));
            if (i == 2) {
                integerSimpleQueueTwoStack.push(i + 5);
            }
        }
        assertThat(integerSimpleQueueTwoStack.poll(), is(7));
    }
}
