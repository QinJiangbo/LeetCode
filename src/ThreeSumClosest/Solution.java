package ThreeSumClosest;

import java.util.Arrays;

/**
 * @date: 08/03/2017 7:56 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given an array S of n integers, find three integers in S
        such that the sum is closest to a given number, target.
        Return the sum of the three integers. You may assume that
        each input would have exactly one solution.

        For example, given array S = {-1 2 1 -4}, and target = 1.
        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int gap = Integer.MAX_VALUE;
        boolean positive = true;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) { continue; }
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    if (gap > target - sum) {
                        gap = target - sum;
                        positive = false;
                    }
                    left++;
                }
                else if (sum > target) {
                    if (gap > sum - target) {
                        gap = sum - target;
                        positive = true;
                    }
                    right--;
                }
                else {
                    return sum;
                }
            }
        }
        return positive ? (target + gap) : (target - gap);
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        System.out.println(new Solution().threeSumClosest(nums, 1));
    }
}
