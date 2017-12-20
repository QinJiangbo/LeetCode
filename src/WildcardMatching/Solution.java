package WildcardMatching;

import java.util.HashSet;
import java.util.Set;

/**
 * @date: 20/12/2017 11:31 AM
 * @author: qinjiangbo@github.io
 * @description:
 *      Implement wildcard pattern matching with support for '?' and '*'.

        '?' Matches any single character.
        '*' Matches any sequence of characters (including the empty sequence).

        The matching should cover the entire input string (not partial).

        The function prototype should be:
        bool isMatch(const char *s, const char *p)

        Some examples:
        isMatch("aa","a") → false
        isMatch("aa","aa") → true
        isMatch("aaa","aa") → false
        isMatch("aa", "*") → true
        isMatch("aa", "a*") → true
        isMatch("ab", "?*") → true
        isMatch("aab", "c*a*b") → false
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        Set<Integer> states = new HashSet<>();
        states.add(0);
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        for (int i = 0; i < pa.length; i++) {

        }
        return states.contains(s.length());
    }
}
