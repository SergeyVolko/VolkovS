package ru.job4j.list;

import java.util.Iterator;

public interface ListInterface<E> {
    void add(E value);
    E get(int index);
    Iterator<E> iterator();
    E delete();
    int getSize();

     default ListInterface getInstance(ListInterface<E> listInterface) throws IllegalAccessException, InstantiationException {
        return listInterface.getClass().newInstance();
    }
}
