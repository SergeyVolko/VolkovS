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
        int index;
        for (User userPrev : previoues) {
            if (current.contains(userPrev)) {
                index = current.indexOf(userPrev);
                if (!current.get(index).name.equals(userPrev.name)) {
                    replace++;
                }
            } else {
                dell++;
            }
        }
        insert = current.size() - (previoues.size() - dell);
        return new Info(dell, insert, replace);
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

            return id == user.id;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }


}
