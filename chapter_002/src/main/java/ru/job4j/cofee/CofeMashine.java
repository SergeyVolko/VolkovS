package ru.job4j.cofee;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 20.03.2018
 */

import java.io.*;
import java.util.Arrays;

public class CofeMashine {

    public int[] changes(int value, int price) {
        int sdacha;
        int pos = 0;
        int[] nominal = {10, 5, 2, 1};
        sdacha = value - price;
        int[] massSdacha = new int[sdacha / nominal[1] + 3];
        for (int i = 0; i < nominal.length; i++) {
            if (sdacha >= nominal[i]) {
                massSdacha[pos++] = nominal[i];
                sdacha -= nominal[i--];
            }
        }
        return Arrays.copyOf(massSdacha, pos);

    }
}

class Gen<T extends Number> {
    T[] ob;

    Gen(T[] ob) {
        this.ob = ob;
    }

    public T[] getOb() {
        return this.ob;
    }

    public void showOb() {
        System.out.println(this.ob.getClass().getName());
    }

    public double average() {
        double sum = 0;
        for (int i = 0; i < ob.length; i++) {
            sum += ob[i].doubleValue();
        }
        return sum / ob.length;
    }

    boolean sumAvg(Gen<?> ob) {
        if (this.average() == ob.average()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
       Integer[] integer = {1, 2, 3, 4, 5};
       Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
       Float[] floats = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
       Gen<Integer> integerGen = new Gen<>(integer);
       Gen<Double> doubleGen = new Gen<>(doubles);
       Gen<Float> floatGen = new Gen<>(floats);

       if (integerGen.sumAvg(doubleGen)) {
           System.out.println("ineger == double");
       } else {
           System.out.println("integer != double");
       }

    }
}
