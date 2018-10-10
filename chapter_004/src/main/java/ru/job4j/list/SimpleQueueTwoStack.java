package ru.job4j.list;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.10.2018
 */
public class SimpleQueueTwoStack<T> {
    private SimpleStack<T> inputStack = new SimpleStack<>();
    private SimpleStack<T> outputStack = new SimpleStack<>();
    private int size = 0;

    public void push(T value) {
        inputStack.push(value);
        size++;
    }

    public T poll() {
        T value = null;
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.poll());
            }
        }
        if (!outputStack.isEmpty()) {
            value = outputStack.poll();
            size--;
        }
        return value;
    }

    public int getSize() {
        return size;
    }
}
