package ru.job4j.pingpong.monitore;

import net.jcip.annotations.ThreadSafe;

import java.util.*;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 13.09.2018
 */
@ThreadSafe
public class UserStorage {
    private Set<User> users = new TreeSet<>(new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.getId() - o2.getId();
        }
    });

    public synchronized boolean add(User user) {
        return users.add(user);
    }

    public synchronized boolean update(User user) {
        return users.remove(user) && users.add(user);
    }

    public Set<User> getUsers() {
        return users;
    }

    public synchronized User getUser(int id) {
        User user = null;
        for (User u : users) {
            if (id == u.getId()) {
                user = u;
                break;
            }
        }
        return user;
    }

    public synchronized boolean delete(User user) {
        return users.remove(user);
    }

    public synchronized boolean transfer(int fromId, int told, int amount) {
        User fromUser = null;
        User toldUser = null;
        boolean flag = false;
        for (User u : users) {
            if (u.getId() == fromId) {
                fromUser = u;
            }
            if (u.getId() == told) {
                toldUser = u;
            }
            if (fromUser != null && toldUser != null && fromUser.getAmount() >= amount) {
                this.update(new User(fromUser.getId(), fromUser.getAmount() - amount));
                this.update(new User(toldUser.getId(), toldUser.getAmount() + amount));
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        UserStorage userStorage = new UserStorage();
        userStorage.add(new User(1, 10));
        userStorage.add(new User(2, 20));
        userStorage.add(new User(3, 30));
        userStorage.add(new User(4, 40));
        userStorage.update(new User(4, 100));
        System.out.println(userStorage.getUsers().toString());
        userStorage.delete(new User(4, 100));
        System.out.println(userStorage.getUsers().toString());
        userStorage.transfer(1, 2, 10);
        System.out.println(userStorage.getUsers().toString());
    }

}
