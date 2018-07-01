package ru.job4j.tree;

import java.util.*;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.07.2018
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;
    private int modCount;
    private Queue<E> myQueue = new LinkedList<>();

    @Override
    public boolean add(E parent, E child) {
        boolean flag = false;
        Optional<Node<E>> searchParent;
        Optional<Node<E>> searchChild;
        if (root == null) {
            root = new Node<>(parent);
            root.add(new Node<>(child));
            modCount++;
            flag = true;
        } else {
            searchParent = this.findBy(parent);
            searchChild = this.findBy(child);
            if (searchParent.isPresent() && !searchChild.isPresent()) {
                searchParent.get().add(new Node<>(child));
                modCount++;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Queue<E> queue;
            boolean flagInit = false;
            int expectedModCount = modCount;

            private void init() {
                queue = new LinkedList<>();
                Queue<Node<E>> res = new LinkedList<>();
                res.offer(root);
                queue.offer(root.getValue());
                while (true) {
                    Node<E> el = res.poll();
                    if (el == null) {
                        break;
                    }

                    for (Node<E> child : el.leaves()) {
                        queue.offer(child.getValue());
                        res.offer(child);
                    }
                }
            }

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!flagInit) {
                    this.init();
                    flagInit = true;
                }
                return !queue.isEmpty();
            }

            @Override
            public E next() {
                E next;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!flagInit) {
                    this.init();
                    flagInit = true;
                }
                next = queue.poll();
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }

            @Override
            public String toString() {
                return "$classname{" + "queue=" + queue + '}';
            }
        };
    }
}
