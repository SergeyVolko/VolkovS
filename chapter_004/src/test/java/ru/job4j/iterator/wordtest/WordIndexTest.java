package ru.job4j.iterator.wordtest;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.word.WordIndex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static org.hamcrest.Matchers.is;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 18.07.2018
 */

public class WordIndexTest {
    @Test
    public void whenAddingTextThenSearchWordIndex() throws IOException {
        WordIndex wordIndex = new WordIndex();
        String fileName = "C:\\projects\\VolkovS\\chapter_004\\src\\main\\java\\ru\\job4j\\word\\source.txt";
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        wordIndex.loadFile(fileName);
        String word = "java";
        Set<Integer> javaSet = wordIndex.getIndexes4Word(word);
        for (Integer index : javaSet) {
            Assert.assertThat(content.toLowerCase().substring(index, index + word.length()), is("java"));
        }
    }
}
