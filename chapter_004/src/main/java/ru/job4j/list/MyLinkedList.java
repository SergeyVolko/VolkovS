package ru.job4j.list;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.05.2018
 */

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {

    private Node<E> first = new Node<>(null);
    private Node<E> last;
    private int size;
    private int modCount;

    public void add(E value) {
        Node<E> result = new Node<>(value);
        if (this.first.next == null) {
            this.first.next = result;
        } else {
            this.last.next = result;
        }
        this.last = result;
        this.size++;
        this.modCount++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;

    }

    public int getSize() {
        return this.size;
    }

    public E delete() {
        Node<E> result = this.first.next;
        this.first.next = result.next;
        this.modCount++;
        return result.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            Node<E> replace = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return replace.next != null;
            }

            @Override
            public E next() {

                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (replace.next == null) {
                    throw new NoSuchElementException();
                }
                replace = replace.next;
                return replace.value;
            }
        };
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }
}
