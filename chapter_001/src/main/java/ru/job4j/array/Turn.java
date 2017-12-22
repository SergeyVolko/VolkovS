package ru.job4j.array;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 22.12.2017
 */
public class Turn {
    public int[] back(int[] array) {
        int m;
        for (int i = 0; i < array.length / 2; i++) {
            m = array[i];
            array[i] = array[array.length - (i + 1)];
            array[array.length - (i + 1)] = m;
        }
        return array;
    }
}
