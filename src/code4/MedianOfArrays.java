package code4;

/**
 * @date: 04/03/2017 9:52 AM
 * @author: qinjiangbo@github.io
 * @description:
        There are two sorted arrays nums1 and nums2 of size m and n respectively.
        Find the median of the two sorted arrays.
        The overall run time complexity should be O(log (m+n)).

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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
