package TrappingRainWater;

/**
 * @date: 06/12/2017 9:27 AM
 * @author: qinjiangbo@github.io
 * @description:
 *      Given n non-negative integers representing an elevation map where the width
 *      of each bar is 1, compute how much water it is able to trap after raining.

        For example,
        Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Solution {

    public int trap(int[] height) {
        // 如果只有两个元素，根本不可能有容量
        if (height.length <= 2) {
            return 0;
        }
        // 容量
        int volume = 0;
        // 当前局部左边界
        int left = 0;
        for (int i = 0; i < height.length; i++) {
            // 如果找到比
            if (height[i] < left) {
                volume = volume + left - height[i];
            } else {
                int right = findRight(i, height);
                if (right > 0) {
                    left = right;
                } else {
                    left = 0;
                }
            }
        }
        return volume;
    }

    /**
     * 判断该节点有没有右边界
     * @param i
     * @param height
     * @return
     */
    private int findRight(int i, int[] height) {
        int max = 0;
        // 先判断后面有没有右边界
        for (int j = i + 1; j < height.length; j++) {
            if (height[j] >= height[i]) {
                return height[i];
            } else {
                max = max < height[j] ? height[j] : max;
            }
        }
        return max;
    }
}
