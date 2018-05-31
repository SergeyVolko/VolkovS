package ru.job4j.list;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.05.2018
 */

public class SimpleStack<T> {
    private SimpleArrayList<T> simpleArrayList = new SimpleArrayList<>();

    public T poll() {
        return this.simpleArrayList.delete();
    }

    public void push(T value) {
        this.simpleArrayList.add(value);
    }
}

