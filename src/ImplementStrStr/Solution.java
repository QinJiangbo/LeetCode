package ImplementStrStr;

/**
 * @date: 16/03/2017 12:18 AM
 * @author: qinjiangbo@github.io
 * @description:
        Implement strStr().
        Returns the index of the first occurrence of needle in haystack,
        or -1 if needle is not part of haystack.
 */
public class Solution {

    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) { return 0; }
        if (haystack.equals("")) { return -1; }
        int i, M = haystack.length();
        int j, N = needle.length();
        for (i = 0, j = 0; i < M && j < N; i++) {
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            else { i -= j; j = 0; } // 显式回退
        }
        if (j == N) return i - N;
        return -1;
    }
}
