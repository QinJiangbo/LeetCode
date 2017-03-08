package PalindromeNumber;

/**
 * @date: 06/03/2017 10:26 AM
 * @author: qinjiangbo@github.io
 * @description:
        Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution {

    public static boolean isPalindrome(int x) {
        int rx = 0, ax = x;
        while (x != 0) {
            int tail = x % 10;
            rx = rx * 10 + tail;
            x = x / 10;
        }
        System.out.println(rx);
        return ax >= 0 && rx == ax;
    }

}
