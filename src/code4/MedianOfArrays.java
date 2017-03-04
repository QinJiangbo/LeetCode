package code4;

/**
 * @date: 04/03/2017 9:52 AM
 * @author: qinjiangbo@github.io
 * @description:
        There are two sorted arrays nums1 and nums2 of size m and n respectively.
        Find the median of the two sorted arrays.
        The overall run time complexity should be O(log(m+n)).

        Example 1:
            nums1 = [1, 3]
            nums2 = [2]
        The median is 2.0

        Example 2:
            nums1 = [1, 2]
            nums2 = [3, 4]
        The median is (2 + 3)/2 = 2.5
 */
public class MedianOfArrays {

    /**
     *       left_part          |        right_part
     * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     *
     * we need to ensure
     *    1) len(left_part) == len(right_part)
     *    2) max(left_part) <= min(right_part)
     *
     * which is
     *    A[j-1] <= B[j] && B[j-1] <= A[j]
     *
     * idea from https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    /**
     * This solution causes Time Limit Exceeded, so forget it!
     * @param nums1
     * @param nums2
     * @return
     */
    @Deprecated
    public double findMedianSortedArraysByMerging(int[] nums1, int[] nums2) {
        int[] nums = mergeArrays(nums1, nums2);
        int len = nums.length;
        double median = 0.0;
        if (len % 2 == 1){
            median = nums[len/2];
        } else {
            median = (double) (nums[len/2] + nums[len/2 - 1])/2;
        }
        return median;
    }

    public int[] mergeArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        for (int i = 0, j = 0, k = 0; k<(m+n); k++) {
            if (i == m) {
                nums[k] = nums2[j++];
                continue;
            }
            if (j == n) {
                nums[k] = nums1[i++];
                continue;
            }
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i++];
            } else {
                nums[k] = nums2[j++];
            }
        }
        return nums;
    }
}
