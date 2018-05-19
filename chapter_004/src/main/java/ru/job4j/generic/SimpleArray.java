package ru.job4j.generic;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 8.05.2018
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private T[] array;
    private int index = 0;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
        this.array[index++] = model;
    }

    public void setArray(int index, T model) {
        this.array[index] = model;
    }

    public void delete(int index) {
        this.array[index] = null;
    }

    public T get(int index) {
        return this.array[index];
    }

    T[] getArray() {
        return this.array;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int anInt = 0;

            @Override
            public boolean hasNext() {
                return anInt < array.length;
            }

            @Override
            public T next() {
                if (anInt > array.length - 1) {
                    throw new NoSuchElementException();
                }
                return array[anInt++];
            }
        };
    }
}
