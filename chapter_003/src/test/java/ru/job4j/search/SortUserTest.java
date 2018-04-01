package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 31.03.2018
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;

public class SortUserTest {
    @Test
    public void whenSortThenSortedList() {
        String expect = "[UserPerson{age=11, name='Stepan'}, UserPerson{age=14, name='Ivan'}, UserPerson{age=23, name='Alex'}, UserPerson{age=34, name='Oleg'}]";
        List<UserPerson> userPersonList = new ArrayList<>();
        userPersonList.add(new UserPerson(23, "Alex"));
        userPersonList.add(new UserPerson(14, "Ivan"));
        userPersonList.add(new UserPerson(34, "Oleg"));
        userPersonList.add(new UserPerson(11, "Stepan"));
        Set<UserPerson> userPersonSet = new SortUser().sort(userPersonList);
        String result = userPersonSet.toString();
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenSortNameLengthThenSortedList() {
        String expect = "[UserPerson{age=14, name='Ivan'}, UserPerson{age=11, name='Stepa'}, UserPerson{age=23, name='Alexas'}, UserPerson{age=34, name='Olegrich'}]";
        List<UserPerson> userPersonList = new ArrayList<>();
        userPersonList.add(new UserPerson(23, "Alexas"));
        userPersonList.add(new UserPerson(14, "Ivan"));
        userPersonList.add(new UserPerson(34, "Olegrich"));
        userPersonList.add(new UserPerson(11, "Stepa"));
        List<UserPerson> userPersonSort = new SortUser().sortNameLength(userPersonList);
        String result = userPersonSort.toString();
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenSortByAllFieldsThenSortedList() {
        String expect = "[UserPerson{age=25, name='Иван'}, UserPerson{age=30, name='Иван'}, UserPerson{age=20, name='Сергей'}, UserPerson{age=25, name='Сергей'}]";
        List<UserPerson> userPersonList = new ArrayList<>();
        userPersonList.add(new UserPerson(25, "Сергей"));
        userPersonList.add(new UserPerson(30, "Иван"));
        userPersonList.add(new UserPerson(20, "Сергей"));
        userPersonList.add(new UserPerson(25, "Иван"));
        List<UserPerson> userPersonSort = new SortUser().sortByAllFields(userPersonList);
        String result = userPersonSort.toString();
        Assert.assertThat(result, is(expect));
    }
}
