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
   @Test
   public void whenDistanceDiffPointsThen10() {
      // Создаем два объекта класса Point.
      Point left = new Point(0, 0);
      Point right = new Point(10, 0);
      // Вычисляем расстояние между точками.
      double rsl = left.distanceTo(right);
      // Ожидаемый результат равен 10 и он в методе closeTo.
      // Проверим результат и ожидаемое значение.
      assertThat(rsl, closeTo(10, 0.01));
   }
}
