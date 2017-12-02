package CountAndSay;

/**
 * @date: 02/12/2017 10:11 AM
 * @author: qinjiangbo@github.io
 * @description:
 *      The count-and-say sequence is the sequence of integers with the first five terms
 *      as following:

        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221

        1 is read off as "one 1" or 11.
        11 is read off as "two 1s" or 21.
        21 is read off as "one 2, then one 1" or 1211.

        Given an integer n, generate the nth term of the count-and-say sequence.
        Note: Each term of the sequence of integers will be represented as a string.

        Example 1:
            Input: 1
            Output: "1"

        Example 2:
            Input: 4
            Output: "1211"
 */
public class Solution {

    /**
     * 根据前面给出的字符串找到规律，然后给出第N个数字对应的字符串
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n <= 0) { return null; }
        int i = 1;
        String string = "";
        while (i <= n) {
            if (i == 1) {
                string = "1";
            } else {
                string = convert(string);
            }
            i++;
        }
        return string;
    }

    /**
     * 对前一个字符串进行CountAndSay
     * @param str
     * @return
     */
    public String convert(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int lastIndex = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i-1)) {
                stringBuffer.append(i-lastIndex).append(str.charAt(i-1));
                lastIndex = i;
            }
        }
        // 加上最后断尾的
        stringBuffer.append(str.length() - lastIndex).append(str.charAt(str.length() - 1));
        return stringBuffer.toString();
    }
}
