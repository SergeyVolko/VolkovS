package ru.job4j.set;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.06.2018
 */

import java.util.Arrays;

public class MyHashTableSet<E extends ItemHesh> {
    private E[] arrayHash;
    private int size;
    private int countElement = 0;

    public MyHashTableSet(E[] arrayHash) {
        this.size = arrayHash.length;
        this.arrayHash = arrayHash;
    }

    private int hashFunc(int key) {
        return key % this.size;
    }

    public boolean add(E item) {
        boolean flag = false;
        int index;
        if (this.countElement == this.size) {
            E[] array = this.arrayHash;
            int indexNew;
            this.arrayHash = (E[]) new ItemHesh[getPrime(this.size)];
            this.size = this.arrayHash.length;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    indexNew = hashFunc(array[i].getKey());
                    if (this.arrayHash[indexNew] != null) {
                        this.countElement--;
                    }
                    this.arrayHash[indexNew] = array[i];
                }
            }
        }
        index = hashFunc(item.getKey());
        if (this.arrayHash[index] == null) {
            this.arrayHash[index] = item;
            this.countElement++;
            flag = true;
        }
        return flag;
    }

    public boolean contains(E item) {
        boolean flag = false;
        int index = hashFunc(item.getKey());
        if (this.arrayHash[index].getKey() == item.getKey()) {
            flag = true;
        }
        return flag;
    }

    public boolean remove(E item) {
        boolean flag = false;
        int index = hashFunc(item.getKey());
        if (this.arrayHash[index] != null && this.arrayHash[index].getKey() == item.getKey()) {
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
