package LongestCommonPrefix;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

/**
 * @date: 07/03/2017 3:18 PM
 * @author: qinjiangbo@github.io
 * @description:
        Write a function to find the longest common prefix string amongst
        an array of strings.

        Note: the problem is to find the longest common prefix of all strings
        Example 1:
            Input: ["a", "a", "b"]
            Output: ""

        Example 2:
            Input: ["acd", "acdb", "agd", "ayh"]
            Output: "a" (not "ac")
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { return ""; }
        if (strs.length == 1) { return strs[0]; }
        Arrays.sort(strs); // sort the array
        return findCommonPrefix(strs[0], strs[strs.length-1]);
    }

    private static String findCommonPrefix(String s, String t) {
        int len = Math.min(s.length(), t.length());
        String prefix = "";
        for (int i = 0; i < len; i++) {
            prefix = s.substring(0, i);
            if (s.charAt(i) == t.charAt(i)) {
                prefix = s.substring(0, i+1);
            } else { break; }
        }
        return prefix;
    }

}
