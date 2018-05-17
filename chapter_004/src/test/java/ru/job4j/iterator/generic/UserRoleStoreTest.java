package ru.job4j.iterator.generic;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 17.05.2018
 */

import org.junit.Test;
import ru.job4j.generic.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserRoleStoreTest {
    @Test
    public void whenAddReplaceDeleteFindUserAndRoleThenAdding() {
        UserStore userStore = new UserStore(new SimpleArray<>(new User[10]));
        RoleStore roleStore = new RoleStore(new SimpleArray<>(new Role[10]));
        userStore.add(new User("user1"));
        roleStore.add(new Role("role1"));
        assertThat("user1", is(userStore.findById("user1").getId()));
        assertThat("role1", is(roleStore.findById("role1").getId()));
        userStore.replace("user1", new User("user2"));
        roleStore.replace("role1", new Role("role2"));
        assertThat("user2", is(userStore.findById("user2").getId()));
        assertThat("role2", is(roleStore.findById("role2").getId()));
        userStore.delete("user2");
        roleStore.delete("role2");
        assertThat(null, is(userStore.findById("user2")));
        assertThat(null, is(roleStore.findById("role2")));
    }
}
