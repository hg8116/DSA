// https://leetcode.com/problems/merge-sorted-array/description/

package MergeSortedArray88;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m - 1, end2 = n - 1, end = m + n - 1;
        while (end1 >= 0 && end2 >= 0)
            nums1[end--] = nums1[end1] > nums2[end2] ? nums1[end1--] : nums2[end2--];

        while (end2 >= 0)
            nums1[end--] = nums2[end2--];
    }
}
