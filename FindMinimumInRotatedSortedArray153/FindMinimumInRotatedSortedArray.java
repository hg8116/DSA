// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

package FindMinimumInRotatedSortedArray153;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return nums[findPivot(nums, 0, nums.length - 1) + 1];
    }

    int findPivot(int[] nums, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1])
                return mid;
            else if (mid > start && nums[mid] < nums[mid - 1])
                return mid - 1;
            else if (nums[mid] >= nums[start])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }
}
