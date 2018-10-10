package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.03.2018
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertList {
    public List<Integer> toList(int[][] array) {
        return Arrays.stream(array).flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }


    public int[][] toArray(List<Integer> list, int rows) {
        int cls = list.size() / rows + (list.size() % rows == 0 ? 0 : 1);
        int[][] array = new int[rows][cls];
        list.forEach(n -> {
            array[list.indexOf(n) / cls][list.indexOf(n) % cls] = n;
        });
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        return list.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ConvertList convertList = new ConvertList();
        int[][] mass = {{1, 2, 3}, {4, 5, 6}, {7}};
        List<Integer> integerList = convertList.toList(mass);
        System.out.println(integerList);
        List<Integer> integers = integerList;
        int[][] massList = convertList.toArray(integers, 3);
        for (int[] i : massList) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3, 4});
        list.add(new int[]{5, 6, 7});
        list.add(new int[]{8, 9});
        System.out.println(convertList.convert(list));

    }
}
