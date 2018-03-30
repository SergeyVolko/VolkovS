package ru.job4j.start;

import java.util.List;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 03.03.2018
 */
interface Input {
    String ask(String question);

    int ask(String question, List<Integer> list);
}