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

import static java.awt.SystemColor.menu;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
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
            .append("//////////////////////////////////////////////////////////")
            .append(System.lineSeparator())
            .append("Menu")
            .append(System.lineSeparator())
            .append("Add the request - 0")
            .append(System.lineSeparator())
            .append("Show all applications - 1")
            .append(System.lineSeparator())
            .append("Edit the application id - 2")
            .append(System.lineSeparator())
            .append("Delete the request id - 3")
            .append(System.lineSeparator())
            .append("Select the application id - 4")
            .append(System.lineSeparator())
            .append("Choose the application name - 5")
            .append(System.lineSeparator())
            .append("The program exit - 6")
            .append(System.lineSeparator())
            .append("//////////////////////////////////////////////////////////")
            .append(System.lineSeparator())
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
        String id = tracker.getAll().get(0).getId();
        String name = tracker.getAll().get(0).getName();
        String[] massShow = {"0", "second test name", "second test desc", "1", "2", id, "new name test", "new desc test", "2", "111", "new name test", "new desc test", "4", id, "4", "111", "5", "new name test", "5", "name", "3", id, "3", id, "6"};
        StubInput input = new StubInput(massShow);
        new StartUIJ(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(showMenu)//Add Item
                                .append("------------ Adding new applications --------------")
                                .append(System.lineSeparator())
                                .append("------------ A new application getId : ")
                                .append(tracker.findByName("second test name").get(0).getId())
                                .append(" -----------")
                                .append(System.lineSeparator())
                                .append(showMenu)//Show Item
                                .append("------------Review of all applications---------------")
                                .append(System.lineSeparator())
                                .append("0) id: ")
                                .append(id)
                                .append(" name: test name description: test desc")
                                .append(System.lineSeparator())
                                .append("1) id: ")
                                .append(tracker.findByName("second test name").get(0).getId())
                                .append(" name: second test name description: second test desc")
                                .append(System.lineSeparator())
                                .append(showMenu)//Edit Item
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
                                .append("new name: new name test")
                                .append(System.lineSeparator())
                                .append("new description: new desc test")
                                .append(System.lineSeparator())
                                .append(showMenu)//No Edit
                                .append("------------Edit the application id--------------")
                                .append(System.lineSeparator())
                                .append("-----------Application id: 111 does not exist-------------------")
                                .append(System.lineSeparator())
                                .append(showMenu)//Find id
                                .append("---------------The output of the application to the screen id---------------")
                                .append(System.lineSeparator())
                                .append("------------The parameters application id: ")
                                .append(id)
                                .append(" ------------------")
                                .append(System.lineSeparator())
                                .append("name: new name test")
                                .append(System.lineSeparator())
                                .append("description: new desc test")
                                .append(System.lineSeparator())
                                .append(showMenu)//No find id
                                .append("---------------The output of the application to the screen id---------------")
                                .append(System.lineSeparator())
                                .append("-----------Application id: 111 does not exist-------------------")
                                .append(System.lineSeparator())
                                .append(showMenu)//Find name
                                .append("------------The choice of applications by name--------------")
                                .append(System.lineSeparator())
                                .append("----------You have the following application name: new name test ----------------")
                                .append(System.lineSeparator())
                                .append("0) id: ")
                                .append(id)
                                .append(" description: new desc test")
                                .append(System.lineSeparator())
                                .append(showMenu)//No find name
                                .append("------------The choice of applications by name--------------")
                                .append(System.lineSeparator())
                                .append("-------------Applications with the name: name does not exist-------------------")
                                .append(System.lineSeparator())
                                .append(showMenu)//Delete
                                .append("------------The withdrawal of an application by id --------------")
                                .append(System.lineSeparator())
                                .append("Application id: ")
                                .append(id)
                                .append(System.lineSeparator())
                                .append("name: new name test")
                                .append(System.lineSeparator())
                                .append("description: new desc test")
                                .append(System.lineSeparator())
                                .append("-------------------Deleted----------------------")
                                .append(System.lineSeparator())
                                .append(showMenu)//No delete
                                .append("------------The withdrawal of an application by id --------------")
                                .append(System.lineSeparator())
                                .append("----------- Application id: ")
                                .append(id)
                                .append(" does not exist-------------------")
                                .append(System.lineSeparator())
                                .append(showMenu)
                                .append("------------Exit!--------------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}