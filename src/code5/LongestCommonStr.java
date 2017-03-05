package code5;

/**
 * @date: 05/03/2017 3:37 PM
 * @author: qinjiangbo@github.io
 */
public class LongestCommonStr {

    public String longestCommonStr(String s, String rs) {
        int len = s.length();
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
