package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.03.2018
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

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

    @Test
    public void whenConvertThenTakeList() {
        String expect = "[1, 2, 3, 4, 5, 6, 7, 8, 9]";
        String result;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3, 4});
        list.add(new int[]{5, 6, 7});
        list.add(new int[]{8, 9});
        ConvertList convertList = new ConvertList();
        List<Integer> integerList = convertList.convert(list);
        result = String.format("%s", integerList);
        assertThat(result, is(expect));
    }
}
