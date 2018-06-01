package ru.job4j.list;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 1.06.2018
 */
public class Cicle<T> {

    private Node<T> first;
    private Node<T> two;
    private Node<T> third;
    private Node<T> four;

    public Cicle(Node<T> first, Node<T> two, Node<T> third, Node<T> four) {
        this.first = first;
        this.two = two;
        this.third = third;
        this.four = four;
    }


    public void init() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
    }

    public Node<T> getFirst() {
        return first;
    }

    public boolean hasCicle(Node<Integer> first) {
        Node<Integer> result = first;
        Node<Integer> countResult;
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

    public void setFirst(Node<T> first) {
        this.first.next = first;
    }

    public Node<T> getTwo() {
        return two;
    }

    public void setTwo(Node<T> two) {
        this.two.next = two;
    }

    public Node<T> getThird() {
        return third;
    }

    public void setThird(Node<T> third) {
        this.third.next = third;
    }

    public Node<T> getFour() {
        return four;
    }

    public void setFour(Node<T> four) {
        this.four.next = four;
    }

    public static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
