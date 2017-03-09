package FourSum;

import java.util.*;

/**
 * @date: 09/03/2017 12:54 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given an array S of n integers, are there elements a, b, c,
        and d in S such that a + b + c + d = target? Find all unique
        quadruplets in the array which gives the sum of target.

        Note: The solution set must not contain duplicate quadruplets.

        For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

        A solution set is:
        [
            [-1,  0, 0, 1],
            [-2, -1, 1, 2],
            [-2,  0, 0, 2]
        ]
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> intSet = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums);

        // similar to 3Sum solutions, check from 0 to len-3, then we go through all
        // possible combinations of the numbers, remember to add SKIP conditions
        // for removing duplicates
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) { continue; } // SKIP
            for (int j = i+1; j < len - 2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) { continue; } // SKIP
                int left = j + 1, right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) { left++; }
                    else if (sum > target) { right--; }
                    else {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        intSet.add(list);
                        while (left < right && nums[left] == nums[left+1]) { left++; }
                        while (left < right && nums[right] == nums[right-1]) { right--; }
                        left++; right--;
                    }
                }
            }
        }
        return intSet;
    }
}
