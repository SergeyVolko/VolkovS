package ru.job4j;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import ru.job4j.start.StubInput;
import ru.job4j.start.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 06.03.2018
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"7", "invalid", "6"}));
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            integerList.add(i);
        }
        input.ask("Enter the menu item : ", integerList);
        assertThat(new String(this.mem.toByteArray()),
                is(String.format("Please select key from menu.%nPlease enter validate data again.%n")));
    }
}
