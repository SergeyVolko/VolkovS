package ru.job4j.tree.binary;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 4.07.2018
 */

import java.util.*;

public class TreeBinary<E extends Comparable<E>> implements Iterable<E> {
    private NodeBinary<E> root;
    private int modeCount;

    public void add(E e) {
        this.root = add(e, this.root);
        modeCount++;
    }


    private NodeBinary<E> add(E e, NodeBinary<E> nodeBinary) {
        if (nodeBinary == null) {
            nodeBinary = new NodeBinary<>(e);
        } else {
            if (nodeBinary.getValue().compareTo(e) > 0) {
                nodeBinary.leftChild = add(e, nodeBinary.leftChild);
            } else {
                nodeBinary.rightChild = add(e, nodeBinary.rightChild);
            }
        }
        return nodeBinary;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<E> queue = new LinkedList<>();
            int expectedModCount = modeCount;
            boolean flagInit = false;

            private void init(NodeBinary<E> nodeBinary) {
                if (nodeBinary != null) {
                    init(nodeBinary.leftChild);
                    queue.offer(nodeBinary.getValue());
                    init(nodeBinary.rightChild);
                }
                flagInit = true;
            }

            @Override
            public boolean hasNext() {
                if (expectedModCount != modeCount) {
                    throw new ConcurrentModificationException();
                }
                if (!flagInit) {
                    this.init(root);
                }
                return !queue.isEmpty();
            }

            @Override
            public E next() {
                E next;
                if (expectedModCount != modeCount) {
                    throw new ConcurrentModificationException();
                }
                if (!flagInit) {
                    this.init(root);
                }
                next = queue.poll();
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
}
