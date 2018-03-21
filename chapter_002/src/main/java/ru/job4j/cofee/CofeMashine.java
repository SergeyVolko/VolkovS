package ru.job4j.cofee;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 20.03.2018
 */

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


    public static void main(String[] args) {
        CofeMashine cofeMashine = new CofeMashine();
        int[] mass = cofeMashine.changes(50, 32);
        System.out.println(Arrays.toString(mass));
    }
}
