import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AnagramsTest {

    private String word0, word1, word2, word3;

    @Before
    public void setUp() {
        word0 = "Hello";
        word1 = "olleh";
        word2 = "anagramm";
        word3 = "marganaa";
    }

    private boolean isAnagram(String a, String b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Input error!");

        Map<Character, Integer> aCharCountMap = createMap(a.toLowerCase());
        Map<Character, Integer> bCharCountMap = createMap(b.toLowerCase());

        return aCharCountMap.equals(bCharCountMap);
    }

    private Map<Character, Integer> createMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.keySet().contains(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        return map;
    }

    @Test
    public void isAnangramTest() {
        assertTrue(isAnagram(word0, word1));
        assertFalse(isAnagram(word1, word2));
    }

}