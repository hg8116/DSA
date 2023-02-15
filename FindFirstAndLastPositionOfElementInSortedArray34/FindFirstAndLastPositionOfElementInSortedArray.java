// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

package FindFirstAndLastPositionOfElementInSortedArray34;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {findLeft(nums, 0, n - 1, target), findRight(nums, 0, n - 1, target)};
        return ans;
    }

    int findLeft(int[] arr, int start, int end, int target) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
            if (arr[mid] == target)
                ans = mid;
        }

        return ans;
    }

    int findRight(int[] arr, int start, int end, int target) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
            if (arr[mid] == target)
                ans = mid;
        }

        return ans;
    }
}
