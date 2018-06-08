package ru.job4j.list;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.06.2018
 */
public class Cicle {

    private Node<Integer>[] integerNode;

    private Node<Integer> first = new Node<>(null);

    public void init(int elements) {
        integerNode = new Node[elements];
        for (int i = 0; i < elements; i++) {
            integerNode[i] = new Node<>(i + 1);
        }

        for (int i = 0; i < integerNode.length - 1; i++) {
            integerNode[i].next = integerNode[i + 1];
        }
        this.first.next = integerNode[0];
    }

    public void chengeElement(int firstLink, int secondLink) {
        this.integerNode[secondLink].next = this.integerNode[firstLink];
    }

    public Node<Integer> getFirst() {
        return first;
    }

    public boolean hasCicle(Node<Integer> first) {
        Node result = first;
        Node countResult;
        boolean flag = false;
        while (result.next != null) {
            countResult = first;
            while (true) {
                if (result.next == countResult) {
                    flag = true;
                    break;
                }
                if (countResult == result) {
                    break;
                } else {
                    countResult = countResult.next;
                }
            }
            if (flag) {
                break;
            }
            result = result.next;
        }
        return flag;
    }


    private static class Node<E> {
        E value;
        Node next;

        private Node(E value) {
            this.value = value;
        }
    }
}
