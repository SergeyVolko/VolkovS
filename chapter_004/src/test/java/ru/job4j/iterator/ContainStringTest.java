package ru.job4j.iterator;


import org.junit.Assert;
import org.junit.Test;
import ru.job4j.stroki.ContainString;

import static org.hamcrest.Matchers.is;

public class ContainStringTest {
    @Test
    public void whenContainStringThenTrueOrFalse() {
        ContainString containString = new ContainString();
        Assert.assertThat(containString.contStr("mama", "ojghhmamahg"), is(true));
        Assert.assertThat(containString.contStr("mama", "ojghhmaamhg"), is(false));
    }
}
