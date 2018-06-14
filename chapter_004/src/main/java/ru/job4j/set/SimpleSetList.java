package ru.job4j.set;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 2.06.2018
 */

import ru.job4j.list.MyLinkedList;

import java.util.Iterator;

public class SimpleSetList<T> implements Iterable<T> {
    private MyLinkedList<T> myLinkedList = new MyLinkedList<>();

    public void add(T value) {
        if (!contain(value)) {
            this.myLinkedList.add(value);
        }
    }

    private boolean contain(T value) {
        boolean flag = false;
        for (T node : this.myLinkedList) {
            if (node.equals(value)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public Iterator<T> iterator() {
        return this.myLinkedList.iterator();
    }
}
