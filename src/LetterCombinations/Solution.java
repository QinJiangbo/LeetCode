package LetterCombinations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date: 08/03/2017 9:19 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given a digit string, return all possible letter combinations
        that the number could represent.

        A mapping of digit to letters (just like on the telephone buttons)
        is given below.

                            1(∞)    2(abc)  3(def)
                            4(ghi)  5(jkl)  6(mno)
                            7(pqrs) 8(tuv)  9(wxyz)

        Input:Digit string "23"
        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */
public class Solution {

    /**
     * FIFO queue version
     * @param digits
     * @return
     */
    public List<String> letterCombinations0(String digits) {
        LinkedList<String> result = new LinkedList<>();
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        int len = digits.length();
        for (int i = 0; i < len; i++) {
            int current = Character.digit(digits.charAt(i), 10);
            while (result.peek().length() == i) { // keep consistent
                String peek = result.remove();
                for (char ch: letters[current].toCharArray()) {
                    result.add(peek + ch);
                }
            }
        }
        return result;
    }

    /**
     * backtracking version
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return backtracking(digits, 0, letters);
    }

    private List<String> backtracking(String digits, int dimension, String[] letters) {
        List<String> lists = new LinkedList<>();
        if (dimension >= digits.length()) { return new LinkedList<>(); }
        int current = Character.digit(digits.charAt(dimension), 10);
        char[] chars = letters[current].toCharArray();
        for (char ch: chars) {
            List<String> subLists = backtracking(digits, dimension + 1, letters);
            if (subLists.size() == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                lists.add(stringBuilder.append(ch).toString());
            } else {
                for (String str: subLists) {
                    StringBuilder stringBuilder = new StringBuilder();
                    lists.add(stringBuilder.append(ch).append(str).toString());
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> lists = solution.letterCombinations0("");
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
