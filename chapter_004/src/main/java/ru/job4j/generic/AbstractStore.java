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
        T nextElement;
        Iterator<T> iterator = this.simpleArray.iterator();
        while (iterator.hasNext()) {
            nextElement = iterator.next();
            if (nextElement != null && id.equals(nextElement.getId())) {
                this.simpleArray.setArray(index, model);
                flag = true;
                break;
            }
            index++;
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = false;
        T nextElement;
        int index = 0;
        Iterator<T> iterator = this.simpleArray.iterator();
        while (iterator.hasNext()) {
            nextElement = iterator.next();
            if (nextElement != null && id.equals(nextElement.getId())) {
                this.simpleArray.delete(index);
                flag = true;
                break;
            }
            index++;
        }
        return flag;
    }

    @Override
    public T findById(String id) {
        int index = 0;
        T nextElement;
        Iterator<T> iterator = this.simpleArray.iterator();
        T result = null;
        while (iterator.hasNext()) {
            nextElement = iterator.next();
            if (nextElement != null && id.equals(nextElement.getId())) {
                result = this.simpleArray.get(index);
                break;
            }
            index++;
        }
        return result;
    }

}
