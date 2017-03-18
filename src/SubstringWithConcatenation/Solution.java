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
            int count = map.get(word) == null ? 0 : map.get(word);
            map.put(word, count + 1);
        }

        Map<String, Integer> tmp = new HashMap<>();
        boolean started = false;
        for (int i = 0; i < (len - wlen + 1); i++) {
            int j = i + wlen;
            if (map.containsKey(s.substring(i, j))) {
                if (tmp.containsKey(s.substring(i, j)) &&
                        tmp.get(s.substring(i, j)).equals(map.get(s.substring(i, j)))) {
                    started = false;
                    i = i - sum(tmp) * wlen;
                    tmp.clear();
                }
                else {
                    started = true;
                    int count = tmp.get(s.substring(i, j)) == null ? 0 : tmp.get(s.substring(i,j));
                    tmp.put(s.substring(i, j), count + 1);
                    i = j;
                    if (sum(tmp) == words.length){
                        indices.add(i - words.length * wlen);
                        started = false;
                        tmp.clear();
                        i = i - words.length * wlen;
                        continue;
                    }
                    i--;
                }
            }
            else {
                if (started) {
                    i = i - sum(tmp) * wlen;
                    tmp.clear();
                }
            }
        }
        return indices;
    }

    private static int sum(Map<String, Integer> map) {
        int sum = 0;
        for (Integer integer: map.values()) {
            sum = sum +  integer;
        }
        return sum;
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
