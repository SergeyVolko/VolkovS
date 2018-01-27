package ru.job4j.start;

/**
 * @version $Id$
 * @since 0.1
 */
import ru.job4j.models.*;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
	/**
	* Константа меню показывающая все заявки.
	*/
	private static final String SHOW = "1";
	/**
	* Константа меню редактирующая заявку по id.
	*/
	private static final String EDITE = "2";
	/**
	* Константа меню удаляющая заявку по id.
	*/
	private static final String DELETE = "3";
	/**
	* Константа меню выбирающая заявку по id.
	*/
	private static final String FIND_ID = "4";
	/**
	* Константа меню выбирающая заявки по имени.
	*/
	private static final String FIND_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
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
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter the menu item : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
			} else if (SHOW.equals(answer)) {
				this.showItem();		
            } else if (EDITE.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
				this.deleteItemId();
			} else if (FIND_ID.equals(answer)) {
				this.findItemId();
			} else if (FIND_NAME.equals(answer)) {
				this.findItemName();
			} else if (EXIT.equals(answer)) {
				exit = true;
			} else {
				System.out.println("There is no such command.");
			}
        }
    }

    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Adding new applications --------------");
        String name = this.input.ask("Enter the name of the application:");
        String desc = this.input.ask("Enter a description of the application :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ A new application getId :" + item.getId() + "-----------");
		System.out.println();
    }
	
	/**
     * Метод реализует вывод всех заявок на экран.
     */
	private void showItem() {
		int count = 0;
		System.out.println("------------Review of all applications---------------");
		Item[] items = this.tracker.getAll();
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				count++;
				continue;
			}
			System.out.println(i + ") id: " + items[i].getId() + " name: " + items[i].getName() + " description: " + items[i].getDescription());
		}
		if (count == items.length) {
			System.out.println("-----------You have no bids-------------");
		}
		System.out.println();
	}
	
	/**
	* Метод редактирующий заявку по id.
	*/
	private void editItem() {
		System.out.println("------------Edit the application id--------------");
		String id = this.input.ask("Enter the id of the application you want to edit :");
		String name = this.input.ask("Enter the edited name of the application :");
        String desc = this.input.ask("Enter the edited description of the application :");
		Item item = new Item(name, desc);
		if (tracker.findById(id) != null) {
			System.out.println("------------- The parameters application id: " + id + " ----------------");
			System.out.println("name: " + tracker.findById(id).getName());
			System.out.println("description: " + tracker.findById(id).getDescription());
			System.out.println("Replaced with the following settings: ");
			tracker.replace(id, item);
			System.out.println("new name: " + tracker.findById(id).getName());
			System.out.println("new description: " + tracker.findById(id).getDescription());
		} else {
			System.out.println("-----------Application id: " + id + " does not exist-------------------");
		}
		System.out.println();
	}
	
	/**
	* Метод выводящий на экран заявки с одинаковым именем.
	*/
	private void findItemName() {
		System.out.println("------------The choice of applications by name--------------");
		String name = this.input.ask("Enter the name of the application / applications :");
		Item[] items = tracker.findByName(name);
		if (items != null) {
			System.out.println("----------You have the following application name " + name + "----------------");
			for (int i = 0; i < items.length; i++) {
				System.out.println(i + ") id: " + items[i].getId() + " description: " + items[i].getDescription());
			}
		} else {
			System.out.println("-------------Applications with the name: " + name + " does not exis-------------------");
		}
		System.out.println();
	}
	
	/**
	* Метод удаляющий заявку по id.
	*/
	private void deleteItemId() {
		System.out.println("------------The withdrawal of an application by id --------------");
		String id = this.input.ask("Enter the id of the application you want to delete:");
		if (tracker.findById(id) != null) {
			System.out.println("Application id:" + tracker.findById(id).getId());
			System.out.println("name: " + tracker.findById(id).getName());
			System.out.println("description: " + tracker.findById(id).getDescription());
			tracker.delete(id);
			System.out.println("-------------------Deleted----------------------");
		} else {
			System.out.println("----------- Application id:" + id + " does not exist-------------------");
		}
		System.out.println();
	}
	
	/**
	* Метод выводящий на экран заявку по id.
	*/
	private void findItemId() {
		System.out.println("---------------The output of the application to the screen id---------------");
		String id = this.input.ask("Enter the id of the application which you want to display:");
		Item item = tracker.findById(id);
		if (item != null) {
			System.out.println("------------The parameters application id:" + id + "------------------");
			System.out.println("name: " + item.getName());
			System.out.println("description: " + item.getDescription());
		} else {
			System.out.println("-----------Application id: " + id + " does not exist-------------------");
		}
		System.out.println();
	}
	
	/**
	* Метод выводящий на экран пользовательское меню.
	*/
    private void showMenu() {
		System.out.println("///////////////////////////////////////////////////////////////////////");
        System.out.println("Menu");
		System.out.println("Add the request -" + ADD);
		System.out.println("Show all applications -" + SHOW);
		System.out.println("Edit the application id-" + EDITE);
		System.out.println("Delete the request id-" + DELETE);
		System.out.println("Select the application id-" + FIND_ID);
		System.out.println("Choose the application name-" + FIND_NAME);
		System.out.println("The program exit-" + EXIT);
		System.out.println("///////////////////////////////////////////////////////////////////////");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}