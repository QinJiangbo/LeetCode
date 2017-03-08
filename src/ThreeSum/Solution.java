package ThreeSum;

import java.util.*;

/**
 * @date: 08/03/2017 3:56 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given an array S of n integers, are there elements a, b, c in S
        such that a + b + c = 0? Find all unique triplets in the array
        which gives the sum of zero.

        Note: The solution set must not contain duplicate triplets.

        For example, given array S = [-1, 0, 1, 2, -1, -4],
        A solution set is:
            [
                [-1, 0, 1],
                [-1, -1, 2]
            ]
 */
public class Solution {

    /**
     * ACCEPT version
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> intSet = new LinkedList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) { left++; }
                else if (sum > 0) { right--; }
                else {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    intSet.add(list);
                    while (left < right && nums[left] == nums[left + 1]) { left++; }
                    while (left < right && nums[right] == nums[right - 1]) { right--; }
                    left++; right--;
                }

            }
        }
        return intSet;
    }

    /**
     * Time Limited Exceed version
     * @param nums
     * @return
     */
    @Deprecated
    public List<List<Integer>> threeSum0(int[] nums) {
        int len = nums.length;
        List<List<Integer>> intSet = new ArrayList<>();
        for (int i = 0; i<len; i++) {
            int target = -nums[i];
            List<Integer> set = new LinkedList<>();
            for (int j = 0; j<len; j++) {
                if (j == i) continue;
                if (set.contains(target - nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[j]);
                    list.add(target - nums[j]);
                    list.add(-target);
                    if (!contains(intSet, list)) {
                        intSet.add(list);
                    }
                }
                set.add(nums[j]);
            }
        }
        return intSet;
    }

    private boolean contains(List<List<Integer>> lists, List<Integer> list) {
        boolean flag = false;
        for (List<Integer> list0: lists) {
                Collections.sort(list0);
                Collections.sort(list);
                flag = list.get(0) == list0.get(0)
                        && list.get(1) == list0.get(1)
                        && list.get(2) == list0.get(2);
                if (flag) break;
        }
        return flag;
    }
}
