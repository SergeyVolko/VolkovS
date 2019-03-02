package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс SimpleArrayList.
 */

public class SimpleArrayList<E> implements Iterable<E>, ListInterface<E>{
    private int size;
    private Node<E> first;
    private int modCount;

    /**
     * Метод вставляет в начало списка данные.
     */
    @Override
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E delete() {
        if (this.first == null) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.first;
        this.first = result.next;
        this.size--;
        this.modCount++;
        return result.date;
    }

    /**
     * Метод получения элемента по индексу.
     */
    @Override
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    public Node<E> getFirst() {
        return first;
    }

    /**
     * Метод получения размера коллекции.
     */
    @Override
    public int getSize() {
        return this.size;
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
                return replace != null;
            }

            @Override
            public E next() {
                E result;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (replace == null) {
                    throw new NoSuchElementException();
                }
                result = replace.date;
                replace = replace.next;
                return result;
            }
        };
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}
