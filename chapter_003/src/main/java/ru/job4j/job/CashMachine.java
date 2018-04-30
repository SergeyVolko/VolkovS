package ru.job4j.job;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 30.04.2018
 */

import java.util.*;

public class CashMachine {
    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
        List<List<Integer>> listList = new ArrayList<>();
        int[] array = new int[values.length];
        int sum = 0;
        int index = 0;
        int count = 0;
        while (index < values.length) {
            if (sum + values[index] <= note) {
                count++;
                sum += values[index];
            } else {
                array[index] = count;
                count = 0;
                index++;
            }
        }
        if (array[0] == note) {
            while (true) {
                List<Integer> list = new ArrayList<>();
                for (int k = 0; k < array.length; k++) {
                    for (int j = 0; j < array[k]; j++) {
                        list.add(values[k]);
                    }
                }
                listList.add(list);
                for (int i = 1; i < array.length; i++) {
                    if (array[0] >= values[i]) {
                        array[0] -= values[i];
                        array[i]++;
                        break;
                    } else {
                        array[0] += values[i] * array[i];
                        array[i] = 0;
                    }
                }

                if (array[0] == note) {
                    break;
                }

            }
        } else {
            int x;
            for (int i = 0; i < array.length / 2; i++) {
                x = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = x;
                x = values[i];
                values[i] = values[array.length - 1 - i];
                values[array.length - 1 - i] = x;
            }
            while (true) {
                List<Integer> list = new ArrayList<>();
                System.out.println(Arrays.toString(array));
                for (int k = 0; k < array.length; k++) {
                    for (int j = 0; j < array[k]; j++) {
                        list.add(values[k]);
                    }
                }
                listList.add(list);
                for (int i = 1; i < array.length; i++) {
                    if (array[i] > 0) {
                        array[i - 1] += values[i] / values[i - 1];
                        array[i]--;
                        break;
                    }
                }
                if (array[0] == note) {
                    List<Integer> list1 = new ArrayList<>();
                    System.out.println(Arrays.toString(array));
                    for (int k = 0; k < array.length; k++) {
                        for (int j = 0; j < array[k]; j++) {
                            list1.add(values[k]);
                        }
                    }
                    listList.add(list1);
                    break;
                }
            }
        }

        return listList;
    }


    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine(new int[]{1, 5, 10});
        cashMachine.exchange(10);
        System.out.println("==========================================");
        CashMachine cashMachine1 = new CashMachine(new int[]{10, 5, 1});
        cashMachine1.exchange(10);
    }
}