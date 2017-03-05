package LongestNonRepeatStr;

import java.util.HashSet;

/**
 * @date: 03/03/2017 10:49 PM
 * @author: qinjiangbo@github.io
 * @description:
 *      Given a string, find the length of the longest substring without
 *      repeating characters.
        Examples:
            Given "abcabcbb", the answer is "abc", which the length is 3.
            Given "bbbbb", the answer is "b", with the length of 1.
            Given "pwwkew", the answer is "wke", with the length of 3.
            Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int len = s.length();
        int max = 0;
        for(int i = 0, j = 0; j < len; j++) { // j is quick pointer
            // i is slow pointer
            if (hashSet.contains(s.charAt(j))){
                hashSet.remove(s.charAt(i++));
                j--; // wait i for a loop
            } else {
                hashSet.add(s.charAt(j));
                max = max > hashSet.size() ? max : hashSet.size();
            }
        }
        return max;
    }

}
