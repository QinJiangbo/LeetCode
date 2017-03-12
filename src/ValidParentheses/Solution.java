package ValidParentheses;

import java.util.Stack;

/**
 * @date: 11/03/2017 10:51 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given a string containing just the characters '(', ')', '{', '}',
        '[' and ']', determine if the input string is valid.

        The brackets must close in the correct order, "()" and "()[]{}" are
        all valid but "(]" and "([)]" are not.
 */
public class Solution {

    public static boolean isValid(String s) {
        Stack stack = new Stack<Character>();
        int len = s.length();
        if (s.length() == 0 || s == null) { return false; }
        for (int i = 0; i<len; i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ']') {
                if (stack.empty() || !stack.pop().equals('[')) { return false; }
            }
            if (s.charAt(i) == '}') {
                if (stack.empty() || !stack.pop().equals('{')) { return false; }
            }
            if (s.charAt(i) == ')') {
                if (stack.empty() || !stack.pop().equals('(')) { return false; }
            }
        }
        return stack.empty();
    }
}
