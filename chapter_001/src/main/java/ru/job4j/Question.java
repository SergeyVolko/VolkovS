package ru.job4j;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 5.01.2017
 */
public class Question {
    public int[] methodArrays(int[] array1, int[] array2) {
        int[]arrayResult = new int[array1.length + array2.length];
        int k = 0;
        int m = 0;
        for (int i = 0; i < array1.length; i++) {
            if (k == array2.length) {
                arrayResult[k + (m++)] = array1[i];
            }
            for (int j = k; j < array2.length; j++) {
                if (m == array1.length) {
                    arrayResult[(k++) + m] = array2[j];
                    continue;
                }
                if (array1[i] > array2[j]) {
                    arrayResult[(k++) + m] = array2[j];
                    if (k == array2.length) {
                        i--;
                    }
                } else {
                    arrayResult[k + (m++)] = array1[i];
                    if (m == array1.length) {
                        j--;
                        continue;
                    }
                    break;
                }
            }
        }
        return arrayResult;
    }
}
