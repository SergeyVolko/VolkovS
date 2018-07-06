package ru.job4j.store;

import java.util.List;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 6.07.2018
 */

public class Store {

    public Info diff(List<User> previoues, List<User> current) {
        int dell = 0;
        int insert = 0;
        int replace = 0;
        for (User userPrev : previoues) {
            if (!current.contains(userPrev)) {
                if (findId(userPrev.id, current)) {
                    replace++;
                } else {
                    dell++;
                }
            }
        }

        for (User userCur : current) {
            if (!findId(userCur.id, previoues) && !previoues.contains(userCur)) {
                insert++;
            }
        }
        return new Info(dell, insert, replace);
    }

    private boolean findId(int id, List<User> list) {
        boolean flag = false;
        for (User user : list) {
            if (user.id == id) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            User user = (User) o;

            if (id != user.id) {
                return false;
            }
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }


}
