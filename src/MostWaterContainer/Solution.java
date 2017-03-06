package MostWaterContainer;

/**
 * @date: 06/03/2017 5:29 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given n non-negative integers a1, a2, ..., an,
        where each represents a point at coordinate (i, ai).
        n vertical lines are drawn such that the two endpoints of line i
        is at (i, ai) and (i, 0). Find two lines, which together with x-axis
        forms a container, such that the container contains the most water.

        Note: You may not slant the container and n is at least 2.
 */
public class Solution {

    /**
       y ^
         |
         |     a2
         |     |  a3          an
         |  a1 |  |     a5    |
         |  |  |  |  a4 |     |
         |  |  |  |  |  | ..  |
         --------------------------->
         0   1  2  3  4  5 ..  n     x
     get the total water for all the bars problem, It actually is to find
     the any 2 bars ai, aj, which hold most water together with x-axis.
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        int i = 0, j = len - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) { i++; } else { j--; }
        }
        return maxArea;
    }

    /**
     *  Time Limit Exceeded version
     * @param height
     * @return
     */
    @Deprecated
    public int maxArea0(int[] height) {
        int len = height.length;
        int maxArea = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int area = minHeight * (j - i);
                maxArea = maxArea > area ? maxArea : area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = { 2, 3, 10, 5, 7, 8, 9};
        System.out.println(maxArea(height));
    }

}
