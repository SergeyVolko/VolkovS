package  ru.job4j.array;
//Здесь мы описываем работу класса ArrayReturn.
public class ArrayReturn {
    Integer g = new Integer(5);
    //Объявляем ссылку на массив целчисленных значений. Данная ссылка не ссылается ни на какой массив.
    private int[] values;
    // Данный метод принимает в качестве параметра копию ссылки на массив целочисленных значений и
    // возвращает ту же самую ссылку, которую и принимал в качестве параметра.
    public int[] sort(int[] that) {
        //В теле данного метода мы ссылочной переменной values класса ArrayReturn присваиваем значение ссылки
        // that.
        this.values = that;
        return that;
    }
    //Данный метод выводит на консоль 0 элемент массива по ссылке values класса ArrayReturn.
    public void echo() {
        System.out.println(this.values[0]);
    }
    // создаем метод main
    public static void main(String[] args) {
        // Создаем объект ar класса ArrayReturn
        ArrayReturn ar = new ArrayReturn();
        //Инициализируем массив целочисленных значении с одним индексом. Т. е. его нулевой индекс равен 1.
        final int[] immutable = new int[] {1};
        // Выполняется метод sort объекта ar, в результате работы которого ссылка value будет ссылаться
        //на массив immutable.
        // Метод sort также возвращает ссылку на массив immutable и присваивает ее ссылке ri.
        // Т. о. ссылки values и ri ссылаются на один массив по ссылке immutable.
        // значение нулевого элемента по ссылке ri, values равно 1
        final int[] ri = ar.sort(immutable);
        // нулевому элементу массива по ссылке ri присваивается -1.
        ri[0] = -1;
        // Метод echo выведет на консоль значение нулевого элемента по ссылке values класса ArrayReturn.
        //Т. к. values и ri ссылаются на одинаковые области памяти, то изменение значения 0 элемента
        // по ссылке ri на -1, приведет к тому , что значение 0 элемента по ссылке values также будет
        // равно -1. Т. е. на консоль выведется значение 0 элемента массива по ссылке values равное -1.
        ar.echo();
    }
}
