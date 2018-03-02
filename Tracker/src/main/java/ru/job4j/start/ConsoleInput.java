package ru.job4j.start;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 03.03.2018
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
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask("Enter the menu item : "));
        boolean exist = false;
        for (int value : range) {
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