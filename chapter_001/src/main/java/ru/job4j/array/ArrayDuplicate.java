package ru.job4j.array;
import java.util.Arrays;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 26.12.2017
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
		int unique = array.length;
		for (int out = 0; out < unique; out++) {
			for (int in =  out + 1; in < unique; in++) {
				if (array[out].equals(array[in])) {
					array[in] = array[--unique];
					in--;
				}
			}
		}
        return Arrays.copyOf(array, unique);
    }

}

