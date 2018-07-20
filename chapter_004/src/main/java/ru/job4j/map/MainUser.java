package ru.job4j.map;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.copyValueOf;

public class MainUser {


    private int hash(Object key) {
        int h = 0;
        if (key != null) {
            h = key.hashCode();
        }
        return (key == null) ? 0 : (h) ^ (h >>> 16);
    }

    private static String binari(int value) {
        String result = "0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000";
        char[] charArray = result.toCharArray();
        int newValue = Math.abs(value);
        int bit;
        for (int i = charArray.length - 1; i > 0; i--) {
            //System.out.println(Arrays.toString(charArray));
            if (charArray[i] == ' ') {
                continue;
            }
            bit = newValue % 2;
            //System.out.println(bit);
            charArray[i] = (char) (bit + 48);
            //System.out.println(charArray[i]);
            newValue = newValue / 2;
            if (newValue == 0) {
                break;
            }
        }
        if (value < 0) {
            for (int i = 0; i < charArray.length; i++) {
                if ((charArray[i] == '0')) {
                    charArray[i] = '1';
                } else {
                    charArray[i] = '0';
                }
            }
        }
        result = copyValueOf(charArray);
        return result;
    }

    public static void main(String[] args) {
        User userFirst = new User("Vova", 6, new Calendar(3, 1, 1985));
        User userSecond = new User("Vova", 6, new Calendar(3, 1, 1985));
        Map<User, Object> map = new HashMap<>();
        int keyFirst, keySecond;
        System.out.println(binari(userFirst.hashCode()));
        System.out.println(binari(userSecond.hashCode()));
        System.out.println(10 & 4);
       /*System.out.print((userFirst.hashCode()) + " ");
       System.out.println(userSecond.hashCode());
       for (int i = 0; i <= 16; i++) {
           System.out.print((userFirst.hashCode() >>> i) + " ");
           System.out.println(userSecond.hashCode() >>> i);
       }*/
       /*
       public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
        }

        static final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }

        final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
                Node<K,V> e; K k;
                if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                else if (p instanceof TreeNode)
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                    if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            if (++size > threshold)
                resize();
            afterNodeInsertion(evict);
            return null;
        }

        */
        map.put(userFirst, new Object());
        map.put(userSecond, new Object());
        //System.out.println(map);
    }
}
