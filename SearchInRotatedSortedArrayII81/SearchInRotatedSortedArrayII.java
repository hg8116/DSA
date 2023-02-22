// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

package SearchInRotatedSortedArrayII81;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;

        while (start < end) {
            while (start < end && nums[start] == nums[start + 1])
                start++;
            while (start < end && nums[end] == nums[end - 1])
                end--;

            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                if (target > nums[mid] || target <= nums[end])
                    start = mid + 1;
                else
                    end = mid;
            } else {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid;
            }
        }

        if (start == end && target != nums[start])
            return false;
        return true;
    }
}
