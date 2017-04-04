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
     * Time Limited Exceed Version
     * @param s
     * @return
     */
    @Deprecated
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { stack.push(i); }
            else {
                if (stack.isEmpty()) { left = i; }
                else {
                    stack.pop();
                    if (stack.isEmpty()) { max = Math.max(max, i - left); }
                    else { max = Math.max(max, i - stack.peek()); }
                }
            }
        }
        return max;
    }
}
