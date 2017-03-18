package SubstringWithConcatenation;

import java.util.*;

/**
 * @date: 17/03/2017 9:30 PM
 * @author: qinjiangbo@github.io
 * @description:
        You are given a string, s, and a list of words, that are all of
        the same length. Find all starting indices of substring(s) in s that is
        a concatenation of each word in words exactly once and without any intervening
        characters.

        For example, given:
            s: "barfoothefoobarman"
            words: ["foo", "bar"]

        You should return the indices: [0,9].
        (order does not matter).
 */
public class Solution {

    public static List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) { return null; }

        List<Integer> indices = new LinkedList<>();

        int wlen = words[0].length();
        int len = s.length();
        Map<String, Integer> map = new HashMap<>();
        // put words into set
        for (String word: words) {
            int count = map.containsKey(word) ? map.get(word) : 0;
            map.put(word, count + 1);
        }

        for (int i = 0; i <= (len - words.length * wlen); i++) {
            // copy of original map
            Map<String, Integer> tmp = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) {
                // find match
                String sub = s.substring(i + j * wlen , i + (j + 1) * wlen);
                // matching
                if (tmp.containsKey(sub)) {
                    int count = tmp.get(sub);
                    // remove items will be faster
                    if (count == 1) { tmp.remove(sub); }
                    else { tmp.put(sub, count - 1); }
                    if (tmp.isEmpty()) { indices.add(i); continue; }
                } else { break; }
            }

        }
        return indices;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaa";
        String[] words = { "aa","aa","aa"};
        System.out.println(findSubstring(s, words).toString());
//        Map<String, Integer> map = new HashMap<>();
//        map.put("one", 1);
//        map.put("two", 2);
//        map.put("three", 3);
//
//        System.out.println(sum(map));
    }
}
