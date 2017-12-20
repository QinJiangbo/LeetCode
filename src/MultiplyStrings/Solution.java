package MultiplyStrings;

/**
 * @date: 19/12/2017 10:16 PM
 * @author: qinjiangbo@github.io
 * @description:
 *      Given two non-negative integers num1 and num2 represented as strings,
 *      return the product of num1 and num2.

        Note:
            The length of both num1 and num2 is < 110.
            Both num1 and num2 contains only digits 0-9.
            Both num1 and num2 does not contain any leading zero.
            You must not use any built-in BigInteger library or convert the inputs to
            integer directly.
 */
public class Solution {

    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int length = length1 + length2;
        int[] results = new int[length];
        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                int result = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                results[i + j + 1] = result % 10 + results[i + j + 1];
                int temp = results[i + j + 1];
                if (results[i + j + 1] >= 10) {
                    results[i + j + 1] = temp % 10;
                    results[i + j] = temp / 10 + results[i + j];
                }
                results[i + j] = result / 10 + results[i + j];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isLeadingZero = true;
        for (int k = 0; k < length; k++) {
            if (k == length - 1) {
                isLeadingZero = false;
            }
            if (isLeadingZero && results[k] == 0) {
                continue; // skip
            } else {
                isLeadingZero = false;
                stringBuilder.append(results[k]);
            }
        }
        return stringBuilder.toString();
    }
}
