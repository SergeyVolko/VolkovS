package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.03.2018
 */

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ConvertListTest {
    @Test
    public void whenToListAndToArrayThenArray() {
        int[][] firstMass = {{1, 2, 3}, {4, 5, 6}, {7}};
        int[][] expectMass = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        ConvertList convertList = new ConvertList();
        List<Integer> integerList = convertList.toList(firstMass);
        int[][] resultMass = convertList.toArray(integerList, 3);
        assertArrayEquals(expectMass, resultMass);
    }
}
