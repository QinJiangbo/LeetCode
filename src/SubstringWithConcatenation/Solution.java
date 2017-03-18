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

        List<Integer> indeces = new LinkedList<>();

        int wlen = words[0].length();
        int len = s.length();
        Set<String> set = new HashSet<>();
        // put words into set
        for (String word: words) {
            set.add(word);
        }

        Set<String> tmp = new HashSet<>();
        boolean started = false;
        for (int i = 0; i < (len - wlen + 1); i++) {
            int j = i + wlen;
            if (set.contains(s.substring(i, j))) {
                if (tmp.contains(s.substring(i, j))) {
                    started = false;
                    i = i - tmp.size() * wlen;
                    tmp.clear();
                }
                else {
                    started = true;
                    tmp.add(s.substring(i, j));
                    i = j;
                    if (tmp.size() == words.length){
                        indeces.add(i - words.length * wlen);
                        started = false;
                        tmp.clear();
                        i = i - (words.length - 1) * wlen;
                    }
                    i--;
                }
            }
            else {
                if (started) {
                    i = i - tmp.size() * wlen;
                    tmp.clear();
                }
            }
        }
        return indeces;
    }

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = { "bar","foo","the" };
        System.out.println(findSubstring(s, words).toString());
    }
}
