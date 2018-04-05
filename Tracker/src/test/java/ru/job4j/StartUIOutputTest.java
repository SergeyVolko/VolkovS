package ru.job4j;

import ru.job4j.start.Tracker;
import ru.job4j.models.Item;
import ru.job4j.start.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 16.02.2018
 */
public class StartUIOutputTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String showMenu = String.valueOf(new StringBuilder()
            .append("///////////////////////////////////////////////////////////////////////")
            .append(System.lineSeparator())
            .append("Menu")
            .append(System.lineSeparator())
            .append("Add the request - 0 ")
            .append(System.lineSeparator())
            .append("Show all applications - 1 ")
            .append(System.lineSeparator())
            .append("Edit the application id - 2 ")
            .append(System.lineSeparator())
            .append("Delete the request id - 3 ")
            .append(System.lineSeparator())
            .append("Select the application id - 4 ")
            .append(System.lineSeparator())
            .append("Choose the application name - 5 ")
            .append(System.lineSeparator())
            .append("The program exit - 6 ")
            .append(System.lineSeparator())
            .append("///////////////////////////////////////////////////////////////////////")
            .append(System.lineSeparator())
            .toString());

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenShowThenShowItem() {
        Tracker tracker = new Tracker();

        String[] massShow = {"0", "test name", "test desc", "1", "6"};
        StubInput input = new StubInput(massShow);
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(showMenu)
                                .append("------------ Adding new applications --------------")
                                .append(System.lineSeparator())
                                .append("------------ A new application getId : ")
                                .append(tracker.findByName("test name").get(0).getId())
                                .append(" ---------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("------------Review of all applications---------------")
                                .append(System.lineSeparator())
                                .append("0 ) id: ")
                                .append(tracker.findByName("test name").get(0).getId())
                                .append(" name: ")
                                .append("test name")
                                .append(" description: ")
                                .append("test desc")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .toString()
                )
        );

    }

    @Test
    public void whenEditDeleteExceptDelSelectByIdSelectByNameExitThenShow() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name", "test desc"));
        tracker.add(new Item("test name second", "test desc second"));
        String id = tracker.getAll().get(0).getId();
        String idSecond = tracker.getAll().get(1).getId();
        String[] massEditDel = {"2", id, "new test name", "new test desc", "2", "0", "xx", "xx", "3", id, "3", id, "4", idSecond, "4", "0", "5", "test name second", "5", "no name", "7", "6"};
        new StartUI(new StubInput(massEditDel), tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(showMenu)
                                .append("------------Edit the application id--------------")
                                .append(System.lineSeparator())
                                .append("------------- The parameters application id: ")
                                .append(id)
                                .append(" ----------------")
                                .append(System.lineSeparator())
                                .append("name: test name")
                                .append(System.lineSeparator())
                                .append("description: test desc")
                                .append(System.lineSeparator())
                                .append("Replaced with the following settings: ")
                                .append(System.lineSeparator())
                                .append("new name: new test name")
                                .append(System.lineSeparator())
                                .append("new description new test desc")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("------------Edit the application id--------------")
                                .append(System.lineSeparator())
                                .append("-----------Application id: 0 does not exist-------------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("------------The withdrawal of an application by id --------------")
                                .append(System.lineSeparator())
                                .append("Application id: ")
                                .append(id)
                                .append(System.lineSeparator())
                                .append("name: new test name")
                                .append(System.lineSeparator())
                                .append("description: new test desc")
                                .append(System.lineSeparator())
                                .append("-------------------Deleted----------------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("------------The withdrawal of an application by id --------------")
                                .append(System.lineSeparator())
                                .append("----------- Application id: ")
                                .append(id)
                                .append(" does not exist-------------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("---------------The output of the application to the screen id---------------")
                                .append(System.lineSeparator())
                                .append("------------The parameters application id: ")
                                .append(idSecond)
                                .append(" ------------------")
                                .append(System.lineSeparator())
                                .append("name: test name second ")
                                .append(System.lineSeparator())
                                .append("description: test desc second ")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("---------------The output of the application to the screen id---------------")
                                .append(System.lineSeparator())
                                .append("-----------Application id: 0 does not exist-------------------")
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("------------The choice of applications by name--------------")
                                .append(System.lineSeparator())
                                .append("----------You have the following application name test name second ----------------")
                                .append(System.lineSeparator())
                                .append("0 ) id: ")
                                .append(idSecond)
                                .append(" description: test desc second")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("------------The choice of applications by name--------------")
                                .append(System.lineSeparator())
                                .append("-------------Applications with the name: no name does not exist-------------")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("There is no such command.")
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .toString()
                )
        );
    }
}
