package ru.job4j;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 27.01.2018
 */
import ru.job4j.start.*;
import ru.job4j.models.Item;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 26.02.2018
 */
 
 public class StartUIJOutPutTest {
	private final PrintStream stdout = System.out;
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final String showMenu = String.valueOf(new StringBuilder()
			.append("//////////////////////////////////////////////////////////\n")
			.append("Menu\n")
			.append("Add the request - 0\n")
			.append("Show all applications - 1\n")
			.append("Edit the application id - 2\n")
			.append("Delete the request id - 3\n")
			.append("Select the application id - 4\n")
			.append("Choose the application name - 5\n")
			.append("The program exit - 6\n")
			.append("//////////////////////////////////////////////////////////\n")
			.toString());
	
	@Before
	public void loadOutPut() {
		System.setOut(new PrintStream(out));
	}
	
	@After
	public void backOutPut() {
		System.setOut(this.stdout);
	}
	
	@Test
    public void whenEditDeleteExceptDelSelectByIdSelectByNameExitThenShow() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("test name", "test desc"));
		String id = tracker.findAll()[0].getId();
		String name = tracker.findAll()[0].getName();
		String[] massShow = {"0", "second test name", "second test desc", "1", "2", id, "new name test", "new desc test", "2", "111", "new name test", "new desc test", "4", id, "4", "111", "5", "new name test", "5", "name", "3", id, "3", id, "6"};
		StubInput input = new StubInput(massShow);
		new StartUIJ(input, tracker).init();
		assertThat(
					new String(out.toByteArray()),
					is(
						new StringBuilder()
							.append(showMenu)//Add Item
							.append("------------ Adding new applications --------------\n")
							.append("------------ A new application getId : ")
							.append(tracker.findByName("second test name")[0].getId())
							.append(" -----------\n")
							.append(showMenu)//Show Item
							.append("------------Review of all applications---------------\n")
							.append("0) id: ")
							.append(id)
							.append(" name: test name description: test desc\n")
							.append("1) id: ")
							.append(tracker.findByName("second test name")[0].getId())
							.append(" name: second test name description: second test desc\n")
							.append(showMenu)//Edit Item
							.append("------------Edit the application id--------------\n")
							.append("------------- The parameters application id: ")
							.append(id)
							.append(" ----------------\n")
							.append("name: test name\n")
							.append("description: test desc\n")
							.append("Replaced with the following settings: \r\n")
							.append("new name: new name test\n")
							.append("new description: new desc test\n")
							.append(showMenu)//No Edit
							.append("------------Edit the application id--------------\n")
							.append("-----------Application id: 111 does not exist-------------------\n")
							.append(showMenu)//Find id
							.append("---------------The output of the application to the screen id---------------\n")
							.append("------------The parameters application id: ")
							.append(id)
							.append(" ------------------\n")
							.append("name: new name test\n")
							.append("description: new desc test\n")
							.append(showMenu)//No find id
							.append("---------------The output of the application to the screen id---------------\n")
							.append("-----------Application id: 111 does not exist-------------------\n")
							.append(showMenu)//Find name
							.append("------------The choice of applications by name--------------\n")
							.append("----------You have the following application name: new name test ----------------\n")
							.append("0) id: ")
							.append(id)
							.append(" description: new desc test\n")
							.append(showMenu)//No find name
							.append("------------The choice of applications by name--------------\n")
							.append("-------------Applications with the name: name does not exist-------------------\n")
							.append(showMenu)//Delete
							.append("------------The withdrawal of an application by id --------------\n")
							.append("Application id: ")
							.append(id)
							.append("\n")
							.append("name: new name test\n")
							.append("description: new desc test\n")
							.append("-------------------Deleted----------------------\n")
							.append(showMenu)//No delete
							.append("------------The withdrawal of an application by id --------------\n")
							.append("----------- Application id: ")
							.append(id)
							.append(" does not exist-------------------\n")
							.append(showMenu)
							.append("------------Exit!--------------\n")
							.toString()
						)
				);
	}
 }