package ru.job4j.start;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 29.09.2018
 */


import java.util.function.Consumer;

public class StartUIJ {

    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUIJ(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        int key;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.showMenu();
            key = this.input.ask("Enter the menu item : ", menu.getRange());
            menu.select(key);
        } while (!"6".equals(String.valueOf(key)));
    }

    public void initConsumer(Consumer<StartUIJ> consumer) {
        consumer.accept(this);
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUIJ(new ValidateInput(new ConsoleInput()), new Tracker()).initConsumer(StartUIJ::init);
    }
}