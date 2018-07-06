package ru.job4j.store;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 6.07.2018
 */

public class Info {
    private int countInsert;
    private int countDelete;
    private int countReplace;

    Info(int countDelete, int countInsert, int countReplace) {
        this.countInsert = countInsert;
        this.countDelete = countDelete;
        this.countReplace = countReplace;
    }

    public int getCountInsert() {
        return countInsert;
    }

    public int getCountDelete() {
        return countDelete;
    }

    public int getCountReplace() {
        return countReplace;
    }

    @Override
    public String toString() {
        return "Info{" + "count_insert=" + countInsert + ", count_delete=" + countDelete + ", count_replace=" + countReplace + '}';
    }
}
