package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.11.2017
 */
public class CalculatorTest {
    /**
     * Test add.
     */@Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test subtract.
     */@Test
    public void whenSubtractTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     * Test div.
     */@Test
    public void whenDivSixDelitThreeThenTwo() {
        Calculator calc = new Calculator();
        calc.div(6D, 3D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test multiple.
     */@Test
    public void whenMultipleTwoMultThreeThenSix() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 3D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }
}
