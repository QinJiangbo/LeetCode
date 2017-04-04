package LongestValidParentheses;

import java.util.Stack;

/**
 * @date: 21/03/2017 9:15 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given a string containing just the characters '(' and ')', find the length
        of the longest valid (well-formed) parentheses substring.

        For "(()", the longest valid parentheses substring is "()", which has
        length = 2.

        Another example is ")()())", where the longest valid parentheses substring
        is "()()", which has length = 4.
 */
public class Solution {

    /**
     * DP version
     * @param s
     * @return
     */
    @Deprecated
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * Time Limited Exceed Version
     * @param s
     * @return
     */
    @Deprecated
    public int longestValidParentheses0(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1); // push ahead
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { stack.push(i); }
            else {
                stack.pop();
                if (stack.empty()) { stack.push(i); }
                else { max = Math.max(max, i - stack.peek()); }
            }
        }
        return max;
    }
}
