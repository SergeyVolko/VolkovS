package ru.job4j.pingpong.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 28.09.2018
 */


public class FunctionList {
    public List<Double> diapason(int start, int finish, Function<Double, Double> function) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < finish; i++) {
            list.add(function.apply((double) i));
        }
        return list;
    }
}


