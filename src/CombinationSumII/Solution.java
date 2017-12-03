package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date: 03/12/2017 8:21 PM
 * @author: qinjiangbo@github.io
 * @description:
 *      Given a collection of candidate numbers (C) and a target number (T), find all
 *      unique combinations in C where the candidate numbers sums to T.
        Each number in C may only be used once in the combination.

        Note:
            All numbers (including target) will be positive integers.
            The solution set must not contain duplicate combinations.

        For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
        A solution set is:
        [
            [1, 7],
            [1, 2, 5],
            [2, 6],
            [1, 1, 6]
        ]
 */
public class Solution {

    /**
     * 计算出集合中能组合成目标值的各种组合
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    /**
     * 利用回溯法进行求解
     * @param list
     * @param tempList
     * @param candidates
     * @param remain
     * @param start
     */
    public static void backtrack(List<List<Integer>> list, List<Integer> tempList,
                          int[] candidates, int remain, int start) {
        if (remain < 0) { return; }
        else if (remain == 0) { list.add(new ArrayList<>(tempList)); }
        else {
            for (int i = start; i < candidates.length; i++) {
                // 当前数值和前一个数值相同，因此后面组合会出现重复。
                if (i > start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                tempList.add(candidates[i]);
                backtrack(list, tempList, candidates, remain - candidates[i], i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
