package ru.job4j.start;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.01.2018
 */
import ru.job4j.models.*;
public class MenuTracker {
	private Input input;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[7];
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public void fillActions() {
		this.actions[0] = new MenuTracker.CreatItem();
		this.actions[1] = new MenuTracker.ShowItems();
		this.actions[2] = new MenuTracker.EditItem();
		this.actions[3] = new MenuTracker.DeleteItemId();
		this.actions[4] = new MenuTracker.FindItemId();
		this.actions[5] = new MenuTracker.FindItemName();
		this.actions[6] = new MenuTracker.Exit();
	}
	
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
	}
	
	public void showMenu() {
		System.out.printf("//////////////////////////////////////////////////////////\n");
		System.out.printf("Menu\n");
		for (UserAction action:this.actions) {
			System.out.printf("%s\n", action.info());
		}
		System.out.printf("//////////////////////////////////////////////////////////\n");
	}
	
	private static class CreatItem implements UserAction {
		@Override
		public int key() {
			return 0;
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
		
		@Override
		public String info() {
			return String.format("%s %s", "Add the request -", this.key());
		}
	}	
	
	private  static class ShowItems implements UserAction {
		@Override
		public int key() {
			return 1;
		}
		
		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.printf("------------Review of all applications---------------\n");
			Item[] items = tracker.findAll();
			for (int i = 0; i < items.length; i++) {
				System.out.printf("%s) id: %s name: %s description: %s\n", i, items[i].getId(), items[i].getName(), items[i].getDescription());
			}
			if (items.length == 0) {
				System.out.printf("-----------You have no bids-------------\n");
			}		
		}
		
		@Override
		public String info() {
			return String.format("%s %s", "Show all applications -", this.key());
		}
	}
	
	private static class EditItem implements UserAction {
		@Override
		public int key() {
			return 2;
		}
		
		@Override
		public void execute(Input input,  Tracker tracker) {
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
		
		@Override
		public String info() {
			return String.format("%s %s",  "Edit the application id -", this.key());
		}
	}
	
	private static class DeleteItemId implements UserAction {
		@Override
		public int key() {
			return 3;
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
		
		@Override
		public String info() {
			return String.format("%s %s", "Delete the request id -", this.key());
		}
	}
	
	private static class FindItemId implements UserAction {
		@Override
		public int key() {
			return 4;
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
		
		@Override
		public String info() {
			return String.format("%s %s", "Select the application id -", this.key());
		}
	}
	
	private static class FindItemName implements UserAction {
		@Override
		public int key() {
			return 5;
		}
		
		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.printf("------------The choice of applications by name--------------\n");
			String name = input.ask("Enter the name of the application / applications :");
			Item[] items = tracker.findByName(name);
			if (items != null) {
				System.out.printf("----------You have the following application name: %s ----------------\n", name);
				for (int i = 0; i < items.length; i++) {
					System.out.printf("%s) id: %s description: %s\n", i, items[i].getId(), items[i].getDescription());
				}
			} else {
				System.out.printf("-------------Applications with the name: %s does not exist-------------------\n", name);
			}
		}
		
		@Override
		public String info() {
			return String.format("%s %s", "Choose the application name -", this.key());
		}
	}
	
	private static class Exit implements UserAction {
		@Override
		public int key() {
			return 6;
		}
		
		@Override
		public void execute(Input input, Tracker tracker) {
			System.out.printf("------------Exit!--------------\n");
		}
		
		@Override
		public String info() {
			return String.format("%s %s", "The program exit -", this.key());
		}
	}
}