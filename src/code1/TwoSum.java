package code1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date: 24/02/2017 12:34 AM
 * @author: qinjiangbo@github.io
 * @description:
 *      Given an array of integers, return indices of the two numbers
 *      such that they add up to a specific target.
        You may assume that each input would have exactly one solution,
        and you may not use the same element twice.
        Example:
            Given nums = [2, 7, 11, 15], target = 9,
            Because nums[0] + nums[1] = 2 + 7 = 9,
            return [0, 1].
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 8, 10};
        int target = 13;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
