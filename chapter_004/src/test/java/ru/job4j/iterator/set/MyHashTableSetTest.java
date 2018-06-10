package ru.job4j.iterator.set;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 10.06.2018
 */

import org.junit.Test;
import ru.job4j.set.ItemHesh;
import ru.job4j.set.MyHashTableSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class MyHashTableSetTest {
    private MyHashTableSet<ItemHesh> myHashTableSet = new MyHashTableSet<>(new ItemHesh[7]);

    @Test
    public void whenInitThenAdding() {
        assertThat(myHashTableSet.add(new ItemHesh(6757)), is(true));
        assertThat(myHashTableSet.add(new ItemHesh(233445)), is(false)); //коллизия
        assertThat(myHashTableSet.add(new ItemHesh(987767)), is(true));
        assertThat(myHashTableSet.add(new ItemHesh(5434)), is(false)); //коллизия
        assertThat(myHashTableSet.add(new ItemHesh(34390)), is(true));
        assertThat(myHashTableSet.add(new ItemHesh(7844321)), is(false)); //коллизия
        assertThat(myHashTableSet.add(new ItemHesh(876423)), is(false)); //коллизия
        assertThat(myHashTableSet.add(new ItemHesh(75)), is(true));
        assertThat(myHashTableSet.add(new ItemHesh(4072)), is(false)); //коллизия
        assertThat(myHashTableSet.add(new ItemHesh(753)), is(false)); //коллизия
        assertThat(myHashTableSet.add(new ItemHesh(86)), is(false)); //коллизия
        assertThat(myHashTableSet.add(new ItemHesh(7)), is(true));
        assertThat(myHashTableSet.add(new ItemHesh(22)), is(true));
        assertThat(myHashTableSet.add(new ItemHesh(31)), is(true));


        assertThat(myHashTableSet.contains(new ItemHesh(6757)), is(true));
        assertThat(myHashTableSet.contains(new ItemHesh(233445)), is(false)); //коллизия
        assertThat(myHashTableSet.contains(new ItemHesh(987767)), is(true));
        assertThat(myHashTableSet.contains(new ItemHesh(5434)), is(false)); //коллизия
        assertThat(myHashTableSet.contains(new ItemHesh(34390)), is(true));
        assertThat(myHashTableSet.contains(new ItemHesh(7844321)), is(false)); //коллизия
        assertThat(myHashTableSet.contains(new ItemHesh(876423)), is(false)); //коллизия
        assertThat(myHashTableSet.contains(new ItemHesh(75)), is(true));
        assertThat(myHashTableSet.contains(new ItemHesh(4072)), is(false)); //коллизия
        assertThat(myHashTableSet.contains(new ItemHesh(753)), is(false)); //коллизия
        assertThat(myHashTableSet.contains(new ItemHesh(86)), is(false)); //коллизия
        assertThat(myHashTableSet.contains(new ItemHesh(7)), is(true));
        assertThat(myHashTableSet.contains(new ItemHesh(22)), is(true));
        assertThat(myHashTableSet.contains(new ItemHesh(31)), is(true));

        assertThat(myHashTableSet.add(new ItemHesh(38)), is(true));
        // из-за коллизий при перехешировании теряется элементы с ключами 31 и 22
        assertThat(myHashTableSet.contains(new ItemHesh(31)), is(false));
        assertThat(myHashTableSet.contains(new ItemHesh(22)), is(false));

        assertThat(myHashTableSet.remove(new ItemHesh(6757)), is(true));
        assertThat(myHashTableSet.remove(new ItemHesh(233445)), is(false)); //коллизия
        assertThat(myHashTableSet.remove(new ItemHesh(987767)), is(true));
        assertThat(myHashTableSet.remove(new ItemHesh(5434)), is(false)); //коллизия
        assertThat(myHashTableSet.remove(new ItemHesh(34390)), is(true));
        assertThat(myHashTableSet.remove(new ItemHesh(7844321)), is(false)); //коллизия
        assertThat(myHashTableSet.remove(new ItemHesh(876423)), is(false)); //коллизия
        assertThat(myHashTableSet.remove(new ItemHesh(75)), is(true));
        assertThat(myHashTableSet.remove(new ItemHesh(4072)), is(false)); //коллизия
        assertThat(myHashTableSet.remove(new ItemHesh(753)), is(false)); //коллизия
        assertThat(myHashTableSet.remove(new ItemHesh(86)), is(false)); //коллизия
        assertThat(myHashTableSet.remove(new ItemHesh(7)), is(true));
        assertThat(myHashTableSet.remove(new ItemHesh(22)), is(false)); //коллизия при перехешировании
        assertThat(myHashTableSet.remove(new ItemHesh(31)), is(false)); //коллизия при перехешировании
        assertThat(myHashTableSet.remove(new ItemHesh(38)), is(true));

        System.out.println(myHashTableSet);
    }
}
