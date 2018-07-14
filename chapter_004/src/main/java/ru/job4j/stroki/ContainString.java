package ru.job4j.stroki;

public class ContainString {

    public boolean contStr(String in, String dest) {
        int j = 0;
        for (int i = 0; i < dest.length(); i++) {
            if (j < in.length() - 1 && in.charAt(j) == dest.charAt(i)) {
                j++;
            } else if ((j > 0)) {
                break;
            }
        }
        return j == in.length() - 1;
    }
}
