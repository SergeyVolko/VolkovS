package ru.job4j.list;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 22.05.2018
 */

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListArray<E> implements Iterable<E> {

    private Object[] container;
    private int countElement = 0;
    private int modCount = 0;

    public ListArray() {
        this.container = new Object[10];
    }

    public void add(E value) {
        if (this.countElement == this.container.length) {
            this.container = Arrays.copyOf(this.container, this.container.length + 10);
        }
        this.container[this.countElement++] = value;
        modCount++;
    }

    public E get(int index) {
        return ((index >= 0) && (index < this.container.length)) ? (E) this.container[index] : null;
    }

    int getCountElement() {
        return this.countElement;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int indexArray = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return indexArray < countElement;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (indexArray >= countElement) {
                    throw new NoSuchElementException();
                }
                return (E) container[indexArray++];
            }
        };
    }

    @Override
    public String toString() {
        return "ListArray{" + "container=" + Arrays.toString(container) + '}';
    }
}
