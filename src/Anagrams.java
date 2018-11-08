import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Palindrome {

    public static void main(String[] args) {
        String a = "Hello";
        String b = "olleh";
        String c = "anagramm";
        String d = "marganaa";
        String e = "anagram";
        String f = "margana";
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        boolean ret1 = isAnagram(c, d);
        System.out.println( (ret1) ? "Anagrams" : "Not Anagrams" );
        boolean ret2 = isAnagram(e, f);
        System.out.println( (ret2) ? "Anagrams" : "Not Anagrams" );

    }

    static boolean isAnagram(String a, String b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("Input cannot be null!");

        Map<Character, Integer> aCharCountMap = createMap(a.toLowerCase());
        Map<Character, Integer> bCharCountMap = createMap(b.toLowerCase());

        return aCharCountMap.equals(bCharCountMap);
    }

    static Map<Character, Integer> createMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char letterKey = str.charAt(i);
            if (map.keySet().contains(letterKey)) {
                int charCount = map.get(letterKey);
                map.put(letterKey, charCount + 1);
            } else {
                map.put(letterKey, 1);
            }
        }
        return map;
    }

    private static String mapToString(Map<Character, Integer> map) {
        String result = "";
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            result += (entry.getKey() +"="+ entry.getValue()+"\n");

        return result;
    }

}
