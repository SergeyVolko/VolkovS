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
    private List<Item> itemList = new ArrayList<>();
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.itemList.add(item);
        return item;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : this.itemList) {
            if (item.getId().equals(id)) {
                result = item;
                result.setId(id);
                break;
            }
        }
        return result;
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public List<Item> getAll() {
        return this.itemList;
    }

    public void replace(String id, Item item) {
        int index;
        for (Item itemL : this.itemList) {
            if (itemL.getId().equals(id)) {
                index = this.itemList.indexOf(itemL);
                this.itemList.remove(index);
                item.setId(id);
                this.itemList.add(index, item);
                break;
            }
        }
    }

    public void delete(String id) {
        int index;
        for (Item item : this.itemList) {
            if (item != null && item.getId().equals(id)) {
                index = itemList.indexOf(item);
                itemList.remove(index);
                break;
            }
        }
    }


    public List<Item> findByName(String key) {
        List<Item> listName = new ArrayList<>();
        for (Item item : this.itemList) {
            if (item.getName().equals(key)) {
                listName.add(item);
            }
        }
        return listName;
    }

}
