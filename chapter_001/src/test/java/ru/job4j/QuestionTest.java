package ru.job4j;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 5.01.2017
 */
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
public class QuestionTest {
    @Test
    public void whenAddArray1SortAndArray2SortThenArrayResultSort() {
        Question question = new Question();
        int[] array2 = {2, 3, 9, 15, 20, 35, 40, 67};
        int[] array1 = {1, 4, 6, 8, 9, 21, 23, 30, 32, 45, 50};
        int[] arrayExpect = {1, 2, 3, 4, 6, 8, 9, 9, 15, 20, 21, 23, 30, 32, 35, 40, 45, 50, 67};
        int[] arrayResult = question.methodArrays(array1, array2);
        assertArrayEquals(arrayExpect, arrayResult);
    }
}
