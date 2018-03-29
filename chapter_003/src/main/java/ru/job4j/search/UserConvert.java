package ru.job4j.search;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 29.03.2018
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        for (User user : list) {
            hashMap.put(user.getId(), user);
        }
        return hashMap;
    }

    public static void main(String[] args) {
        UserConvert userConvert = new UserConvert();
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Ivan", "Moscow"));
        userList.add(new User(4, "Nikolay", "Kursk"));
        HashMap<Integer, User> hashMap = userConvert.process(userList);
        System.out.println(hashMap.get(1).getName() + " " + hashMap.get(4).getName());
    }
}
