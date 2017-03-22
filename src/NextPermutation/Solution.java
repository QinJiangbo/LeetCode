package NextPermutation;

import java.util.Arrays;

/**
 * @date: 19/03/2017 1:45 AM
 * @author: qinjiangbo@github.io
 * @description:
        Implement next permutation, which rearranges numbers into the
        lexicographically next greater permutation of numbers.

        If such arrangement is not possible, it must rearrange it as the
        lowest possible order (ie, sorted in ascending order).

        The replacement must be in-place, do not allocate extra memory.

        Here are some examples. Inputs are in the left-hand column and its
        corresponding outputs are in the right-hand column.
            1,2,3 → 1,3,2
            3,2,1 → 1,2,3
            1,1,5 → 1,5,1
 */
public class Solution {

    /**
     * find next permutation for the nums, the main idea of this problem is to
     * find the least numbers which are over than the current one
     * eg. 1,2,3 --> 1,3,2[least one larger than 123]
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) { return; }
        int i = nums.length - 1; // last index of the array
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            } // find the first one larger than nums[i-1]
            swap(nums, j, i-1);
        }
        reverse(nums, i, nums.length - 1);
    }

    /**
     * swap two numbers in the array
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * reverse the order of the array from index i...j
     * @param nums
     * @param i
     * @param j
     */
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
