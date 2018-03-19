package ru.job4j.cofee;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 20.03.2018
 */

import java.util.Arrays;

public class CofeMashine {

    public int[] changes(int value, int price) throws WrongMoneyException {
        int sdacha;
        int sum;
        int pos = 0;
        int[] nominal = {10, 5, 2, 1};
        int dlinaMass = 0;
        if (value >= price && value > 0 && price >= 0) {
            sdacha = value - price;
            sum = sdacha;
            for (int i = 0; i < nominal.length; i++) {
                dlinaMass += sdacha / nominal[i];
                sdacha %= nominal[i];
                if (sdacha == 0) break;
            }

            int[] massSdacha = new int[dlinaMass];
            for (int i = 0; i < massSdacha.length; i++) {
                if (sum / nominal[pos] > 0) {
                    massSdacha[i] = nominal[pos];
                    sum -= nominal[pos];
                } else {
                    pos++;
                    i--;
                }
            }
            return massSdacha;
        } else {
            throw new WrongMoneyException("No money!");
        }
    }

    public void init(int value, int price) {

        try {
            System.out.println(Arrays.toString(this.changes(value, price)));
        } catch (WrongMoneyException e) {
            System.out.println("No money");
        }

    }

    public static void main(String[] args) {
        CofeMashine cofeMashine = new CofeMashine();
        cofeMashine.init(-123, 345);
        cofeMashine.init(63, 45);

    }
}
