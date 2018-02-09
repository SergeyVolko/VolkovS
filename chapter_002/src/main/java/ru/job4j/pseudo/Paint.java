package ru.job4j.pseudo;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 09.02.2018
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
