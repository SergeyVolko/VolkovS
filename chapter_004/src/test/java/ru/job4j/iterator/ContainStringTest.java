package ru.job4j.iterator;


import org.junit.Assert;
import org.junit.Test;
import ru.job4j.stroki.ContainString;

import static org.hamcrest.Matchers.is;

public class ContainStringTest {
    @Test
    public void whenContainStringThenTrueOrFalse() {
        ContainString containString = new ContainString();
        Assert.assertThat(containString.contStr("mama", "amma"), is(true));
        Assert.assertThat(containString.contStr("mama", "maam"), is(true));
        Assert.assertThat(containString.contStr("mama", "maami"), is(false));
        Assert.assertThat(containString.contStr("мама", "амам"), is(true));
        Assert.assertThat(containString.contStr("мама", "мааа"), is(false));
    }
}
