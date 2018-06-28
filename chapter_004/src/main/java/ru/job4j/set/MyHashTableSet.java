package ru.job4j.set;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.06.2018
 */

import java.util.Arrays;

public class MyHashTableSet<E> {
    private E[] arrayHash;
    private int size;
    private int countElement = 0;

    public MyHashTableSet(E[] arrayHash) {
        this.size = arrayHash.length;
        this.arrayHash = arrayHash;
    }

    private int hashFunc(E key) {
        return Math.abs(key.hashCode() % this.size);
    }

    public boolean add(E key) {
        boolean flag = false;
        int index = this.hashFunc(key);
        if (this.countElement == this.size) {
            resize();
        }
        if (this.arrayHash[index] == null) {
            this.arrayHash[index] = key;
            this.countElement++;
            flag = true;
        }
        return flag;
    }

    private void resize() {
        E[] array = this.arrayHash;
        int indexNew;
        this.arrayHash = (E[]) new Object[getPrime(this.size)];
        this.size = this.arrayHash.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                indexNew = hashFunc(array[i]);
                if (this.arrayHash[indexNew] != null) {
                    this.countElement--;
                }
                this.arrayHash[indexNew] = array[i];
            }
        }
    }

    public boolean contains(E key) {
        boolean flag = false;
        int index = hashFunc(key);
        if (this.arrayHash[index].equals(key)) {
            flag = true;
        }
        return flag;
    }

    public boolean remove(E key) {
        boolean flag = false;
        int index = hashFunc(key);
        if (this.arrayHash[index] != null && this.arrayHash[index] == key) {
            this.arrayHash[index] = null;
            flag = true;
            countElement--;
        }
        return flag;
    }

    private int getPrime(int min) {
        int result;
        for (int j = min + 1; true; j++) {
            if (isPrime(j)) {
                result = j;
                break;
            }
        }
        return result;
    }

    private boolean isPrime(int n) {
        boolean flag = true;
        for (int j = 2; (j * j) <= n; j++) {
            if (n % j == 0) {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        return "MyHashTableSet{" + "arrayHash=" + Arrays.toString(arrayHash) + ", size=" + size + ", countElement=" + countElement + '}';
    }
}
