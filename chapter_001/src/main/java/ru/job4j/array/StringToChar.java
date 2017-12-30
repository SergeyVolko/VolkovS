package ru.job4j.array;
/**
 *
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 30.12.2017
 */
public class StringToChar {
    boolean contains(String origin, String sub) {
        char[] arrayOrigin = new char[origin.length()];
        char[] arraySub = new char[sub.length()];
        for (int i = 0; i < origin.length(); i++) {
            arrayOrigin[i] = origin.charAt(i);
        }
        for (int i = 0; i < sub.length(); i++) {
            arraySub[i] = sub.charAt(i);
        }
        for (int i = 0; i < arrayOrigin.length; i++) {
            if (arraySub[0] == arrayOrigin[i]) {
                for (int j = 1; j < arraySub.length; j++) {
                    if (arraySub[j] != arrayOrigin[i + j]) {
                        return false;
                    }
                }
                break;
            }
        }
        return true;
    }

}
