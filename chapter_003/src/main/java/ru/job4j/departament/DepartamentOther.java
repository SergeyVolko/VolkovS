package ru.job4j.departament;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 9.05.2018
 */

import java.util.*;

public class DepartamentOther {
    private final List<String> stringList;
    private final List<List<String>> listList = new ArrayList<>();

    public DepartamentOther(List<String> mass) {
        this.stringList = mass;
        this.adding();
    }

    private void adding() {
        String element;
        int max = 0;
        int pos = 0;
        String str;
        for (int i = 0; i < this.stringList.size(); i++) {
            element = stringList.get(i);
            while (element.contains("\\")) {
                element = element.substring(0, element.lastIndexOf("\\"));
                if (!this.stringList.contains(element)) {
                    this.stringList.add(element);
                }
            }
            if (max < Integer.parseInt(element.substring(1))) {
                max = Integer.parseInt(element.substring(1));
            }
        }

        for (int i = 0; i < max; i++) {
            this.listList.add(new ArrayList<>());
        }

        for (int i = 0; i < this.stringList.size(); i++) {
            if (this.stringList.get(i).contains("\\")) {
                str = this.stringList.get(i).substring(1, this.stringList.get(i).indexOf("\\"));
            } else {
                str = this.stringList.get(i).substring(1);
            }
            pos = Integer.parseInt(str) - 1;
            this.listList.get(pos).add(this.stringList.get(i));
        }


        for (List<String> value : this.listList) {
            value.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        }
    }

    public List<String> sortPr() {
        List<String> listStr = new ArrayList<>();
        for (List<String> value : this.listList) {
            listStr.addAll(value);
        }
        return listStr;
    }

    public List<String> sortRev() {
        List<String> listRev = new ArrayList<>();
        for (int i = this.listList.size() - 1; i >= 0; i--) {
            listRev.addAll(this.listList.get(i));
        }
        return listRev;
    }

    @Override
    public String toString() {
        return "DepartamentOther{" + "stringList=" + stringList + ", listList=" + listList + '}';
    }
}
