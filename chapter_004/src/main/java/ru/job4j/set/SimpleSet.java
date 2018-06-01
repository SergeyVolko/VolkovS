package ru.job4j.set;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.06.2018
 */

import ru.job4j.list.ListArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private ListArray<T> listArray = new ListArray<>();

    public void add(T value) {
        boolean flag = false;
        for (T count : this.listArray) {
            if (count.equals(value)) {
                flag = true;
            }
        }
        if (!flag) {
            this.listArray.add(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.listArray.iterator();
    }
}
