package ru.job4j.array;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 23.12.2017
 */
public class Matrix {
    int[][] multiple(int size) {
        int[][] mass = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mass[i][j] = (i + 1) * (j + 1);
            }
        }
        return mass;
    }
    /*
    public static void main(String[] args){
        Matrix matrix = new Matrix();
        int[][] mass = matrix.multiple(10);
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.print(mass[i][j]+" ");
            }
            System.out.println();
        }
    }
    */
}
