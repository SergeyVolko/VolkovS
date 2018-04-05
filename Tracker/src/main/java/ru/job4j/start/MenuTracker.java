package ru.job4j.start;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 03.03.2018
 */

import ru.job4j.models.*;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> userActionList = new ArrayList<>();
    private UserAction[] actions = new UserAction[7];
    private List<Integer> listRange = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.userActionList.add(new MenuTracker.CreatItem("Add the request -", 0));
        this.userActionList.add(new MenuTracker.ShowItems("Show all applications -", 1));
        this.userActionList.add(new MenuTracker.EditItem("Edit the application id -", 2));
        this.userActionList.add(new MenuTracker.DeleteItemId("Delete the request id -", 3));
        this.userActionList.add(new MenuTracker.FindItemId("Select the application id -", 4));
        this.userActionList.add(new MenuTracker.FindItemName("Choose the application name -", 5));
        this.userActionList.add(new MenuTracker.Exit("The program exit -", 6));
        for (UserAction i : this.userActionList) {
            listRange.add(i.key());
        }
    }

    public List<Integer> getRange() {
        return this.listRange;
    }

    public void select(int key) {
        this.userActionList.get(key).execute(this.input, this.tracker);
    }

    public void showMenu() {
        System.out.printf("//////////////////////////////////////////////////////////%s", System.lineSeparator());
        System.out.printf("Menu%s", System.lineSeparator());
        for (UserAction userAction : this.userActionList) {
            System.out.printf("%s%s", userAction.info(), System.lineSeparator());
        }
        System.out.printf("//////////////////////////////////////////////////////////%s", System.lineSeparator());
    }

    private static class CreatItem extends BaseAction {

        private CreatItem(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------ Adding new applications --------------%s", System.lineSeparator());
            String name = input.ask("Enter the name of the application:");
            String desc = input.ask("Enter a description of the application :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.printf("------------ A new application getId : %s -----------%s", item.getId(), System.lineSeparator());
        }

    }

    private static class ShowItems extends BaseAction {

        private ShowItems(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------Review of all applications---------------%s", System.lineSeparator());
            if (tracker.getAll().size() != 0) {
                int index = 0;
                for (Item item : tracker.getAll()) {
                    System.out.printf("%s) id: %s name: %s description: %s%s", index++, item.getId(), item.getName(), item.getDescription(), System.lineSeparator());
                }
            } else {
                System.out.printf("-----------You have no bids-------------%s", System.lineSeparator());
            }
        }

    }

    private static class EditItem extends BaseAction {

        private EditItem(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------Edit the application id--------------%s", System.lineSeparator());
            String id = input.ask("Enter the id of the application you want to edit :");
            String name = input.ask("Enter the edited name of the application :");
            String desc = input.ask("Enter the edited description of the application :");
            Item item = new Item(name, desc);
            if (tracker.findById(id) != null) {
                System.out.printf("------------- The parameters application id: %s ----------------%s", id, System.lineSeparator());
                System.out.printf("name: %s%s", tracker.findById(id).getName(), System.lineSeparator());
                System.out.printf("description: %s%s", tracker.findById(id).getDescription(), System.lineSeparator());
                System.out.println("Replaced with the following settings: ");
                tracker.replace(id, item);
                System.out.printf("new name: %s%s", tracker.findById(id).getName(), System.lineSeparator());
                System.out.printf("new description: %s%s", tracker.findById(id).getDescription(), System.lineSeparator());
            } else {
                System.out.printf("-----------Application id: %s does not exist-------------------%s", id, System.lineSeparator());
            }
        }

    }

    private static class DeleteItemId extends BaseAction {

        private DeleteItemId(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------The withdrawal of an application by id --------------%s", System.lineSeparator());
            String id = input.ask("Enter the id of the application you want to delete:");
            if (tracker.findById(id) != null) {
                System.out.printf("Application id: %s%s", tracker.findById(id).getId(), System.lineSeparator());
                System.out.printf("name: %s%s", tracker.findById(id).getName(), System.lineSeparator());
                System.out.printf("description: %s%s", tracker.findById(id).getDescription(), System.lineSeparator());
                tracker.delete(id);
                System.out.printf("-------------------Deleted----------------------%s", System.lineSeparator());
            } else {
                System.out.printf("----------- Application id: %s does not exist-------------------%s", id, System.lineSeparator());
            }
        }

    }

    private static class FindItemId extends BaseAction {

        private FindItemId(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("---------------The output of the application to the screen id---------------%s", System.lineSeparator());
            String id = input.ask("Enter the id of the application which you want to display:");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.printf("------------The parameters application id: %s ------------------%s", id, System.lineSeparator());
                System.out.printf("name: %s%s", item.getName(), System.lineSeparator());
                System.out.printf("description: %s%s", item.getDescription(), System.lineSeparator());
            } else {
                System.out.printf("-----------Application id: %s does not exist-------------------%s", id, System.lineSeparator());
            }
        }
    }

    private static class FindItemName extends BaseAction {

        private FindItemName(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------The choice of applications by name--------------%s", System.lineSeparator());
            String name = input.ask("Enter the name of the application / applications :");
            List<Item> items = tracker.findByName(name);
            int index = 0;
            if (items.size() != 0) {
                System.out.printf("----------You have the following application name: %s ----------------%s", name, System.lineSeparator());
                for (Item item : items) {
                    System.out.printf("%s) id: %s description: %s%s", index++, item.getId(), item.getDescription(), System.lineSeparator());
                }
            } else {
                System.out.printf("-------------Applications with the name: %s does not exist-------------------%s", name, System.lineSeparator());
            }
        }
    }

    private static class Exit extends BaseAction {
        private Exit(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------Exit!--------------%s", System.lineSeparator());
        }
    }
}
