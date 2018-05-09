package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 9.05.2018
 */

import org.junit.Test;
import ru.job4j.departament.DepartamentOther;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartamentOtherTest {

    private List<String> action(List<String> list) {
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        return list;
    }

    @Test
    public void whenSortPrThenPrSort() {
        String expect = "[K1, K1\\SK1, K1\\SK1\\SSK1, K1\\SK1\\SSK2, K1\\SK2, K2, K2\\SK1, K2\\SK1\\SSK1, K2\\SK1\\SSK2]";
        List<String> listDepartament = new ArrayList<>();
        listDepartament = this.action(listDepartament);
        DepartamentOther departamentOther = new DepartamentOther(listDepartament);
        assertThat(departamentOther.sortPr().toString(), is(expect));
    }

    @Test
    public void whenSortRevThenPrSort() {
        String expect = "[K2, K2\\SK1, K2\\SK1\\SSK1, K2\\SK1\\SSK2, K1, K1\\SK1, K1\\SK1\\SSK1, K1\\SK1\\SSK2, K1\\SK2]";
        List<String> listDepartament = new ArrayList<>();
        listDepartament = this.action(listDepartament);
        DepartamentOther departamentOther = new DepartamentOther(listDepartament);
        assertThat(departamentOther.sortRev().toString(), is(expect));
    }
}
