package ru.job4j.generic;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 17.05.2018
 */

import java.util.Iterator;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean flag = false;
        int index = 0;
        for (T element : this.simpleArray.getArray()) {
            if (element != null && element.getId().equals(id)) {
                this.simpleArray.setArray(index, model);
                flag = true;
            }
            index++;
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = false;
        int index = 0;
        for (T element : this.simpleArray.getArray()) {
            if (element != null && element.getId().equals(id)) {
                this.simpleArray.delete(index);
                flag = true;
            }
            index++;
        }
        return flag;
    }

    @Override
    public T findById(String id) {
        int index = 0;
        T result = null;
        for (T element : this.simpleArray.getArray()) {
            if (element != null && element.getId().equals(id)) {
                result = this.simpleArray.get(index);
            }
            index++;
        }
        return result;
    }

}
