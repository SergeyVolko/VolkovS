package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 30.04.2018
 */

import ru.job4j.departament.Departament;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartamentTest {

    final private void action(Departament departament) {
        departament.addDep("K1\\SK1");
        departament.addDep("K1\\SK2");
        departament.addDep("K2\\SK1");
        departament.addDep("K2\\SK1\\SSK2");
        departament.addDep("K1\\SK1\\SSK1");
        departament.addDep("K2");
        departament.addDep("K1");
        departament.addDep("K1\\SK1\\SSK2");
        departament.addDep("K2\\SK1\\SSK1");
    }

    @Test
    public void whenSortPrThenPrSort() {
        String expect = "[K1, K1\\SK1, K1\\SK1\\SSK1, K1\\SK1\\SSK2, K1\\SK2, K2, K2\\SK1, K2\\SK1\\SSK1, K2\\SK1\\SSK2]";
        Departament departament = new Departament();
        this.action(departament);
        assertThat(departament.sortPr(departament.getDepSet()).toString(), is(expect));
    }

    @Test
    public void whenSortRevThenPrSort() {
        String expect = "[K2, K2\\SK1, K2\\SK1\\SSK1, K2\\SK1\\SSK2, K1, K1\\SK1, K1\\SK1\\SSK1, K1\\SK1\\SSK2, K1\\SK2]";
        Departament departament = new Departament();
        this.action(departament);
        assertThat(departament.sortRev(departament.getDepSet()).toString(), is(expect));
    }
}
