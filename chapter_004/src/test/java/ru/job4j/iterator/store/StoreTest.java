package ru.job4j.iterator.store;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.store.Info;
import ru.job4j.store.Store;


import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 6.07.2018
 */
public class StoreTest {
    List<Store.User> prev = new ArrayList<>();
    List<Store.User> cur = new ArrayList<>();

    @Before
    public void init() {
        prev.add(0, new Store.User(23432, "dsfd"));
        prev.add(1, new Store.User(6465, "jhttin"));
        prev.add(2, new Store.User(8764, "li;mmbg"));
        prev.add(3, new Store.User(231, "rewrhb"));
        prev.add(4, new Store.User(76, "o;imugg"));
        prev.add(5, new Store.User(31234, "ytdvttdh"));
        prev.add(6, new Store.User(31242, "hdvtrdvgy"));
        prev.add(7, new Store.User(98787, "jnhngugu"));
        prev.add(8, new Store.User(5445, "ytrvyty"));
        prev.add(9, new Store.User(7546454, "hgfvfygfhj"));
        cur.addAll(prev);
    }

    @Test
    public void whenDiffThenInfo() {
        Store store = new Store();
        Store.User user = new Store.User(8787, "hffbh");
        cur.add(10, user);
        Info info = store.diff(prev, cur);
        assertThat(info.getCountInsert(), is(1));
        System.out.println(info);
        cur.add(11, new Store.User(3423487, "hgfvfvh"));
        info = store.diff(prev, cur);
        assertThat(info.getCountInsert(), is(2));
        System.out.println(info);
        cur.set(0, new Store.User(23432, "lklklhhgg"));
        info = store.diff(prev, cur);
        assertThat(info.getCountReplace(), is(1));
        System.out.println(info);
        cur.remove(1);
        info = store.diff(prev, cur);
        assertThat(info.getCountDelete(), is(1));
        System.out.println(info);
    }

}
