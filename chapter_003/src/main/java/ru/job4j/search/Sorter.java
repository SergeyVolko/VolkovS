package ru.job4j.search;
// Добавить комментарий.

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class Sorter {
    // Данный конструктор не обязательный. Не явно конструктор и так создан.
    public Sorter() {

    }
    // В данный метод нужно добавить комментарий.

    /**
     * Метод возвращает значение отсортированной коллекци элементов UserPerson типа Set<UserPerson> без их дублирования.
     *
     * @param list - это колллекция типа List элементов UserPerson
     * @return Если в параметре list будут люди с различными именами и возрастами, то данный метод отсортирует их по возрастам.
     * На мой взгляд такая работа метода не логична. Если мы добавим несколько человек с различными именами, но с
     * одинаковыми возрастами, то метод вернет коллекцию с одним элементом и мы потеряем данные о других людях.
     * По логике данный метод должен сортировать
     * людей по возрасту, а следовательно мы должны использовать обычный список.
     * Исходный метод можно изменить. Имеем:
     * Set<User> sort (List<User> list) {
     * TreeSet<User> sortedList = new TreeSet<>();
     * sortedList.addAll(list);
     * return sortedList;
     * }
     */
    // Получим
    List<UserPerson> sortAge(List<UserPerson> list) {
        return list.stream().sorted(Comparator.comparingInt(UserPerson::getAge)).collect(Collectors.toList());
    }
    // В данный метод нужно добавить комментарий.

    /**
     * Именование данного метода не праввильное, должно быть sortNameLength
     * Данный метод сортирует передаваемую коллекцию по длине имени и возвращает ее отсортированной.
     *
     * @param list- это колллекция типа List элементов UserPerson
     * @return
     */
    List<UserPerson> sortNameLength(List<UserPerson> list) {
        return list.stream().sorted(Comparator.comparingInt(o -> o.getName().length())).collect(Collectors.toList());
    }

    /**
     * В данный метод нужно добавить комментарий.
     * Именование данного метода не праввильное, должно быть sortBoth
     * В методе создается два компаратора. Именование компараторов произведено с ошибкой.
     * Должно быть compare1 и compare2.
     * В первом компараторе происходит сранение по имени.
     * Во втором компараторе происходит сравнение по возрасту.
     * В методе sort происхощддит сортировка сперва по имени, а потом по возрасту.
     * Метод можно упростить. Имеем:
     * List<User> sortboth (List<User> list) {
     * Comparator<User> compar1 = new Comparator<User>() {
     *
     * @param list
     * @return
     * @Override public int compare (User o1, User o2) {
     * return o1.getName().compareTo(o2.getName());
     * }
     * };
     * Comparator<User> compar2 = new Comparator<User>() {
     * @Override public int compare (User o1, User o2) {
     * return o1.getAge() - o2.getAge();
     * }
     * };
     * list.sort(compar1.thenComparing(compar2));
     * return list;
     * }
     */
    // Получим упрощенный метод.
    List<UserPerson> sortBoth(List<UserPerson> list) {
        return list.stream().sorted((o1, o2) -> {
            final int rsl = o1.getName().compareTo(o2.getName());
            return (rsl != 0) ? (rsl) : (Integer.compare(o1.getAge(), o2.getAge()));
        }).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<UserPerson> userList = new ArrayList<>();
        userList.add(new UserPerson("Vovan", 17));
        userList.add(new UserPerson("Fenter", 13));
        userList.add(new UserPerson("Ldjfgkl", 8));
        userList.add(new UserPerson("Iod", 13));
        userList.add(new UserPerson("Vovan", 3));
        System.out.println(Arrays.toString(userList.toArray()));
        Sorter sorter = new Sorter();
        System.out.println(sorter.sortAge(userList));
        System.out.println(sorter.sortNameLength(userList));
        System.out.println(sorter.sortBoth(userList));
    }
}