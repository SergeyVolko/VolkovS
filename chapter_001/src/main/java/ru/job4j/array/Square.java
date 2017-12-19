package ru.job4j.array;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 19.12.2017
 */
public class Square {

    public int[] calculate(int bound) {
        int[] rsl = new int[bound];
        for (int i = 0; i < rsl.length; i++) {
            rsl[i] = (i+1)*(i+1);
        }
        return rsl;
    }
    /*
        public static void main(String[] args){
        Square square = new Square();
        int[] result = square.calculate(3);
        for(int i= 0; i<3; i++ )
        System.out.println(result[i]);
    }*/
}
