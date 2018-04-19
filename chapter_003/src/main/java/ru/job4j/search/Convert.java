package ru.job4j.search;
// Добавить комментарий.

import java.util.*;

public class Convert {
    /*
    Конструктор можно не определять.
    public Convert() {

    }
    */
    // Добавим комментарий к данному методу.

    /**
     * Данный метод преобразует двумерный массив в индексированный список.
     *
     * @param array
     * @return
     */
    List<Integer> makeList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        //Лучше использовать цикл в стиле foreach
        /*for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                list.add(array[i][j]);
        }*/
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    // Добавим комментарий к данному методу.

    /**
     * Данный метод в качестве параметров принимает список из целочисленных элементов и количество подмассивов.
     * Возвращаемое значение двумерный массив из целочисленных элементов.
     * Схема работы метода:
     * 1) Задается итератор для списка.
     * 2) Определяется количество элементов в одном подмассиве.
     * 3) Объявляется двумерный массив, где rws- количество подмассивов, cls-количество элементов в подмассиве
     * 4)С ипользованием двойного цикла и итератора все элементы списка записываются в двумерный массив, если список
     * заканчивается, то записываетс 0.
     * Работу данного метода можно упростить.
     *
     * @param list
     * @param rws
     * @return
     */
    /*
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);


        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())
                    array[i][j] = iterator.next();
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
     */
    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        //Можно обойтись и без итератора.
        //Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);
        int[][] array = new int[rws][cls];
        // Используем цикл в стиле foreach
        int index = 0;
        for (Integer i : list) {
            array[index / cls][index % cls] = i;
            index++;
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Convert convert = new Convert();
        int[][] massList = convert.makeArray(list, 3);
        for (int[] i : massList) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
