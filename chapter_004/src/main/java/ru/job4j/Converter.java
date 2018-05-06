package ru.job4j;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 6.05.2018
 */

import java.util.*;

public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> rIt;
            Iterator<Integer> iterator;

            private void first() {
                if (rIt != null && rIt.hasNext()) {
                    return;
                }
                rIt = null;
                while (it.hasNext()) {
                    iterator = it.next();
                    if (iterator.hasNext()) {
                        rIt = iterator;
                        break;
                    }
                }
            }

            @Override
            public boolean hasNext() {
                first();
                return rIt != null;
            }

            @Override
            public Integer next() {
                first();
                if (rIt == null) {
                    throw new NoSuchElementException();
                }

                return rIt.next();
            }
        };
    }
}
