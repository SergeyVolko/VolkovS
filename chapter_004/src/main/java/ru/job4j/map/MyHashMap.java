package ru.job4j.map;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 28.06.2018
 */

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMap<K, V> implements Iterable<K> {

    private Node<K, V>[] table;
    private int size;
    private int modeCount;
    private double loadFactor = 0.75;
    private int defaultCapacity = 16;
    private double minLoadFactor = 0.5;

    public MyHashMap() {
        this.table = (Node<K, V>[]) new Node[defaultCapacity];
    }

    public boolean insert(K key, V value) {
        boolean flag = false;
        int index = this.hesh(key);
        if (this.table[index] == null) {
            this.table[index] = new Node<>(key, value);
            this.size++;
            this.modeCount++;
            flag = true;
        }
        if (((double) this.size) / ((double) this.table.length) > loadFactor) {
            this.resize();
        }
        return flag;
    }

    public V get(K key) {
        V value = null;
        int index = this.hesh(key);
        Node<K, V> node = this.table[index];
        if (node != null && (index == this.hesh(node.getKey())) && (key == null || key.equals(node.getKey()))) {
            value = node.getValue();
        }
        return value;
    }

    public boolean delete(K key) {
        boolean flag = false;
        int index = this.hesh(key);
        Node<K, V> node = this.table[index];
        if (node != null && (index == this.hesh(node.getKey())) && (key == null || key.equals(node.getKey()))) {
            this.table[index] = null;
            size--;
            modeCount--;
            flag = true;
        }
        return flag;
    }

    private int hesh(K key) {
        int h = 0;
        if (key != null) {
            h = key.hashCode();
        }
        return (key == null) ? 0 : ((h) ^ (h >>> 16)) & (this.table.length - 1);
    }

    private void resize() {
        Node<K, V>[] oldTable = this.table;
        Node<K, V>[] newTable;
        int count = 0;
        this.modeCount++;
        int newCapacity = (int) (oldTable.length * (1 + minLoadFactor));
        newTable = (Node<K, V>[]) new Node[newCapacity];
        this.table = newTable;
        for (Node<K, V> i : oldTable) {
            if (i != null) {
                if (this.table[this.hesh(i.getKey())] != null) {
                    this.size--;
                    count--;
                }
                this.table[this.hesh(i.getKey())] = i;
                count++;
            }
            if (count == this.size) {
                break;
            }
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            Node<K, V>[] arrayNode = table;
            int expectedModCount = modeCount;
            int count = 0;
            int countSize = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modeCount) {
                    throw new ConcurrentModificationException();
                }
                return countSize < size;
            }

            @Override
            public K next() {
                K key = null;
                if (expectedModCount != modeCount) {
                    throw new ConcurrentModificationException();
                }
                if (countSize >= size) {
                    throw new NoSuchElementException();
                }
                for (int i = count; i < this.arrayNode.length; i++) {
                    if (this.arrayNode[i] != null) {
                        key = this.arrayNode[i].getKey();
                        count = ++i;
                        countSize++;
                        break;
                    }
                }
                return key;
            }
        };
    }


    private static final class Node<K, V> {
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", value=" + value + '}';
        }
    }

    @Override
    public String toString() {
        return "MyHashMap{" + "table=" + Arrays.toString(table) + ", size=" + size + '}';
    }
}
