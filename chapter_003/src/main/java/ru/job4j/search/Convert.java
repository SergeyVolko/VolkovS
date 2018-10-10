package ru.job4j.search;
// Добавить комментарий.

import java.util.*;

import static java.util.stream.Collectors.*;

public class Convert {

    public List<Integer> toListOfArray(int[][] array) {
        return Arrays.stream(array).flatMapToInt(Arrays::stream).boxed().collect(toList());
    }

    public int[][] makeArray(List<Integer> list, int rws) {
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);
        int[][] array = new int[rws][cls];
        list.forEach(n -> {
            array[list.indexOf(n) / cls][list.indexOf(n) % cls] = n;
        });
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Convert convert = new Convert();
        for (int[] i : convert.makeArray(list, 6)) {
            System.out.println(Arrays.toString(i));
        }
    }
}
