package ru.job4j.stroki;

import java.util.HashMap;
import java.util.Map;

public class ContainString {

    public boolean contStr(String in, String dest) {
        boolean flag = true;
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < dest.length(); i++) {
            if (hm.get(dest.charAt(i)) != null) {
                hm.put(dest.charAt(i), hm.get(dest.charAt(i)) + 1);
                continue;
            }
            hm.put(dest.charAt(i), 1);
        }

        for (int i = 0; i < in.length(); i++) {
            if (hm.get(in.charAt(i)) != null && hm.get(in.charAt(i)) > 0) {
                hm.put(in.charAt(i), hm.get(in.charAt(i)) - 1);
            } else {
                flag = false;
            }
        }
        return flag;
    }
}
