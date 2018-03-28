package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.03.2018
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConvertList {
    public List<Integer> toList(int[][] array) {
        List<Integer> integerList = new ArrayList<>();
        for (int i[] : array) {
            for (int j : i) {
                integerList.add(j);
            }
        }
        return integerList;
    }


    public int[][] toArray(List<Integer> list, int rows) {
        int massLength = (list.size() / rows) + ((list.size() % rows > 0) ? 1 : 0);
        int[][] resultArray = new int[rows][massLength];
        int index = 0;
        for (Integer i : list) {
            resultArray[index / massLength][index % massLength] = i;
            index++;
        }
        return resultArray;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> integerList = new ArrayList<>();
        list.forEach(new Consumer<int[]>() {
            @Override
            public void accept(int[] ints) {
                for (int i : ints) {
                    integerList.add(i);
                }
            }
        });
        return integerList;
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
        List<Integer> integerList1 = convertList.convert(list);
        String expect = "[1, 2, 3, 4, 5, 6, 7, 8, 9]";
        String result = String.format("%s", integerList1);
        System.out.println(expect + " " + result);
    }
}
