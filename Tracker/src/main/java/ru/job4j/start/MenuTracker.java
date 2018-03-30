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
        System.out.printf("//////////////////////////////////////////////////////////\n");
        System.out.printf("Menu\n");
        for (UserAction userAction : this.userActionList) {
            System.out.printf("%s\n", userAction.info());
        }
        System.out.printf("//////////////////////////////////////////////////////////\n");
    }

    private static class CreatItem extends BaseAction {

        private CreatItem(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------ Adding new applications --------------\n");
            String name = input.ask("Enter the name of the application:");
            String desc = input.ask("Enter a description of the application :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.printf("------------ A new application getId : %s -----------\n", item.getId());
        }

    }

    private static class ShowItems extends BaseAction {

        private ShowItems(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------Review of all applications---------------\n");
            if (tracker.getAll().size() != 0) {
                int index = 0;
                for (Item item : tracker.getAll()) {
                    System.out.printf("%s) id: %s name: %s description: %s\n", index++, item.getId(), item.getName(), item.getDescription());
                }
            } else {
                System.out.printf("-----------You have no bids-------------\n");
            }
        }

    }

    private static class EditItem extends BaseAction {

        private EditItem(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------Edit the application id--------------\n");
            String id = input.ask("Enter the id of the application you want to edit :");
            String name = input.ask("Enter the edited name of the application :");
            String desc = input.ask("Enter the edited description of the application :");
            Item item = new Item(name, desc);
            if (tracker.findById(id) != null) {
                System.out.printf("------------- The parameters application id: %s ----------------\n", id);
                System.out.printf("name: %s\n", tracker.findById(id).getName());
                System.out.printf("description: %s\n", tracker.findById(id).getDescription());
                System.out.println("Replaced with the following settings: ");
                tracker.replace(id, item);
                System.out.printf("new name: %s\n", tracker.findById(id).getName());
                System.out.printf("new description: %s\n", tracker.findById(id).getDescription());
            } else {
                System.out.printf("-----------Application id: %s does not exist-------------------\n", id);
            }
        }

    }

    private static class DeleteItemId extends BaseAction {

        private DeleteItemId(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------The withdrawal of an application by id --------------\n");
            String id = input.ask("Enter the id of the application you want to delete:");
            if (tracker.findById(id) != null) {
                System.out.printf("Application id: %s\n", tracker.findById(id).getId());
                System.out.printf("name: %s\n", tracker.findById(id).getName());
                System.out.printf("description: %s\n", tracker.findById(id).getDescription());
                tracker.delete(id);
                System.out.printf("-------------------Deleted----------------------\n");
            } else {
                System.out.printf("----------- Application id: %s does not exist-------------------\n", id);
            }
        }

    }

    private static class FindItemId extends BaseAction {

        private FindItemId(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("---------------The output of the application to the screen id---------------\n");
            String id = input.ask("Enter the id of the application which you want to display:");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.printf("------------The parameters application id: %s ------------------\n", id);
                System.out.printf("name: %s\n", item.getName());
                System.out.printf("description: %s\n", item.getDescription());
            } else {
                System.out.printf("-----------Application id: %s does not exist-------------------\n", id);
            }
        }
    }

    private static class FindItemName extends BaseAction {

        private FindItemName(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------The choice of applications by name--------------\n");
            String name = input.ask("Enter the name of the application / applications :");
            List<Item> items = tracker.findByName(name);
            int index = 0;
            if (items.size() != 0) {
                System.out.printf("----------You have the following application name: %s ----------------\n", name);
                for (Item item : items) {
                    System.out.printf("%s) id: %s description: %s\n", index++, item.getId(), item.getDescription());
                }
            } else {
                System.out.printf("-------------Applications with the name: %s does not exist-------------------\n", name);
            }
        }
    }

    private static class Exit extends BaseAction {
        private Exit(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.printf("------------Exit!--------------\n");
        }
    }
}
