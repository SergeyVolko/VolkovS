package ru.job4j.array;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 26.12.2017
 */

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] except = {"Привет", "Мир", "Супер"};
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutAllDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Привет", "Привет", "Привет", "Привет"};
        String[] except = {"Привет"};
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutAllUnique() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"Один", "Два", "Три", "Четыре", "Пять"};
        String[] except = {"Один", "Два", "Три", "Четыре", "Пять"};
        String[] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }
}
