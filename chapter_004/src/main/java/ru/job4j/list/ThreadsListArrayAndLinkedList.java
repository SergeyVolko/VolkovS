package ru.job4j.list;

import java.util.Iterator;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ThreadsListArrayAndLinkedList<E> implements ListInterface<E>, Iterable<E>{

    private ListInterface<E> list;
    public ThreadsListArrayAndLinkedList(ListInterface<E> value) {
        this.list = value;
    }

    @Override
    @GuardedBy("this")
    public synchronized void add(E value) {
        this.list.add(value);
    }

    @Override
    @GuardedBy("this")
    public synchronized E get(int index) {
        return this.list.get(index);
    }

    @Override
    @GuardedBy("this")
    public synchronized Iterator<E> iterator() {
        return this.copy().iterator();
    }

    @Override
    @GuardedBy("this")
    public synchronized String toString() {
        return String.valueOf(this.list);
    }

    @Override
    @GuardedBy("this")
    public synchronized E delete() {
        return this.list.delete();
    }

    @Override
    @GuardedBy("this")
    public synchronized int getSize() {
        return this.list.getSize();
    }

    private ListInterface<E> copy() {
        ListInterface<E> listInterface = new ListArray<>();
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            listInterface.add(iterator.next());
        }
        return listInterface;
    }
}
