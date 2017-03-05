package StringToInteger;

/**
 * @date: 05/03/2017 7:48 PM
 * @author: qinjiangbo@github.io
 * @description:
        Implement atoi to convert a string to an integer.
        Hint: Carefully consider all possible input cases.
 */
public class Solution {

    public int myAtoi(String str) {
        // str cannot be null
        if (str == null || str.trim().equals("")) return 0;
        // get rid of spaces
        str = str.trim();
        long result = 0;
        boolean negative = false;
        int i = 0, len = str.length();

        if (len > 0) {
            // process '-' and '+'
            char firstChar = str.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                } else if (firstChar != '+') { return 0; }
                if (len == 1) { return 0; }
                i++;
            }
            while (i < len) {
                // if some char over than '9' or less than '0' break
                // and return current value
                if (str.charAt(i) > '9' || str.charAt(i) < '0') { break; }
                int digit = Character.digit(str.charAt(i++), 10);
                result = result * 10 + digit;
                // if value overflows, return the bound value of Integer
                if (result > Integer.MAX_VALUE) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                if (-result < Integer.MIN_VALUE) {
                    return negative ? Integer.MIN_VALUE : Integer.MIN_VALUE;
                }
            }
        } else { return 0; }
        return negative ? -(int) result : (int) result;
    }

    public static void main(String[] args) {

    }
}
