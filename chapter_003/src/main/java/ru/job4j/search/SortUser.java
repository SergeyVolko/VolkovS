package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.03.2018
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<UserPerson> sort(List<UserPerson> userList) {
        Set<UserPerson> userSet = new TreeSet<>();
        userSet.addAll(userList);
        return userSet;
    }


    public static void main(String[] args) {
        List<UserPerson> userPersonList = new ArrayList<>();
        userPersonList.add(new UserPerson(23, "Alex"));
        userPersonList.add(new UserPerson(14, "Ivan"));
        userPersonList.add(new UserPerson(34, "Oleg"));
        userPersonList.add(new UserPerson(11, "Stepan"));
        Set<UserPerson> userPersonSet = new SortUser().sort(userPersonList);
        System.out.println(userPersonSet);
    }
}
