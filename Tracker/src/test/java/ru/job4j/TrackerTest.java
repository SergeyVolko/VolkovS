package ru.job4j;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 21.01.2018
 */

import ru.job4j.start.Tracker;
import ru.job4j.models.Item;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindAllItemThenNoNullArray() {
        Tracker tracker = new Tracker();
        for (int i = 1; i <= 5; i++) {
            tracker.add(new Item("test" + i, "testDescription" + i, (long) i));
        }
        String[] findNameResult = new String[tracker.getAll().size()];
        for (int i = 0; i < tracker.getAll().size(); i++) {
            findNameResult[i] = tracker.getAll().get(i).getName();
        }
        String[] expected = {"test1", "test2", "test3", "test4", "test5"};
        assertArrayEquals(findNameResult, expected);
    }

    @Test
    public void whenDeleteThenItemShiftLeftNewArray() {
        Tracker tracker = new Tracker();
        for (int i = 1; i <= 5; i++) {
            tracker.add(new Item("test" + i, "testDescription" + i, (long) i));
        }
        tracker.delete(tracker.getAll().get(3).getId());
        String[] findNameResult = new String[tracker.getAll().size()];
        for (int i = 0; i < tracker.getAll().size(); i++) {
            findNameResult[i] = tracker.getAll().get(i).getName();
        }
        String[] expected = {"test1", "test2", "test3", "test5"};
        assertArrayEquals(findNameResult, expected);
    }

    @Test
    public void whenFindByNameEqualsKeyNewArray() {
        Tracker tracker = new Tracker();
        for (int i = 1, k = 1; i <= 5; i++) {
            if (i < 4) {
                k = 1;
            } else {
                k = 2;
            }
            tracker.add(new Item("test" + k, "testDescription" + i, (long) i));
        }
        List<Item> nameFindItem = tracker.findByName("test1");
        String[] findNameResult = new String[nameFindItem.size()];
        for (int i = 0; i < findNameResult.length; i++) {
            findNameResult[i] = nameFindItem.get(i).getName();
        }
        String[] expected = {"test1", "test1", "test1"};
        assertArrayEquals(findNameResult, expected);
    }

    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker = new Tracker();
        for (int i = 1; i <= 5; i++) {
            tracker.add(new Item("test" + i, "testDescription" + i, (long) i));
        }
        String idNew = tracker.getAll().get(0).getId();
        String idName = tracker.findById(idNew).getName();
        String expected = "test1";
        assertThat(idName, is(expected));
    }
}
