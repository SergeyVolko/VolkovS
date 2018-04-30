package ru.job4j.departament;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 30.04.2018
 */

import java.util.*;

public class Departament {
    final private List<String> depSet = new ArrayList<>();

    public boolean addDep(String name) {
        return this.depSet.add(name);
    }

    public List<String> sortPr(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    public List<String> sortRev(List<String> list) {
        this.sortPr(list);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                final String sub1 = (o1.contains("\\")) ? (o1.substring(0, o1.indexOf('\\'))) : (o1);
                final String sub2 = (o2.contains("\\")) ? (o2.substring(0, o2.indexOf('\\'))) : (o2);
                return sub2.compareTo(sub1);
            }
        });
        return list;
    }

    public List<String> getDepSet() {
        return depSet;
    }

    @Override
    public String toString() {
        return "Departament{" + "depSet=" + depSet + '}';
    }
}

