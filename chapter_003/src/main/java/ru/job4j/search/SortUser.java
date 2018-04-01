package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.03.2018
 */

import java.util.*;

public class SortUser {

    public Set<UserPerson> sort(List<UserPerson> userList) {
        Set<UserPerson> userSet = new TreeSet<>();
        userSet.addAll(userList);
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
}
