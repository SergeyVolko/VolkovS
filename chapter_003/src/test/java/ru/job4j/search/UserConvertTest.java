package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 29.03.2018
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenProcessThenHashMap() {
        String except = "Ivan Nikolay";
        UserConvert userConvert = new UserConvert();
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Ivan", "Moscow"));
        userList.add(new User(4, "Nikolay", "Kursk"));
        HashMap<Integer, User> hashMap = userConvert.process(userList);
        String result = hashMap.get(1).getName() + " " + hashMap.get(4).getName();
        assertThat(result, is(except));
    }
}
