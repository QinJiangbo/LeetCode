package GenerateParentheses;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @date: 12/03/2017 7:39 PM
 * @author: qinjiangbo@github.io
   @description:
        Given n pairs of parentheses, write a function to generate all combinations
        of well-formed parentheses.

        For example, given n = 3, a solution set is:

           [
               "((()))",
               "(()())",
               "(())()",
               "()(())",
               "()()()"
           ]
 */
public class Solution {

    /**
     * Back Tracking version
     * The idea here is to only add '(' and ')' that we know will guarantee us
     * a solution (instead of adding 1 too many close). Once we add a '(' we will
     * then discard it and try a ')' which can only close a valid '('. Each of
     * these steps are recursively called.
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int n) {
        if (open == n && close == n) {
            list.add(str);
            return;
        }

        if (open < n) {
            backtrack(list, str + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, n);
        }
    }

    /**
     * Dynamic Planning (DP) version
     Let us consider an example to get clear view:
     f(0): ""
     f(1): "("f(0)")"f(0)
     f(2): "("f(0)")"f(1), "("f(1)")"f(0)
     f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"f(0)
     f(4): "("f(0)")"f(3), "("f(1)")"f(2), "("f(2)")"f(1), "("f(3)")"f(0)
     So f(n) = "("f(0)")"f(n-1) "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"f(0)
     * @param n
     * @return
     */
    public List<String> generateParenthesis0(int n) {
        List<List<String>> lists = new LinkedList<>();
        lists.add(Collections.singletonList(""));

        // construct all combinations
        for (int i = 1; i <= n; i++) {
            List<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                for (String first: lists.get(j)) { // f(j)
                    for (String second: lists.get(i-1-j)) { // f(i-j-1)
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            lists.add(list);
        }
        return lists.get(lists.size() - 1);
    }
}
