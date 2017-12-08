package ru.job4j.max;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 8.12.2017
 */
public class Max {
    public int max(int first, int second) {
        int max;
        max = (first > second) ? first : second;
        return max;
    };
}
