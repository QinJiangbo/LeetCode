package RegExMatching;

import java.util.*;

/**
 * @date: 06/03/2017 10:38 AM
 * @author: qinjiangbo@github.io
 * @description:
        Implement regular expression matching with support for '.' and '*'.

        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.
        The matching should cover the entire input string (not partial).
        The function prototype should be:
        bool isMatch(const char *s, const char *p)

        Some examples:
            isMatch("aa","a") → false
            isMatch("aa","aa") → true
            isMatch("aaa","aa") → false
            isMatch("aa", "a*") → true
            isMatch("aa", ".*") → true
            isMatch("ab", ".*") → true
            isMatch("aab", "c*a*b") → true
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        Set<Integer> states = new HashSet<>(); // store the states
        states.add(0); // init state
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        for (int i = 0; i < pa.length; i++) {
            if (pa[i] == '*') continue; // skip '*' symbol
            boolean marked = i < pa.length - 1 && pa[i + 1] == '*';
            Set<Integer> nexts = new HashSet<>();
            for (int state : states) {
                if (state >= sa.length) {
                    if (marked) {
                        nexts.add(state);
                    }
                } else if (marked) {
                    nexts.add(state); // add item itself, and it's optional
                    for (int j = state; j < sa.length
                            && (pa[i] == '.' || pa[i] == sa[j]); j++) {
                        nexts.add(j + 1);
                    }
                } else { // match '.'
                    if (pa[i] == '.' || pa[i] == sa[state]) {
                        nexts.add(state + 1);
                    }
                }
            }
            states = nexts;
        }
        return states.contains(sa.length);
    }
}
