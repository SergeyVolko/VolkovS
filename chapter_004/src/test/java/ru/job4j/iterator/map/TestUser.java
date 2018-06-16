package ru.job4j.iterator.map;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 16.06.2018
 */

import org.junit.Test;
import ru.job4j.map.Calendar;
import ru.job4j.map.User;

import java.util.HashMap;
import java.util.Map;

public class TestUser {
    @Test
    public void whenCreateUserMapThenAnswer() {
        User userFirst = new User("Ivan", 6, new Calendar(3, 1, 1985));
        User userSecond = new User("Ivan", 6, new Calendar(3, 1, 1985));
        Map<User, Object> map = new HashMap<>();
        System.out.println(map.put(userFirst, new Object()));
        System.out.println(map.put(userSecond, new Object()));
        System.out.println(map);
    }
}
 /*
        Вывод получится следующий:
        {User{name='Ivan', children=6, birthday=Calendar{day=3, month=1, year=1985}}=java.lang.Object@73a8dfcc,
         User{name='Ivan', children=6, birthday=Calendar{day=3, month=1, year=1985}}=java.lang.Object@ea30797}
         В данном выводе сопоставлены ключ User с значением Object.
         Рассмотрим HashMap и объясним, что происходит при добавлении пар ключ-значение.
         1. Создаем объект map используя конструктор по умолчанию. Вот его реализация:
            public HashMap() {
               this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
           }
           где this.loadFactor - коэфициент заполнения карты, если количество добавленных элементов
           карты будет больше loadFactor умноженное на общее количество элементов, то карта будет
           расширена;
           DEFAULT_LOAD_FACTOR - константа определяющая коэфициент заполнения по умолчанию. По умолчанию
           коэфициент заполнения равен 0.75
         2. Запускается метод public V put(K key, V value). Вот его реализация:
            public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
            }
            В нашем случае этот метод принимает в качестве параметров ключ User и соответствующее этому
            ключу значение Object. Метод возвращает результат работы метода putVal(hash(key), key, value, false, true).
          3. В методе putVal(hash(key), key, value, false, true) в качестве параметра передается метод hash(key)-хеш-
             функция. Рассмотрим ее реализацию:
             static final int hash(Object key) {
                int h;
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
             }
             Передаваемым параметром в метод hesh служит объект key. Результатом возвращаемого значения служит выражение
             (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
             Если key равен null то возвращается 0, иначе выполняются следующие действия:
                -вычисляется hashCode объекта key и результат присваивается переменной h;
                -затем происходит беззнаковый побитовый сдвиг вправо на 16 битов для переменной h;
                -выполняется побитовая операция ^ (исключающее или для обоих частей выражения) и возвращается
                полученное значение.
            4. Рассмотрим реализацию метода putVal(hash(key), key, value, false, true) и опишем его работу для нашего
                случая.
                final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                    Node<K,V>[] tab; Node<K,V> p; int n, i;
                    if ((tab = table) == null || (n = tab.length) == 0)
                        n = (tab = resize()).length;
                    if ((p = tab[i = (n - 1) & hash]) == null)
                        tab[i] = newNode(hash, key, value, null);
                    else {
                        Node<K,V> e; K k;
                        if (p.hash == hash &&
                            ((k = p.key) == key || (key != null && key.equals(k))))
                            e = p;
                        else if (p instanceof TreeNode)
                            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                        else {
                            for (int binCount = 0; ; ++binCount) {
                                if ((e = p.next) == null) {
                                    p.next = newNode(hash, key, value, null);
                                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                        treeifyBin(tab, hash);
                                    break;
                                }
                                if (e.hash == hash &&
                                    ((k = e.key) == key || (key != null && key.equals(k))))
                                    break;
                                p = e;
                            }
                        }
                        if (e != null) { // existing mapping for key
                            V oldValue = e.value;
                            if (!onlyIfAbsent || oldValue == null)
                                e.value = value;
                            afterNodeAccess(e);
                            return oldValue;
                        }
                    }
                    ++modCount;
                    if (++size > threshold)
                        resize();
                    afterNodeInsertion(evict);
                    return null;
                }
                В данном методе объявляются три локальных поля:Node<K,V>[] tab; Node<K,V> p; int n, i;
                Разберем их по очереди:
                а) Проанализируем поле Node<K,V> p класса Node<K,V>, реализация класса Node<K, V> представлена ниже:
                // это статический класс реализующий внутренний интерфейс Entry интерфейса Map
                static class Node<K,V> implements Map.Entry<K,V> {
                    // поле, где предполагается хранить результат вычисления hesh функции
                    final int hash;
                    // поле - ключ
                    final K key;
                    //поле-значение
                    V value;
                    //ссылка на другой объект типа Node используется, для разрешения коллизий и создания цепочек
                    Node<K,V> next;
                    //конструктор
                    Node(int hash, K key, V value, Node<K,V> next) {
                        this.hash = hash;
                        this.key = key;
                        this.value = value;
                        this.next = next;
                    }
                    //методы get и toString
                    public final K getKey()        { return key; }
                    public final V getValue()      { return value; }
                    public final String toString() { return key + "=" + value; }
                    //метод переопределяющий хешкод для Node
                    public final int hashCode() {
                        return Objects.hashCode(key) ^ Objects.hashCode(value);
                    }
                    //метод изменяющий значение поля value и возвращающий старое значение value
                    public final V setValue(V newValue) {
                        V oldValue = value;
                        value = newValue;
                        return oldValue;
                    }
                    //метод переопределяющий equals для Node
                    public final boolean equals(Object o) {
                        if (o == this)
                            return true;
                        if (o instanceof Map.Entry) {
                            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                            if (Objects.equals(key, e.getKey()) &&
                                Objects.equals(value, e.getValue()))
                                return true;
                        }
                        return false;
                    }
                }
                б) Node<K,V>[] tab;- массив объектов Node
                в)int n, i;- примитивные типы.
                Вернемся к рассмотрению работы метода final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict)

                После объявления локальных переменных Node<K,V>[] tab; Node<K,V> p; int n, i; проверяется условие
                if ((tab = table) == null || (n = tab.length) == 0)- если значение table(массив transient Node<K,V>[] table; на котором
                базируется карта, объявлен на глобальном уровне HeshMap, в нашем случае не проинициализирован)
                присвоеное tab == null или длина tab присвоенная n равна 0, то условие в нашем случае
                выполняется и вычисляется выражение n = (tab = resize()).length;

                4.1 Рассмотрим реализацию метода resize():
                // метод возвращает массив типа Node<K,V>[]
                final Node<K,V>[] resize() {
                    //локальная переменная oldTab инициализируется текущем значением массива table
                    Node<K,V>[] oldTab = table;
                    //oldCap-поле инициализируемое условием, если oldTab == 0 то oldCap=0, иначе oldTab.length - длинна
                    //текущего массива. Значением данного поля является не обновленная емкость  массива table
                    int oldCap = (oldTab == null) ? 0 : oldTab.length;
                    //данному полю присваивается значение threshold, характерезующее значение при превышении которого
                    //массив table увеличивает свою емкость
                    int oldThr = threshold;
                    //поля определяющие новые значения емкости и threshold
                    int newCap, newThr = 0;
                    //проверка условия oldCap > 0 в нашем случае оно false т.к. oldTab == null
                    if (oldCap > 0) {
                        if (oldCap >= MAXIMUM_CAPACITY) {
                            threshold = Integer.MAX_VALUE;
                            return oldTab;
                        }
                        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                                 oldCap >= DEFAULT_INITIAL_CAPACITY)
                            newThr = oldThr << 1; // double threshold
                    }
                    // иначе проверяется условие oldThr > 0 и оно ложное т.к. threshold=0(не проинициализировано)
                    else if (oldThr > 0) // initial capacity was placed in threshold
                        newCap = oldThr;
                    // иначе в нашем случе выполняются операторы newCap = DEFAULT_INITIAL_CAPACITY;
                    // newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
                    else {               // zero initial threshold signifies using defaults
                        //новая емкость состащая из DEFAULT_INITIAL_CAPACITY = 16 элементов
                        newCap = DEFAULT_INITIAL_CAPACITY;
                        //емкость расширения массива состаяющая из 16*0.75=12 элементов
                        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
                    }
                    //данное условие не выполняется т.к.newThr > 0
                    if (newThr == 0) {
                        float ft = (float)newCap * loadFactor;
                        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                                  (int)ft : Integer.MAX_VALUE);
                    }
                    //емкости расширения массива table присваиваем 12
                    threshold = newThr;
                    @SuppressWarnings({"rawtypes","unchecked"})
                        // создаем новый массив с емкостью newCap=16
                        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
                    //теперь массив table ссылается на пустой массив newTab
                    table = newTab;
                    //проверка условия oldTab != null в нашем случае false
                    if (oldTab != null) {
                        for (int j = 0; j < oldCap; ++j) {
                            Node<K,V> e;
                            if ((e = oldTab[j]) != null) {
                                oldTab[j] = null;
                                if (e.next == null)
                                    newTab[e.hash & (newCap - 1)] = e;
                                else if (e instanceof TreeNode)
                                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                                else { // preserve order
                                    Node<K,V> loHead = null, loTail = null;
                                    Node<K,V> hiHead = null, hiTail = null;
                                    Node<K,V> next;
                                    do {
                                        next = e.next;
                                        if ((e.hash & oldCap) == 0) {
                                            if (loTail == null)
                                                loHead = e;
                                            else
                                                loTail.next = e;
                                            loTail = e;
                                        }
                                        else {
                                            if (hiTail == null)
                                                hiHead = e;
                                            else
                                                hiTail.next = e;
                                            hiTail = e;
                                        }
                                    } while ((e = next) != null);
                                    if (loTail != null) {
                                        loTail.next = null;
                                        newTab[j] = loHead;
                                    }
                                    if (hiTail != null) {
                                        hiTail.next = null;
                                        newTab[j + oldCap] = hiHead;
                                    }
                                }
                            }
                        }
                    }
                    //возвращается пустой увеличенный массив на который ссылается table, но это при добавлении первого
                    //элемента Node
                    return newTab;
                }
              Продолжим рассмотрение метода final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict)
              расположенного выше.
               n = (tab = resize()).length;-увеличели размер массива table до 16
               Затем проверяем условие if ((p = tab[i = (n - 1) & hash]) == null):
                    a)вычисляем выражение (n - 1) & hash, в двоичном представлении это будет примерно выглядеть так
                    0000 0000 1111 & 0011 1010 0011 = 0000 0000 0011 = 5, полученное значение присваиваем i и получается
                    индекс элемента массива tab[i]
                    б) значение элемента массива tab по индексу присваиваем переменной p и проверяем на равенство null
                    в) в нашем случае логическое выражение равно true
               После проверки предыдущего условия выполняется оператор
                tab[i] = newNode(hash, key, value, null);- где newNode метод
                    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
                        return new Node<>(hash, key, value, next);
                    } добавляющий новый элемент в массив tab[i]
                 Дальше выполнится последовательность операторов:
                 ++modCount;-оператор изменяющий количество изменений в карте
                    if (++size > threshold)//если инкремент size больше threshold то увеличиваем размер массива table
                        resize();
                     //void afterNodeInsertion(boolean evict) { }-пустой метод
                    afterNodeInsertion(evict);
                    // возвращаемое значение null
                    return null;
             5. Рассмотрим, что происходит при добавлении другого елемента в карту с одинаковыми полями, что и у предыдущего.
               //Это условие и выражение после него не выполняются, т.к. table проинициализирован
               if ((tab = table) == null || (n = tab.length) == 0)
                        n = (tab = resize()).length;
               // Это условие выполняется, т. к. hesh функции у первого добавленного и второго добавляемого элемента
               //разные и поэтому второй элемент добавится в массив table под другим индексом, коллизий не возникает
               if ((p = tab[i = (n - 1) & hash]) == null)
                        tab[i] = newNode(hash, key, value, null);
               Дальше выполнится последовательность операторов:
                 ++modCount;-оператор изменяющий количество изменений в карте
                    if (++size > threshold)//если инкремент size больше threshold то увеличиваем размер массива table
                        resize();
                     //void afterNodeInsertion(boolean evict) { }-пустой метод
                    afterNodeInsertion(evict);
                    // возвращаемое значение null
                    return null;

               Вывод:HashMap базируется на массиве типа Node table. В нашем примере при добавлении эквивалентных
               элементов без переопределенных heshCode и equalse происходит их запись в массив table на разные позиции.
               Возникновение коллизий не искдючено.
         */