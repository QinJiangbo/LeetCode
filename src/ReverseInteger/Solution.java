package ReverseInteger;

/**
 * @date: 05/03/2017 6:45 PM
 * @author: qinjiangbo@github.io
 * @description:
        Reverse digits of an integer.

        Example1: x = 123, return 321
        Example2: x = -123, return -321

        Note:
            The input is assumed to be a 32-bit signed integer.
            Your function should return 0 when the reversed integer overflows.
 */
public class Solution {

    /**
     * divide by 10 step by step, the first remainder [ last part] will times 10 firstly,
     * the last remainder [ first part ] will times last, so the number is reversed
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            // overflow will break the condition
            if ((newResult - tail) / 10 != result) { return 0; }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

}
