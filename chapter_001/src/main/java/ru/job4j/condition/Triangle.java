package ru.job4j.condition;

public class Triangle {
    // Поля класса Triangle типа Point.
    // Класс Point доступен в классе Triangle.
    private Point a;
    private Point b;
    private Point c;

    /**
     * Конструктор. Используется при создании объетов типа Triangle.
     * @param a
     * @param b
     * @param c
     */
    public Triangle(Point a, Point b, Point c) {
        //Ссылочным переменным класса Triangle присваиваются копии ссылок на объекты (точки a, b, c).
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод distance.
     * В качестве параметров принимает копии ссылок на 2 объекта (точки).
     * По ссылке left ( левая точка) типа Point вызывается метод класса Point distanceTo, в который в
     * качестве параметра передается ссылка right (правая точка) класса Point.
     * Затем, при помощи метода distanceTO вычисляется расстояние между точками, и полученное значение возвращается
     * методом distance.
     * @param left
     * @param right
     * @return
     */
    public double distance(Point left, Point right) {
        return left.distanceTo(right);
    }

    /**
     * Метод period.
     * В качестве параметров принимает значения сторон треугольника типа double и возвращает его полупериметр.
     * @param ab
     * @param bc
     * @param ac
     * @return
     */
    public double period(double ab, double bc, double ac) {
        return (ab + bc + ac) / 2;
    }

    /**
     * Метод area().
     * Вычисляет площадь треугольника.
     * @return
     */
    public double area() {
        // Объявляется и инициализируется -1 переменная rsl типа double
        double rsl = -1;
        // Вычисляются расстояния между точками a и b, a и c, b и c.
        // Строчки this.distance(this.a,this.b), this.distance(this.b,this.c),this.distance(this.a,this.c)
        // означают, что через ссылку this на объект типа Triangle вызывается метод данного объекта distance.
        // Метод distance в качестве параметров принимает ссылки на точки a, b и c объекта типа Triangle,
        // на что указывает ключевое слово this и вычисляет длины сторон.
        double ab = this.distance(this.a, this.b);
        double bc = this.distance(this.b, this.c);
        double ac = this.distance(this.a, this.c);
        // Вычисление полупериметра. Параметрами метода period являются длины сторон треугольника.
        double p = this.period(ab, bc, ac);
        // Условие, если this.exist(ab,bc,ac)=true , то вычислится площадь треугольника.
        if (this.exist(ab, bc, ac)) {
            rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }

    /**
     * Метод exist.
     * Определяет по длинам прямых ab, bc и cd существование треугольника.
     * @param ab
     * @param bc
     * @param ac
     * @return
     */
    private boolean exist(double ab, double bc, double ac) {
        return (ab + bc > ac) && (ab + ac > ab) && (bc + ac > ab) ? true : false;
    }
}
