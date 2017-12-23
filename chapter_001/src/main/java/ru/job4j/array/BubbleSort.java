package ru.job4j.array;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 23.12.2017
 */
public class BubbleSort {
    public int[] sort(int[] array) {
        int x;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    x = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }
}
