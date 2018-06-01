package ru.job4j.iterator.set;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.06.2018
 */

import org.junit.Test;
import ru.job4j.set.SimpleSet;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    @Test
    public void whenAddOfSimpleSetThenAddingElement() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(4);
        simpleSet.add(5);
        String expect = "12345";
        StringBuilder result = null;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Integer> iterator = simpleSet.iterator();
        while (iterator.hasNext()) {
            result = stringBuilder.append(iterator.next().toString());
        }
        assertThat(expect, is(result.toString()));
    }
}
