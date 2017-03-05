package code5;


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
public class LongestPalindromicStr {

    /**
     * Solutions:
     *      1. Since it is palindromic string, so we can also find it in reverse string
     *      2. reverse string s
     *      3. find the longest common string of them
     *      4. that's the longest palindromic string
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        String rs = new StringBuffer(s).reverse().toString();
        // find the longest common string
        int start = -1, offset = 0;
        for (int i = 0; i<len; i++) {
            for (int j = 0; j<len; j++) {
                // if the characters are equal
                if (s.charAt(i) == rs.charAt(j)) {
                    int k = 1;
                    while ((i+k) < len && (j+k) < len) {
                        if (s.charAt(i+k) == rs.charAt(j+k)) k++;
                        else break;
                    }
                    if (offset < k) { start = i; offset = k; }
                }
            }
        }
        return s.substring(start, start + offset);
    }
}
