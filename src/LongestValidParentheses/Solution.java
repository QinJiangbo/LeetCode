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

    public static int longestValidParentheses(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char ch: chs) {
            if (ch == ')') {
                if (!stack.isEmpty()) {
                    count = count + 1;
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return count * 2;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }
}
