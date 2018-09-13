package ru.job4j.pingpong.monitore;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 13.09.2018
 */
public class UserStorageTest {
    @Test
    public void whenUserStorageMetodsThenResult() {
        UserStorage userStorage = new UserStorage();
        userStorage.add(new User(1, 10));
        userStorage.add(new User(2, 20));
        userStorage.add(new User(3, 30));
        userStorage.add(new User(4, 40));
        int id = 1, value = 0;
        for (User u : userStorage.getUsers()) {
            assertThat(u.getId(), is(id++));
            value += 10;
            assertThat(u.getAmount(), is(value));
        }
        userStorage.transfer(1, 2, 10);
        assertThat(userStorage.getUser(1).getAmount(), is(0));
        assertThat(userStorage.getUser(2).getAmount(), is(30));
        userStorage.update(new User(1, 123));
        assertThat(userStorage.getUser(1).getAmount(), is(123));
        userStorage.delete(userStorage.getUser(1));
        assertThat(userStorage.getUser(1), is(nullValue()));
    }

}
