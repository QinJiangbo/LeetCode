package SearchForARange;

/**
 * @date: 20/11/2017
 * @author: qinjiangbo@github.io
 * @description:
 *      Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
        Your algorithm's runtime complexity must be in the order of O(log n).
        If the target is not found in the array, return [-1, -1].
        For example,
        Given [5, 7, 7, 8, 8, 10] and target value 8,
        return [3, 4].
 */
public class Solution {

    public int[] searchRange0(int[] nums, int target) {
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return new int[]{-1, -1};
        }

        for (int j = nums.length - 1; j >= start; j--) {
            if (nums[j] == target) {
                end = j;
                break;
            }
        }
        return new int[]{start, end};
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ranges = {-1, -1};
        int left = findMostLeftOrRight(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return ranges;
        }
        ranges[0] = left;
        ranges[1] = findMostLeftOrRight(nums, target, false) - 1;

        return ranges;
    }

    /**
     * 查找目标值最左或者最右的索引
     * @param nums
     * @param target
     * @param left
     * @return
     */
    public int findMostLeftOrRight(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
