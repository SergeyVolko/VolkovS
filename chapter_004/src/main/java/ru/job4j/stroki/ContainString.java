package ru.job4j.stroki;

public class ContainString {

    public boolean contStr(String in, String dest) {
        boolean flag = true;
        if(in.length() == dest.length()) {
            for (Character ch : in.toCharArray()) {
                if (dest.indexOf(ch) < 0) {
                    flag = false;
                    break;
                }
                dest = dest.replaceFirst(ch.toString(), "");
            }
        } else {
            flag = false;
        }

        return flag;
    }
}
