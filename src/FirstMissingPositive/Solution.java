package FirstMissingPositive;

/**
 * @date: 05/12/2017 9:13 PM
 * @author: qinjiangbo@github.io
 * @description:
 *      Given an unsorted integer array, find the first missing positive integer.

        For example,
        Given [1,2,0] return 3,
        and [3,4,-1,1] return 2.

        Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution {

    /**
     * 找到第一个正整数
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 一直调整到当前值满足nums[nums[i]-1]==nums[i]为止
            while (nums[i] > 0 && nums[i] <= nums.length
                    && nums[nums[i] - 1] != nums[i]) {
                swap(i, nums[i] - 1, nums);
            }
        }
        int missing = nums.length;
        // 哪一个地方的值缺了就选择这一块
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return missing + 1;
    }

    /**
     * 交换数组里面两个数的值
     * @param i
     * @param j
     * @param nums
     */
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
