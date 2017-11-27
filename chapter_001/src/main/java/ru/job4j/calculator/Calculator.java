package ru.job4j.calculator;
/**
 * Calculator.
 *
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.11.2017
 */
public class Calculator {

    private  double result;
    /**
     * Method add.
     * @param first
     * @param second
     * @return first plus second.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Method subtract.
     * @param first
     * @param second
     * @return first minus second.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    /**
     * Method div.
     * @param first
     * @param second
     * @return first div second.
     */
    public void div (double first, double second) {
        this.result = first / second;
    }
    /**
     * Method multiple.
     * @param first
     * @param second
     * @return first multiple second.
     */
    public void multiple (double first, double second) {
        this.result = first * second;
    }
    /**
     * Method getResult.
     * @return result first and second.
     */
    public  double getResult() {
        return this.result;
    }


}
