package ru.job4j.loop;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 14.12.2017
 */
public class Factorial {
    public int calc(int n) {
        int fact = 1;
        if (n == 0) {
            return fact;
        }
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}

