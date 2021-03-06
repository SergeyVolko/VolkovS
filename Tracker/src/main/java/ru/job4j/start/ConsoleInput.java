package ru.job4j.start;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 06.03.2018
 */

import java.util.*;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return this.scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> list) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : list) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }

    }
}