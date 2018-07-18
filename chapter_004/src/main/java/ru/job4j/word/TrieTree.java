package ru.job4j.word;

import java.util.*;

/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 18.07.2018
 */
public class TrieTree {

    private NodeTrie root = new NodeTrie();

    public void put(String str, int val) {
        NodeTrie v = root;
        for (Character i : str.toLowerCase().toCharArray()) {
            if (!v.children.containsKey(i)) {
                v.children.put(i, new NodeTrie());
            }
            v = v.children.get(i);
        }
        v.values.add(val);
    }

    public Set<Integer> getIndexes(String str) {
        NodeTrie v = this.root;
        for (Character ch : str.toLowerCase().toCharArray()) {
            if (v.children.containsKey(ch)) {
                v = v.children.get(ch);
            } else {
                break;
            }
        }

        return (v.values != null && v.values.size() == 0) ? (null) : (v.values);
    }

    private static class NodeTrie {
        private Map<Character, NodeTrie> children = new TreeMap<>();
        private Set<Integer> values = new TreeSet<>();
    }
}
