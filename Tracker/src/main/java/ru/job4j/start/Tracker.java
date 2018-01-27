package ru.job4j.start;
/*
 Методы  delete,findAll,findByName и т.д. реализованы с учетом того, что порядок добавления элементов
 item в tracker может быть по какой-то причине нарушен.
 */
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 21.01.2018
 */
import ru.job4j.models.*;
import java.util.*;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index < this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    public void replace(String id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                item.setId(id);
                this.items[i] = item;
                break;
            }
        }
    }

    public void delete(String id) {
        Item[] res = new Item[this.items.length];
        for (int i = 0; i < this.items.length; i++) {
            res[i] = items[i];
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                for (int j = i; j < items.length - 1; j++) {
                    res[j] = items[j + 1];
                }
                System.arraycopy(res, 0, items, 0, res.length);
                break;
            }
        }
    }

    public Item[] findAll() {
        Item[] itemsNoNull = null;
        int k = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                this.items[k] = this.items[i];
                if (i != k) {
                    this.items[i] = null;
                }
                k++;
            }
        }
        if (k > 0) {
            itemsNoNull = Arrays.copyOf(this.items, k);
        }
        return itemsNoNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsName = null;
        int k = 0;
        Item x;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                x = this.items[k];
                this.items[k] = this.items[i];
                if (i != k) {
                    this.items[i] = x;
                }
                k++;
            }
        }
        if (k > 0) {
            itemsName = Arrays.copyOf(this.items, k);
        }
        return itemsName;
    }

}
