package ru.job4j.start;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 02.02.2018
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
     *
     * @param input   ввод данных.
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
        String out = String.format("------------ Adding new applications --------------");
        System.out.println(out);
        String name = this.input.ask("Enter the name of the application:");
        String desc = this.input.ask("Enter a description of the application :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        out = String.format("------------ A new application getId : %s ---------------", item.getId());
        System.out.println(out);
        System.out.println();
    }

    /**
     * Метод реализует вывод всех заявок на экран.
     */
    private void showItem() {
        int count = 0;
        String out = String.format("------------Review of all applications---------------");
        System.out.println(out);
        Item[] items = this.tracker.getAll();
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                count++;
                continue;
            }
            out = String.format("%d ) id: %s name: %s description: %s", i, items[i].getId(), items[i].getName(), items[i].getDescription());
            System.out.println(out);
        }
        if (count == items.length) {
            out = String.format("-----------You have no bids-------------");
            System.out.println(out);
        }
        System.out.println();
    }

    /**
     * Метод редактирующий заявку по id.
     */
    private void editItem() {
        String out = String.format("------------Edit the application id--------------");
        System.out.println(out);
        String id = this.input.ask("Enter the id of the application you want to edit :");
        String name = this.input.ask("Enter the edited name of the application :");
        String desc = this.input.ask("Enter the edited description of the application :");
        Item item = new Item(name, desc);
        if (tracker.findById(id) != null) {
            out = String.format("------------- The parameters application id: %s ----------------", id);
            System.out.println(out);
            out = String.format("name: %s", tracker.findById(id).getName());
            System.out.println(out);
            out = String.format("description: %s", tracker.findById(id).getDescription());
            System.out.println(out);
            out = String.format("Replaced with the following settings: ");
            System.out.println(out);
            tracker.replace(id, item);
            out = String.format("new name: %s", tracker.findById(id).getName());
            System.out.println(out);
            out = String.format("new description %s", tracker.findById(id).getDescription());
            System.out.println(out);
        } else {
            out = String.format("-----------Application id: %s does not exist-------------------", id);
            System.out.println(out);
        }
        System.out.println();
    }

    /**
     * Метод выводящий на экран заявки с одинаковым именем.
     */
    private void findItemName() {
        String out = String.format("------------The choice of applications by name--------------");
        System.out.println(out);
        String name = this.input.ask("Enter the name of the application / applications :");
        Item[] items = tracker.findByName(name);
        if (items != null) {
            out = String.format("----------You have the following application name %s ----------------", name);
            System.out.println(out);
            for (int i = 0; i < items.length; i++) {
                out = String.format("%d ) id: %s description: %s", i, items[i].getId(), items[i].getDescription());
                System.out.println(out);
            }
        } else {
            out = String.format("-------------Applications with the name: %s does not exist-------------", name);
            System.out.println(out);
        }
        System.out.println();
    }

    /**
     * Метод удаляющий заявку по id.
     */
    private void deleteItemId() {
        String out = String.format("------------The withdrawal of an application by id --------------");
        System.out.println(out);
        String id = this.input.ask("Enter the id of the application you want to delete:");
        if (tracker.findById(id) != null) {
            out = String.format("Application id: %s", tracker.findById(id).getId());
            System.out.println(out);
            out = String.format("name: %s", tracker.findById(id).getName());
            System.out.println(out);
            out = String.format("description: %s", tracker.findById(id).getDescription());
            System.out.println(out);
            tracker.delete(id);
            out = String.format("-------------------Deleted----------------------");
            System.out.println(out);
        } else {
            out = String.format("----------- Application id: %s does not exist-------------------", id);
            System.out.println(out);
        }
        System.out.println();
    }

    /**
     * Метод выводящий на экран заявку по id.
     */
    private void findItemId() {
        System.out.printf("---------------The output of the application to the screen id---------------%n");
        String id = this.input.ask("Enter the id of the application which you want to display:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.printf("------------The parameters application id: %s ------------------%n", id);
            System.out.printf("name: %s %n", item.getName());
            System.out.printf("description: %s %n", item.getDescription());
        } else {
            System.out.printf("-----------Application id: %s does not exist-------------------", id);
        }
        System.out.printf("%n");
    }

    /**
     * Метод выводящий на экран пользовательское меню.
     */
    private void showMenu() {
        System.out.printf("///////////////////////////////////////////////////////////////////////%n");
        System.out.printf("Menu%n");
        System.out.printf("Add the request - %s %n", ADD);
        System.out.printf("Show all applications - %s %n", SHOW);
        System.out.printf("Edit the application id - %s %n", EDITE);
        System.out.printf("Delete the request id - %s %n", DELETE);
        System.out.printf("Select the application id - %s %n", FIND_ID);
        System.out.printf("Choose the application name - %s %n", FIND_NAME);
        System.out.printf("The program exit - %s %n", EXIT);
        System.out.printf("///////////////////////////////////////////////////////////////////////%n");
    }
    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}