package LongestPalindromicStr;


/**
 * @date: 04/03/2017 1:19 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given a string s, find the longest palindromic substring in s.
        You may assume that the maximum length of s is 1000.

        Example:
            Input: "babad"
            Output: "bab"
        Note: "aba" is also a valid answer.

        Example:
            Input: "cbbd"
            Output: "bb"
 */
public class Solution {

    int start = -1, offset = 0;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) { return s; }
        for (int i = 0; i<len-1; i++) {
            extendPalindrom(s, i, i); // assume odd length
            extendPalindrom(s, i, i+1); // assume even length
        }
        return s.substring(start, start + offset);
    }

    /**
     * very simple solutions, just extent the palindromic string from very point
     *        <- | ->
     * A D G H K H D K D H K S F A
     * @param s
     * @param m move left
     * @param n move right
     */
    private void extendPalindrom(String s, int m, int n) {
        int len = s.length();
        while (m >= 0 && n <len && s.charAt(m) == s.charAt(n)) {
            m--;
            n++;
        }
        if (offset < (n - m - 1)) {
            offset = n - m - 1;
            start = m + 1;
        }
    }

}
