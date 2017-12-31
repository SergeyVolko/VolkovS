package ru.job4j.array;
/**
 *
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 30.12.2017
 */
public class StringToChar {
    boolean contains(String origin, String sub) {
        char[] arrayOrigin = origin.toCharArray();
        char[] arraySub = sub.toCharArray();
        boolean result = true;
        for (int i = 0; i < arrayOrigin.length; i++) {
            if (arraySub[0] == arrayOrigin[i]) {
                for (int j = 1; j < arraySub.length; j++) {
                    if (arraySub[j] != arrayOrigin[i + j]) {
                        result = false;
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }

}
