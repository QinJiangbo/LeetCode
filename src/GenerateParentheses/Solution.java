package GenerateParentheses;

import java.util.Arrays;
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
     Let us consider an example to get clear view:
     f(0): ""
     f(1): "("f(0)")"
     f(2): "("f(0)")"f(1), "("f(1)")"
     f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"
     f(4): "("f(0)")"f(3), "("f(1)")"f(2), "("f(2)")"f(1), "("f(3)")"
     So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.generateParenthesis(4).toArray()));
    }
}
