package Interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * @date: 30/03/2017 7:42 PM
 * @author: qinjiangbo@github.io
 */
public class VerticalBrackets {

    private static int valid(char[] brackets) {
        Stack<Character> stack = new Stack<>();
        int maxLen = 0, count = 0;
        for (char ch: brackets) {
            if (ch == '[') { stack.push(ch); }
            if (ch == ']') {
                stack.pop();
                count++;
                if (stack.empty()) {
                    maxLen = maxLen > count * 2 + 1 ? maxLen : count * 2 + 1;
                    count = 0;
                }
            }
        }
        return maxLen;
    }

    public static String generate(int maxLen, char[] brackets) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> strings = new Stack<>();
        int len = brackets.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            if (brackets[i] == ']') {
                stringBuilder.append(strings.pop());
                count--;
            } else {
                int hyphen = maxLen - 2 - count * 2;
                int blank = count == 0 ? 0 : count - 1;
                String s = genLine(hyphen, blank, count, true, false);
                strings.push(s);
                stringBuilder.append(s);
                count++;
                if (brackets[i] == '[' && brackets[i+1] == ']') {
                    int blank2 = count == 0 ? 0 : count - 1;
                    stringBuilder.append(genLine(hyphen, blank2, count, false, true));
                    stringBuilder.append('\n');
                    stringBuilder.append(genLine(hyphen, blank2, count, false, true));
                }
            }

        }
        String s = strings.pop();
        stringBuilder.append(s.substring(0, s.length()-1));
        return stringBuilder.toString();
    }

    private static String genLine(int hyphen, int blank, int count, boolean plusExist, boolean blankExist) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < blank; k++) {
            stringBuilder.append(' ');
        }
        if (count > 0) { stringBuilder.append('|'); }
        if (plusExist) { stringBuilder.append('+'); }
        for (int k = 0; k < hyphen; k++) {
            if (blankExist) {
                stringBuilder.append(' ');
            } else {
                stringBuilder.append('-');
            }
        }
        if (plusExist) { stringBuilder.append('+'); }
        if (count > 0) { stringBuilder.append('|'); }
        for (int k = 0; k < blank; k++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bracket = scanner.nextLine();
        char[] brackets = bracket.toCharArray();
        int maxLen = valid(brackets);
        String result = generate(maxLen, brackets);
        System.out.println(result);
    }
}
