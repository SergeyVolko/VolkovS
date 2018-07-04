package ru.job4j.tree.binary;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 4.07.2018
 */
public class NodeBinary<E extends Comparable<E>> {
    private E value;
    NodeBinary<E> leftChild;
    NodeBinary<E> rightChild;

    public NodeBinary(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }
}
