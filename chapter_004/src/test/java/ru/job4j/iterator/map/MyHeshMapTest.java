package ru.job4j.iterator.map;
/**
 * @author Sergey Volkov (rusobraz@mail.ru)
 * @version $Id$
 * @since 28.06.2018
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.map.MyHashMap;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;

public class MyHeshMapTest {
    private MyHashMap<Integer, String> myHashMap = new MyHashMap<>();

    @Before
    public void before() {
        System.out.println(myHashMap.insert(7643, "sdfs"));
        System.out.println(myHashMap.insert(9813, "sgdgsd"));
        System.out.println(myHashMap.insert(2351, "hjlkhk"));
        System.out.println(myHashMap.insert(7840, "hfdhf"));
        System.out.println(myHashMap.insert(52576, "fjfjj"));
        System.out.println(myHashMap.insert(43456, "fddfg"));
        System.out.println(myHashMap);
        System.out.println(myHashMap.insert(8610, "AAGDF"));
        System.out.println(myHashMap.insert(9551, "ffgnndx"));
        System.out.println(myHashMap.insert(9854, "hkhjghf"));
        System.out.println(myHashMap.insert(87653, "afhrrth"));
        System.out.println(myHashMap.insert(1349, "rtrtsjf"));
        System.out.println(myHashMap.insert(78990, "FDSDGSD"));
        System.out.println(myHashMap.insert(775908, "gfngfnj"));
        System.out.println(myHashMap.insert(545413, "knnkjn"));
        System.out.println(myHashMap.insert(7655446, "j78oiui"));
        System.out.println(myHashMap.insert(2112876, "iluu8yjy"));
        System.out.println(myHashMap.insert(887786, "kumkjnkhkl"));
        System.out.println(myHashMap.insert(179063, "uybugyuj"));
        System.out.println(myHashMap.insert(2168757, "erwertru"));
        System.out.println(myHashMap);
        System.out.println();
        System.out.println(myHashMap.insert(6766409, "k,uyuihti"));
        System.out.println(myHashMap.insert(97135986, "khmluunuj"));
        System.out.println(myHashMap.insert(6653635, "rerwdhjj"));
        System.out.println(myHashMap.insert(6643421, "ybrrgru"));
        System.out.println(myHashMap.insert(78567464, "thtuyuyu"));
        System.out.println(myHashMap);
        System.out.println();
        System.out.println(myHashMap.insert(878759, "iyytvtd"));
        System.out.println(myHashMap);
        System.out.println();
        System.out.println(myHashMap.insert(8651960, "gdfshsrtfh"));
        System.out.println(myHashMap.insert(598774, "'kohfvaa"));
        System.out.println(myHashMap.insert(905465, "hgmfhngfhg"));
        System.out.println(myHashMap.insert(476478, "ng gd"));
        System.out.println(myHashMap);
        System.out.println("/////////////////////////////////////////////");
    }

    @Test
    public void whenGetThenValue() {
        Integer[] integers = new Integer[myHashMap.getSize()];
        Iterator<Integer> iterator = myHashMap.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            integers[i] = iterator.next();
            i++;
        }
        System.out.println(Arrays.toString(integers));
        Assert.assertThat(myHashMap.get(integers[0]), is("hfdhf"));
        Assert.assertThat(myHashMap.get(integers[1]), is("iyytvtd"));
        Assert.assertThat(myHashMap.get(integers[2]), is("iluu8yjy"));
        Assert.assertThat(myHashMap.get(integers[3]), is("knnkjn"));
        Assert.assertThat(myHashMap.get(integers[4]), is("rerwdhjj"));
        Assert.assertThat(myHashMap.get(integers[5]), is("hjlkhk"));
        Assert.assertThat(myHashMap.get(integers[6]), is("khmluunuj"));
        Assert.assertThat(myHashMap.get(integers[7]), is("ng gd"));
        Assert.assertThat(myHashMap.get(integers[8]), is("sdfs"));
        Assert.assertThat(myHashMap.get(integers[9]), is("gdfshsrtfh"));
        Assert.assertThat(myHashMap.get(integers[10]), is("sgdgsd"));
        Assert.assertThat(myHashMap.get(integers[11]), is("hkhjghf"));
        Assert.assertThat(myHashMap.get(integers[12]), is("'kohfvaa"));

        for (Integer index : integers) {
            myHashMap.delete(index);
        }
        System.out.println(myHashMap);
        Assert.assertThat(myHashMap.getSize(), is(0));
        myHashMap.insert(null, "null");
        Assert.assertThat(myHashMap.getSize(), is(1));
        System.out.println(myHashMap);
        myHashMap.delete(null);
        System.out.println(myHashMap);
        Assert.assertThat(myHashMap.getSize(), is(0));
    }
}
