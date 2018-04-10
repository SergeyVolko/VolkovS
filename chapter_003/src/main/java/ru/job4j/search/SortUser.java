package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.03.2018
 */

import java.util.*;

public class SortUser {

    public Set<UserPerson> sort(List<UserPerson> userList) {
        Set<UserPerson> userSet = new TreeSet<>(userList);
        return userSet;
    }

    public List<UserPerson> sortNameLength(List<UserPerson> userList) {
        List<UserPerson> personList = new ArrayList<>();
        personList.addAll(userList);
        personList.sort(new Comparator<UserPerson>() {
            @Override
            public int compare(UserPerson o1, UserPerson o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return personList;
    }

    public List<UserPerson> sortByAllFields(List<UserPerson> userPersonList) {
        List<UserPerson> personList = new ArrayList<>();
        personList.addAll(userPersonList);
        personList.sort(new Comparator<UserPerson>() {
            @Override
            public int compare(UserPerson o1, UserPerson o2) {
                final int rsl = o1.getName().compareTo(o2.getName());
                return (rsl != 0) ? (rsl) : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return personList;
    }

    public static void main(String[] args) {
        System.out.println("Ivanov".compareTo("Ivanov"));
        System.out.println("Ivanov".compareTo("Ivanova"));
        System.out.println("Petrov".compareTo("Ivanova"));
        System.out.println("Petrov".compareTo("Patrov"));
        System.out.println("Patrova".compareTo("Petrov"));
        String str1 = "Я буду хорошим программистом!";
        String str2 = "Я буду хорошим программистом!";
        String str3 = "Я буду хорошим ";

        int result = str1.compareTo(str2);
        System.out.println(result);

        result = str2.compareTo(str3);
        System.out.println(result);
        result = str3.compareTo(str1);
        System.out.println(result);

        System.out.println(Character.compare('п', 'а'));

        List<String> stringList = new ArrayList<>();
        stringList.add("Ivanov");
        stringList.add("Ivanova");
        stringList.add("Petrov");
        stringList.add("Patrov");
        stringList.add("Patrova");
        stringList.add("Ivanov");
        stringList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(stringList);
    }
}
