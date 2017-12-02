package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date: 02/12/2017 10:55 AM
 * @author: qinjiangbo@github.io
 * @description:
 *      Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 *      find all unique combinations in C where the candidate numbers sums to T.

        The same repeated number may be chosen from C unlimited number of times.

        Note:
            All numbers (including target) will be positive integers.
            The solution set must not contain duplicate combinations.

        For example, given candidate set [2, 3, 6, 7] and target 7,
        A solution set is:
            [
                [7],
                [2, 2, 3]
            ]
 */
public class Solution {

    /**
     * 计算出集合中能组合成目标值的各种组合
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        // 先排好序
        Arrays.sort(candidates);
        // 进行回溯处理
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    /**
     * 使用回溯法进行求解
     * @param list
     * @param tempList
     * @param candidates
     * @param remain
     * @param start
     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList,
                           int[] candidates, int remain, int start) {
        if (remain < 0) {
            // 说明这个方案不成立，直接返回进行下一个尝试
            return;
        } else if (remain == 0) {
            // 说明刚好可以凑成目标值，直接添加
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                // 从i开始是因为我们能使用重复的元素
                backtrack(list, tempList, candidates, remain - candidates[i], i);
                // 需要清空tempList以便于后面复用
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
