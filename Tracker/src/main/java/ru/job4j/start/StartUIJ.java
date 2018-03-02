package ru.job4j.start;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 02.03.2018
 */
import ru.job4j.models.*;

public class StartUIJ {
    
    private final Input input;
    private int[] range = new int[7];

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
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
		menu.fillActions(range);
        do {
			menu.showMenu();
			key = this.input.ask("Enter the menu item : ", range);
            menu.select(key);
        } while (!"6".equals(String.valueOf(key)));
    }
  
    

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUIJ(input, new Tracker()).init();
    }
}