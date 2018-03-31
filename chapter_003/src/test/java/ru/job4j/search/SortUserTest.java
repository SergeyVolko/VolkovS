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
}
