package ru.job4j.set;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.06.2018
 */

public class ItemHesh {
    private int key;

    public ItemHesh(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "ItemHesh{" + "key=" + key + '}';
    }
}
