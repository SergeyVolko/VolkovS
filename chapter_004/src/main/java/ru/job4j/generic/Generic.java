package ru.job4j.generic;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Generic<T> extends SuperClass<String> {

    public static void main(String[] args) {
        Generic<String> generic = new Generic<>();
        Map<Integer, String> map = new TreeMap<>();
        map.put(7, "first");
        map.put(7, "second");
        System.out.println(map);
    }
}

class SuperClass<T> {
    public SuperClass() {
        System.out.println(getClass());
        Class<T> t = (Class<T>) ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        try {
            T value = t.newInstance();
            System.out.println("string " + value.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
