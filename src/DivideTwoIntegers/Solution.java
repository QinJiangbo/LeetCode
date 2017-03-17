package DivideTwoIntegers;

/**
 * @date: 17/03/2017 4:24 PM
 * @author: qinjiangbo@github.io
 * @description:
        Divide two integers without using multiplication, division and mod operator.
        If it is overflow, return MAX_INT.
 */
public class Solution {

    /**
     * Suppose we want to divide 15 by 3, so 15 is dividend and 3 is divisor.
     * Well, division simply requires us to find how many times we can subtract
     * the divisor from the the dividend without making the dividend negative.
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {

        // mark the result symbol
        boolean positive = true;

        // case 1: divisor == 0, cause MAX_VALUE
        // case 2: dividend == MIN_VALUE and divisor == -1, cause MAX_VALUE
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        if ((dividend > 0) ^ (divisor > 0)) {
            positive = false;
        }
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0, count = 0;

        // right shift divisor until it is greater than dividend
        while (dvd > dvs) {
            dvs = dvs << 1; // "<< 1" means multiply 2
            count++;
        }

        // subtract divisor from dividend
        while (count >= 0) {
            if (dvd >= dvs) {
                dvd = dvd - dvs;
                result = result + (1 << count);
            }
            dvs = (dvs >> 1);
            count--;
        }

        return positive ? result : -result;
    }
}
