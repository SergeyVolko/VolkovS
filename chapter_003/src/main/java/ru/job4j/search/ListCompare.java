package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 2.04.2018
 */

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    /**
     * Данный метод реализует интерфейс Comparator и принимает 2 параметра.
     *
     * @param left  - первый параметр типа String
     * @param right - второй параметр типа String
     * @return - возвращаемое значение типа int
     * Метод работает следующим образом:
     * - если параметры содержат одинаковые символы то он вернет 0;
     * - если параметр right(left) совпадет с left(right), но длина их будет разной, то метод вернет их разницу ;
     * - если соответствующие по индексу символы не совпадают, то метод вернет их разницу при сравнении, с учетом их
     * лексиграфического порядка.
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int minLength = left.length() < right.length() ? left.length() : right.length();
        for (int i = 0; i < minLength; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
            if (i == minLength - 1) {
                result = left.length() - right.length();
            }
        }
        return result;
    }
}
