package ru.job4j.condition;

import static org.hamcrest.number.IsCloseTo.closeTo;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {
   @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
       // Создаем три объекта класса Point.
       Point a = new Point(0, 0);
       Point b = new Point(2, 0);
       Point c = new Point(0, 2);
       // Создаем объект класса Triangle.
       Triangle triangle = new Triangle(a, b, c);
       // Вычисляем площадь.
       double result = triangle.area();
       // Задаем ожидаемый результат.
       double expected = 2D;
       // Проверяем результат и ожидаемое значение.
       assertThat(result, closeTo(expected, 0.1));
   }
}
