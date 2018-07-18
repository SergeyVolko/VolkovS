package ru.job4j.word;

import java.util.Set;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 18.07.2018
 */
public class WordIndex {

    private TrieTree trieTree = new TrieTree();

    public void loadFile(String filename) throws IOException {
        String content = readUsingFiles(filename);
        for (int i = 0; i < content.length(); i++) {
            StringBuilder s;
            s = new StringBuilder();
            while (content.toLowerCase().charAt(i) >= 'a' && content.toLowerCase().charAt(i) <= 'z') {
                s.append(content.toLowerCase().charAt(i++));
            }
            trieTree.put(s.toString(), i - s.length());
        }
    }

    public Set<Integer> getIndexes4Word(String searchWord) {
        return this.trieTree.getIndexes(searchWord);
    }

    private String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
