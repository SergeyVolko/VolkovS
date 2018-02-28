package ru.job4j.start;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.01.2018
 */
import ru.job4j.models.*;

public class StartUIJ {
    
    private final Input input;

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
		menu.fillActions();
        do {
			menu.showMenu();
			try {
				key = Integer.valueOf(this.input.ask("Enter the menu item : "));
			} catch (Exception e) {
				key = 7;
			}
			if (key >= 0 && key <= 6) {
				menu.select(key);
			} else  {
				System.out.printf("Error input\n");
			}
            
        } while (!"6".equals(String.valueOf(key)));
    }
  
    

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUIJ(new ConsoleInput(), new Tracker()).init();
    }
}