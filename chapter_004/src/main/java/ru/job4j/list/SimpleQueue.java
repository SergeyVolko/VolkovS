package ru.job4j.list;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.05.2018
 */

public class SimpleQueue<T> {
    private MyLinkedList<T> myLinkedList = new MyLinkedList<>();

    public T poll() {
        return this.myLinkedList.delete();
    }

    public void push(T value) {
        this.myLinkedList.add(value);
    }

}
